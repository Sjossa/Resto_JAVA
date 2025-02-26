package main;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le système de gestion des restaurants !");

        File dossierRestaurants = new File("Restaurants");
        if (!dossierRestaurants.exists() && dossierRestaurants.mkdir()) {
            System.out.println("Dossier 'Restaurants' créé avec succès.");
        }

        Menu.afficherMenuPrincipal(scanner);
    }

}
