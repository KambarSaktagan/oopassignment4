package repository;


import model.*;
import utils.DatabaseConnection;
import exception.*;
import java.sql.*;
import java.util.*;


public class CarRepository implements CarRepositoryInterface {


    public void create(Car car) {
        String sql = "INSERT INTO cars(name,type,price_per_day,available) VALUES (?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, car.getName());
            ps.setString(2, car.getEntityType());
            ps.setDouble(3, car.getPricePerDay());
            ps.setBoolean(4, car.isAvailable());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }


    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";


        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                String type = rs.getString("type");
                Car car = type.equals("LUXURY")
                        ? new LuxuryCar(rs.getInt("id"), rs.getString("name"), rs.getDouble("price_per_day"), rs.getBoolean("available"))
                        : new EconomyCar(rs.getInt("id"), rs.getString("name"), rs.getDouble("price_per_day"), rs.getBoolean("available"));
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
        return cars;
    }


    public void delete(int id) {
        String sql = "DELETE FROM cars WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0)
                throw new ResourceNotFoundException("Car not found");
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public void updatePrice(int id, double newPrice) {
        String sql = "UPDATE cars SET price_per_day = ? WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, newPrice);
            ps.setInt(2, id);

            if (ps.executeUpdate() == 0)
                throw new ResourceNotFoundException("Car not found for update");

        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

}