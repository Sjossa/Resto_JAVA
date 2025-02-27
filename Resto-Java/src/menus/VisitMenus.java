package menus;

import addon.Exit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VisitMenus {

    // Method to display the visit menu
    public static void displayVisitMenu(Scanner scanner) {

        File restaurantFolder = new File("restaurants");
        File[] files = restaurantFolder.listFiles(File::isDirectory);

        if (files == null || files.length == 0) {
            System.out.println("Aucun restaurant trouvé.");
            return;
        }

        Map<Integer, String> restaurants = new HashMap<>();

        for (File file : files) {
            int restaurantId = extractID(file.getName());
            if (restaurantId != -1) {
                String restaurantInfo = readRestaurantInfo(file);
                restaurants.put(restaurantId, restaurantInfo);
            }
        }

        // Display the list of available restaurants
        System.out.println("\nListe des restaurants disponibles :");
        displayRestaurantList(restaurants);

        // Choose a restaurant
        System.out.println("0 - Retour");
        int choice;
        do {
            System.out.print("Sélectionnez un restaurant par ID : ");
            choice = readUserInput(scanner);

            if (restaurants.containsKey(choice)) {
                displayRestaurantOptions(scanner, choice, restaurants.get(choice));
            } else if (choice != 0) {
                System.out.println("Choix invalide, veuillez réessayer.");
            }

        } while (choice != 0);

        System.out.println("Retour au menu principal...");
    }

    private static void displayRestaurantList(Map<Integer, String> restaurants) {
        for (Map.Entry<Integer, String> entry : restaurants.entrySet()) {
            int id = entry.getKey();
            String info = entry.getValue();
            String restaurantName = extractRestaurantName(info);
            System.out.println(id + " - " + restaurantName);
        }
    }

    public static void displayRestaurantOptions(Scanner scanner, int restaurantId, String restaurantInfo) {
        Exit.exitProgram(scanner);
        String restaurantName = extractRestaurantName(restaurantInfo);

        System.out.println("\nVous avez choisi : " + restaurantName);
        System.out.println("1 - Modifier les données du restaurant");
        System.out.println("2 - Passer une commande");
        System.out.println("3 - Retour au menu des restaurants");

        int choice;
        do {
            System.out.print("Votre choix : ");
            choice = readUserInput(scanner);

            switch (choice) {
                case 1 -> ModifyMenu.modifyRestaurant(scanner, restaurantId, restaurantName);
                case 2 -> System.out.println("Fonctionnalité en cours de développement.");
                case 3 -> {
                    displayVisitMenu(scanner);
                    return;
                }
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (true);
    }

    private static int readUserInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide. Veuillez entrer un chiffre valide.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    // Extract the restaurant name from the content of the restaurant.txt file
    private static String extractRestaurantName(String restaurantInfo) {
        return restaurantInfo.lines()
                .filter(line -> line.startsWith("Nom du restaurant :"))
                .map(line -> line.replace("Nom du restaurant :", "").trim())
                .findFirst()
                .orElse("Nom non trouvé");
    }

    // Read the restaurant information from the restaurant.txt file
    public static String readRestaurantInfo(File restaurantFolder) {
        File infoFile = new File(restaurantFolder, "restaurant.txt");
        StringBuilder info = new StringBuilder();

        try (Scanner fileScanner = new Scanner(infoFile)) {
            while (fileScanner.hasNextLine()) {
                info.append(fileScanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            return "Informations non disponibles";
        }

        return info.toString();
    }

    // Extract the restaurant ID from the folder name
    private static int extractID(String folderName) {
        try {
            return Integer.parseInt(folderName.split("_")[0]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
