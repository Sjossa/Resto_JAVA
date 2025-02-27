package interaction;

import gestion.RestaurantDAO;
import java.util.Scanner;
import main.Dish;
import main.Employee;
import main.Restaurant;

public class RestaurantService {

    public static void createRestaurant(Scanner scanner) {
        System.out.println("\n📌 Création d'un nouveau restaurant");

        System.out.print("Nom du restaurant : ");
        String name = scanner.nextLine().trim();

        System.out.print("Adresse du restaurant : ");
        String address = scanner.nextLine().trim();

        int id = RestaurantDAO.generateNewId();
        Restaurant restaurant = new Restaurant(id, name, address);


        while (true) {
            System.out.print("Ajouter un employé ? (oui/non) : ");
            String response = scanner.nextLine().trim();
            if (response.equalsIgnoreCase("oui")) {
                Employee employee = EmployeeService.createEmployee(scanner);
                restaurant.addEmployee(employee);
            } else {
                break;
            }
        }

       
        while (true) {
            System.out.print("Ajouter un plat ? (oui/non) : ");
            String response = scanner.nextLine().trim();
            if (response.equalsIgnoreCase("oui")) {
                Dish dish = Dish.createDish(scanner);
                restaurant.addDish(dish);
            } else {
                break;
            }
        }

        // Sauvegarde du restaurant
        RestaurantDAO.saveRestaurant(restaurant);
        System.out.println("🎉 Le restaurant \"" + name + "\" a été créé avec succès ! ID : " + id);
    }
}
