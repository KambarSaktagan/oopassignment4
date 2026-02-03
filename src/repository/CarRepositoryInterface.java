package repository;

import model.Car;

public interface CarRepositoryInterface extends CrudRepository<Car> {
    void updatePrice(int id, double newPrice);
}
