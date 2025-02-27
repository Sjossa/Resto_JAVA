package modification;

import formatage.Formatting;
import interaction.EmployeeService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import main.Employee;

public class EmployeeModifier extends RestaurantModifier {

    public static boolean addEmployee(Scanner scanner, int restaurantId) {
        String filePath = "Restaurants/" + restaurantId + "/restaurant.txt";
        File file = new File(filePath);

        Employee employee = EmployeeService.createEmployee(scanner);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(Formatting.formatEmployee(employee) + System.lineSeparator());
            System.out.println("Employé ajouté avec succès !");
            return true;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier.");
            return false;
        }
    }

    public static boolean modifyEmployee(Scanner scanner, int restaurantId) {
        return modifyElement(scanner, restaurantId, "Employé ID :", "Nom :", "le nom de l'employé");
    }

    public static boolean modifyEmployeeFirstName(Scanner scanner, int restaurantId) {
        return modifyElement(scanner, restaurantId, "Employé ID :", "Prénom :", "le prénom de l'employé");
    }

    public static boolean modifyEmployeeSalary(Scanner scanner, int restaurantId) {
        return modifyElement(scanner, restaurantId, "Employé ID :", "Salaire :", "le salaire de l'employé");
    }

    public static boolean DeleteEmploye(Scanner scanner, int restaurantId) {
        return deleteElement(scanner,restaurantId,"Employé ID :","Salaire : ","Employé ID :");
    }

    public static void EmployeeMenu(Scanner scanner, int restaurantId) {
        System.out.println("1 - Modifier le nom d'un employé");
        System.out.println("2 - Modifier le salaire d'un employé");
        System.out.println("3 - Modifier le prénom d'un employé");
        System.out.println("4 - Ajouter un employé");
        System.out.println("5 - Supprimer  un employé");


        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> modifyEmployee(scanner, restaurantId);
            case 2 -> modifyEmployeeSalary(scanner, restaurantId);
            case 3 -> modifyEmployeeFirstName(scanner, restaurantId);
            case 4 -> {
                boolean success = addEmployee(scanner, restaurantId);
                if (!success) {
                    System.out.println("Erreur lors de l'ajout de l'employé.");
                }
            }
            case 5 ->  DeleteEmploye(scanner, restaurantId);


            default -> System.out.println("Choix invalide.");
        }
    }
}
