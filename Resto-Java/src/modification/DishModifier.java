package modification;

import formatage.Formatting;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import main.Dish;

public class DishModifier extends RestaurantModifier {

    public static boolean DeletePlat(Scanner scanner, int restaurantId) {
        return deleteElement(scanner,restaurantId,"Plat ID :","URL de l'image : ","Employé ID :");
    }

     public static boolean addplat(Scanner scanner, int restaurantId) {
        String filePath = "Restaurants/" + restaurantId + "/restaurant.txt";
        File file = new File(filePath);

        Dish dish = Dish.createDish(scanner);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(Formatting.formatDish(dish) + System.lineSeparator());
            System.out.println("plat ajouté avec succès !");
            return true;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier.");
            return false;
        }
    }

    public static void DishMenu(Scanner scanner, int restaurantId) {
        Map<Integer, String> modifications = new HashMap<>();
        modifications.put(1, "Nom du plat");
        modifications.put(2, "Prix");
        modifications.put(3, "Description");
        modifications.put(4, "Calories");
        modifications.put(5, "Catégorie");
        modifications.put(6, "Taille de la portion");
        modifications.put(7, "Date d'ajout");
        modifications.put(8, "Disponibilité");
        modifications.put(9, "Ingrédients");
        modifications.put(10, "Type de cuisine");
        modifications.put(11, "Temps de préparation");
        modifications.put(12, "Prix spécial");
        modifications.put(13, "URL de l'image");
        modifications.put(14, "Supprimer un plat");
        modifications.put(15, "Ajouter un plat");



        System.out.println("Que souhaitez-vous modifier ?");
        modifications.forEach((key, value) -> System.out.println(key  + value));

        System.out.print("Votre choix : ");
        int choice = scanner.nextInt();
        scanner.nextLine();


        Map<Integer, Runnable> actions = new HashMap<>();


        modifications.forEach((key, value) ->
            actions.put(key, () -> modifyElement(scanner, restaurantId, "Plat ID :", value, value.toLowerCase()))
        );


        actions.put(14, () -> {

DeletePlat(scanner, restaurantId);


        });

          actions.put(15, () -> {

             boolean success = addplat(scanner, restaurantId);
                if (!success) {
                    System.out.println("Erreur lors de l'ajout de l'employé.");
                }

        });


        actions.getOrDefault(choice, () -> System.out.println("Choix invalide.")).run();
    }
}
