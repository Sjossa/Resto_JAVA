package main;

import addon.Exit;
import interaction.RestaurantService;
import java.util.Scanner;
import menus.VisitMenus;

public class MainMenu {

    public static void displayMainMenu(Scanner scanner) {
        int choice;
        do {
            Exit.exitProgram(scanner);
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1 - Visiter un restaurant");
            System.out.println("2 - Créer un nouveau restaurant");
            System.out.println("3 - Retour");

            System.out.print("Votre choix : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez entrer un chiffre entre 1 et 3.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> VisitMenus.displayVisitMenu(scanner);
                case 2 -> RestaurantService.createRestaurant(scanner);
                case 3 -> System.out.println("Retour au menu principal...");
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 3);
    }
}
