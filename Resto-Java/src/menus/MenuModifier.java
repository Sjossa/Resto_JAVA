package menus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import  modification.EmployeModifier;
import  modification.RestaurantModifier;


public class MenuModifier {

    public static void modifierRestaurant(Scanner scanner, int idRestaurant, String nomRestaurant) {
        System.out.println("\nModification du restaurant : " + nomRestaurant);

        boolean continuer = true;

        while (continuer) {
            afficherMenu(nomRestaurant);
            System.out.print("Votre choix : ");

            int choix = lireEntreeUtilisateur(scanner);

            if (choix == 0) {
                System.out.println("Retour au menu principal...");
                continuer = false;
            } else {
                traiterChoix(scanner, idRestaurant, nomRestaurant, choix);
            }
        }
    }

    private static void afficherMenu(String nomRestaurant) {
        System.out.println("\nMenu de modification du restaurant :");
        System.out.println("1 - Modifier le nom du restaurant");
        System.out.println("2 - Modifier l'adresse");
        System.out.println("3 - Modifier le nom d'un employé");
        System.out.println("4 - Modifier le salaire d'un employé");
        System.out.println("5 - Ajouter un employé");
        System.out.println("6 - Modifier le nom d'un plat");
        System.out.println("7 - Modifier le prix d'un plat");
        System.out.println("8 - Afficher les options du restaurant");
        System.out.println("0 - Retour au menu principal");
    }

    private static int lireEntreeUtilisateur(Scanner scanner) {
        int choix;
        while (true) {
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine();
                return choix;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un chiffre valide.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    private static void traiterChoix(Scanner scanner, int idRestaurant, String nomRestaurant, int choix) {
        Map<Integer, Runnable> actions = new HashMap<>();

        // Action 1: Modifier le nom du restaurant
        actions.put(1, () -> RestaurantModifier.modifierRestaurantInfo(scanner, idRestaurant, "Nom du restaurant :", "Nom du restaurant", false));

        // Action 2: Modifier l'adresse du restaurant
        actions.put(2, () -> RestaurantModifier.modifierRestaurantInfo(scanner, idRestaurant, "Adresse :", "Adresse du restaurant", false));

        // Action 3: Modifier le nom d'un employé
        actions.put(3, () -> RestaurantModifier.modifierRestaurantInfo(scanner, idRestaurant, "Nom :", "Nom de l'employé", true));

        // Action 4: Modifier le salaire d'un employé
        actions.put(4, () -> RestaurantModifier.modifierRestaurantInfo(scanner, idRestaurant, "Salaire :", "Salaire de l'employé", true));

        // Action 5: Ajouter un employé
         actions.put(5, () -> {
    boolean success = EmployeModifier.ajouterEmploye(scanner, idRestaurant);
    if (!success) {
        System.out.println("Erreur lors de l'ajout de l'employé.");
    }});


        // Action 6: Modifier le nom d'un plat
        actions.put(6, () -> RestaurantModifier.modifierRestaurantInfo(scanner, idRestaurant, "Nom du plat :", "Nom du plat", true));

        // Action 7: Modifier le prix d'un plat
        actions.put(7, () -> RestaurantModifier.modifierRestaurantInfo(scanner, idRestaurant, "Prix du plat :", "Prix du plat", true));

        // Action 8: Afficher les options du restaurant
        actions.put(8, () -> afficherOptionsRestaurant(idRestaurant, nomRestaurant));

        // Exécuter l'action associée au choix
        if (actions.containsKey(choix)) {
            actions.get(choix).run();
        } else {
            System.out.println("Choix invalide, veuillez réessayer.");
        }
    }

    private static void afficherOptionsRestaurant(int idRestaurant, String nomRestaurant) {
        System.out.println("Affichage des options pour le restaurant : " + nomRestaurant);
    }
}
