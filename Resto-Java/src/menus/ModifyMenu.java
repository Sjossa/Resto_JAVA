package menus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import modification.EmployeeModifier;
import modification.DishModifier;
import modification.RestaurantModifier;

public class ModifyMenu {

    public static void modifyRestaurant(final Scanner scanner, int restaurantId, String restaurantName) {
        System.out.println("\nModification du restaurant : " + restaurantName);

        boolean continueLoop = true;

        while (continueLoop) {
            displayMenu();
            System.out.print("Votre choix : ");

            int choice = readUserInput(scanner);

            if (choice == 0) {
                System.out.println("Retour au menu principal...");
                continueLoop = false;
            } else {
                handleChoice(scanner, restaurantId, choice);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu de modification du restaurant :");
        System.out.println("1 - Modifier le nom du restaurant");
        System.out.println("2 - Modifier l'adresse");
        System.out.println("3 - Modifier les employés");
        System.out.println("4 - Modifier les plats");
        System.out.println("0 - Retour au menu principal");
    }

    private static int readUserInput(final Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide. Veuillez entrer un chiffre valide.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return choice;
    }

    private static void handleChoice(final Scanner scanner, int restaurantId, int choice) {
        Map<Integer, Runnable> actions = new HashMap<>();

        actions.put(1, () -> RestaurantModifier.modifyRestaurantInfo(scanner, restaurantId, "Nom du restaurant :", "Nom du restaurant", false));
        actions.put(2, () -> RestaurantModifier.modifyRestaurantInfo(scanner, restaurantId, "Adresse :", "Adresse du restaurant", false));
        actions.put(3, () -> EmployeeModifier.EmployeeMenu(scanner, restaurantId));
        actions.put(4, () -> DishModifier.DishMenu(scanner, restaurantId));

        actions.getOrDefault(choice, () -> System.out.println("Choix invalide, veuillez réessayer.")).run();
    }
}
