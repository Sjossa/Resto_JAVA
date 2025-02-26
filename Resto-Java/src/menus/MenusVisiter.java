package menus;

import addon.Fin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenusVisiter {

    // Méthode pour afficher le menu de visite
    public static void afficherMenuVisite(Scanner scanner) {

        File dossierRestaurants = new File("restaurants");
        File[] fichiers = dossierRestaurants.listFiles(File::isDirectory);

        if (fichiers == null || fichiers.length == 0) {
            System.out.println("Aucun restaurant trouvé.");
            return;
        }

        Map<Integer, String> restaurants = new HashMap<>();


        for (File fichier : fichiers) {
            int idRestaurant = extraireID(fichier.getName());
            if (idRestaurant != -1) {
                String infosRestaurant = lireInfosRestaurant(fichier);
                restaurants.put(idRestaurant, infosRestaurant);
            }
        }

        // Afficher la liste des restaurants disponibles
        System.out.println("\nListe des restaurants disponibles :");
        afficherListeRestaurants(restaurants);

        // Choisir un restaurant
        System.out.println("0 - Retour");
        int choix;
        do {
            System.out.print("Sélectionnez un restaurant par ID : ");
            choix = lireEntreeUtilisateur(scanner);

            if (restaurants.containsKey(choix)) {
                afficherOptionsRestaurant(scanner, choix, restaurants.get(choix));
            } else if (choix != 0) {
                System.out.println("Choix invalide, veuillez réessayer.");
            }

        } while (choix != 0);

        System.out.println("Retour au menu principal...");
    }


    private static void afficherListeRestaurants(Map<Integer, String> restaurants) {
        for (Map.Entry<Integer, String> entry : restaurants.entrySet()) {
            int id = entry.getKey();
            String infos = entry.getValue();
            String nomRestaurant = extraireNomRestaurant(infos);
            System.out.println(id + " - " + nomRestaurant);
        }
    }

    public static void afficherOptionsRestaurant(Scanner scanner, int idRestaurant, String infosRestaurant) {
        Fin.quitterProgramme(scanner);
        String nomRestaurant = extraireNomRestaurant(infosRestaurant);

        System.out.println("\nVous avez choisi : " + nomRestaurant);
        System.out.println("1 - Modifier les données du restaurant");
        System.out.println("2 - Passer une commande");
        System.out.println("3 - Retour au menu des restaurants");

        int choix;
        do {
            System.out.print("Votre choix : ");
            choix = lireEntreeUtilisateur(scanner);

            switch (choix) {
                case 1 -> MenuModifier.modifierRestaurant(scanner, idRestaurant, nomRestaurant);
                case 2 -> System.out.println("Fonctionnalité en cours de développement.");
                case 3 -> {
                    afficherMenuVisite(scanner);
                    return;
                }
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (true);
    }


    private static int lireEntreeUtilisateur(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide. Veuillez entrer un chiffre valide.");
            scanner.next();
        }
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }

    // Extraction du nom du restaurant à partir du contenu du fichier restaurant.txt
    private static String extraireNomRestaurant(String infosRestaurant) {
        return infosRestaurant.lines()
                .filter(ligne -> ligne.startsWith("Nom du restaurant :"))
                .map(ligne -> ligne.replace("Nom du restaurant :", "").trim())
                .findFirst()
                .orElse("Nom non trouvé");
    }

    // Lecture des informations du restaurant depuis le fichier restaurant.txt
    public static String lireInfosRestaurant(File restaurantFolder) {
        File fichierInfos = new File(restaurantFolder, "restaurant.txt");
        StringBuilder infos = new StringBuilder();

        try (Scanner fileScanner = new Scanner(fichierInfos)) {
            while (fileScanner.hasNextLine()) {
                infos.append(fileScanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            return "Informations non disponibles";
        }

        return infos.toString();
    }

    // Extraction de l'ID du restaurant à partir du nom du dossier
    private static int extraireID(String nomDossier) {
        try {
            return Integer.parseInt(nomDossier.split("_")[0]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
