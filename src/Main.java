import model.*;
import repository.CarRepository;
import service.RentalService;
import utils.ReflectionUtils;

public class Main {
    public static void main(String[] args) {

        RentalService service = new RentalService(new CarRepository());

        try {

            Car c1 = new EconomyCar(0, "Toyota Corolla", 50, true);
            Car c2 = new LuxuryCar(0, "Mercedes S-Class", 150, true);

            service.addCar(c1);
            service.addCar(c2);

            System.out.println("=== AFTER INSERT ===");
            service.showCars();

            System.out.println("\n=== UPDATE PRICE OF CAR ID 1 ===");
            service.updateCarPrice(1, 80);
            service.showCars();

            System.out.println("\n=== DELETE CAR ID 2 ===");
            service.deleteCar(2);
            service.showCars();

            System.out.println("\n=== SORTED BY PRICE (LAMBDA) ===");
            service.showCarsSortedByPrice();

            System.out.println("\n=== REFLECTION OUTPUT ===");
            ReflectionUtils.inspectClass(EconomyCar.class);

        } catch (RuntimeException e) {
            System.out.println("{ \"error\": \"" + e.getMessage() + "\" }");
        }
    }
}
