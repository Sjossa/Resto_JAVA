package main;

import addon.Fin;
import interraction.RestaurantService;
import java.util.Scanner;
import menus.MenusVisiter;

public class Menu {

    public static void afficherMenuPrincipal(Scanner scanner) {
        int choix;
        do {
            Fin.quitterProgramme(scanner);
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1 - Visiter un restaurant");
            System.out.println("2 - Créer un nouveau restaurant");
            System.out.println("3 - Retour");

            System.out.print("Votre choix : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez entrer un chiffre entre 1 et 3.");
                scanner.next();
            }
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> MenusVisiter.afficherMenuVisite(scanner);
                case 2 -> RestaurantService.creerRestaurant(scanner);
                case 3 -> System.out.println("Retour au menu principal...");
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 3);
    }
}
