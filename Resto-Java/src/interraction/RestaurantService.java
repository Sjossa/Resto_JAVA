package interraction;

import gestion.RestaurantDAO;
import java.util.Scanner;
import main.Employe;
import  main.Plat;
import  main.Restaurant;


public class RestaurantService {

    public static void creerRestaurant(Scanner scanner) {
        System.out.println("\n📌 Création d'un nouveau restaurant");

        System.out.print("Nom du restaurant : ");
        String nom = scanner.nextLine().trim();

        System.out.print("Adresse du restaurant : ");
        String adresse = scanner.nextLine().trim();

        int id = RestaurantDAO.genererNouvelId();
        Restaurant restaurant = new Restaurant(id, nom, adresse, null);

        // Ajouter des employés
        while (true) {
            System.out.print("Ajouter un employé ? (oui/non) : ");
            String reponse = scanner.nextLine().trim();
            if (reponse.equalsIgnoreCase("oui")) {
                Employe employe = EmployeService.creerEmploye(scanner);
                restaurant.ajouterEmploye(employe);
            } else {
                break;
            }
        }

        // Ajouter des plats
        while (true) {
            System.out.print("Ajouter un plat ? (oui/non) : ");
            String reponse = scanner.nextLine().trim();
            if (reponse.equalsIgnoreCase("oui")) {
                Plat plat = Plat.creerPlat(scanner);
                restaurant.ajouterPlat(plat);
            } else {
                break;
            }
        }

        // Sauvegarde du restaurant
        RestaurantDAO.sauvegarderRestaurant(restaurant);
        System.out.println("🎉 Le restaurant \"" + nom + "\" a été créé avec succès ! ID : " + id);
    }
}
