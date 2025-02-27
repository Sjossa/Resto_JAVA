import java.io.File;
import java.util.Scanner;
import main.MainMenu;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le système de gestion des restaurants !");

        File restaurantFolder = new File("Restaurants");
        if (!restaurantFolder.exists() && restaurantFolder.mkdir()) {
            System.out.println("Dossier 'Restaurants' créé avec succès.");
        }

        MainMenu.displayMainMenu(scanner);
    }
}
