package gestion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import main.Restaurant;

public class RestaurantDAO {

    private static final String BASE_FOLDER = "Restaurants/";

    
    public static int generateNewId() {
        File folder = new File(BASE_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File[] restaurantList = folder.listFiles(File::isDirectory);
        return (restaurantList != null) ? restaurantList.length + 1 : 1;
    }

    // Sauvegarde du restaurant dans un fichier
    public static void saveRestaurant(Restaurant restaurant) {
        String folderName = BASE_FOLDER + restaurant.getRestaurantId();
        File folder = new File(folderName);

        if (!folder.exists() && !folder.mkdirs()) {
            System.out.println("Erreur : Impossible de créer le dossier du restaurant.");
            return;
        }

        try (FileWriter writer = new FileWriter(folderName + "/restaurant.txt")) {
            writer.write(restaurant.toString());
            System.out.println("✅ Restaurant sauvegardé dans : " + folderName + "/restaurant.txt");
        } catch (IOException e) {
            System.out.println("❌ Erreur lors de la sauvegarde du restaurant : " + e.getMessage());
        }
    }
}
