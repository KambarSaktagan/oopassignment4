package service;

import model.*;
import repository.*;
import exception.InvalidInputException;

public class RentalService {

    private final CarRepositoryInterface carRepo;

    public void addCar(Car car) {
        car.validate();
        carRepo.create(car);
    }

    public void showCars() {
        carRepo.getAll().forEach(Car::printInfo);
    }

    public void updateCarPrice(int id, double newPrice) {
        if (newPrice <= 0)
            throw new InvalidInputException("New price must be positive");

        carRepo.updatePrice(id, newPrice);
    }

    public void deleteCar(int id) {
        carRepo.delete(id);
    }

    public RentalService(CarRepositoryInterface carRepo) {
        this.carRepo = carRepo;
    }

    public void showCarsSortedByPrice() {
        var cars = carRepo.getAll();
        utils.SortingUtils.sortByPrice(cars);
        cars.forEach(Car::printInfo);
    }



}
