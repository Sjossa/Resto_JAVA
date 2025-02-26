package gestion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import main.Restaurant;
public class RestaurantDAO {

    private static final String DOSSIER_BASE = "Restaurants/";

    // Générer un nouvel ID pour un restaurant
    public static int genererNouvelId() {
        File dossier = new File(DOSSIER_BASE);
        if (!dossier.exists()) {
            dossier.mkdirs();
        }
        File[] listeRestaurants = dossier.listFiles(File::isDirectory);
        return (listeRestaurants != null) ? listeRestaurants.length + 1 : 1;
    }

    // Sauvegarde du restaurant dans un fichier
    public static void sauvegarderRestaurant(Restaurant restaurant) {
        String dossierNom = DOSSIER_BASE + restaurant.getIdRestaurant();
        File dossier = new File(dossierNom);

        if (!dossier.exists() && !dossier.mkdirs()) {
            System.out.println("Erreur : Impossible de créer le dossier du restaurant.");
            return;
        }

        try (FileWriter writer = new FileWriter(dossierNom + "/restaurant.txt")) {
            writer.write(restaurant.toString());
            System.out.println("✅ Restaurant sauvegardé dans : " + dossierNom + "/restaurant.txt");
        } catch (IOException e) {
            System.out.println("❌ Erreur lors de la sauvegarde du restaurant : " + e.getMessage());
        }
    }
}
