package modification;

import formatage.Formatage;
import interraction.EmployeService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import  main.Employe;

public class EmployeModifier {

    
    public static boolean ajouterEmploye(Scanner scanner, int idRestaurant) {
        String cheminFichier = "Restaurants/" + idRestaurant + "/restaurant.txt";
        File fichier = new File(cheminFichier);


        if (!fichier.exists()) {
            try {
                fichier.createNewFile();
            } catch (IOException e) {
                System.out.println("Erreur lors de la création du fichier employés.");
                return false;
            }
        }

        Employe employe = EmployeService.creerEmploye(scanner);

        try (FileWriter writer = new FileWriter(fichier, true)) {
            writer.write(Formatage.formatterEmploye(employe) + System.lineSeparator());
            System.out.println("Employé ajouté avec succès !");
            return true;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier.");
            return false;
        }
    }


    public static List<String> lireEmployes(int idRestaurant) {
        String cheminFichier = "Restaurants/" + idRestaurant + "/employes.txt";
        File fichier = new File(cheminFichier);
        List<String> employes = new ArrayList<>();

        if (!fichier.exists()) {
            System.out.println("Aucun employé trouvé pour ce restaurant.");
            return employes;
        }

        try (Scanner fileScanner = new Scanner(fichier)) {
            while (fileScanner.hasNextLine()) {
                String ligne = fileScanner.nextLine();
                employes.add(ligne);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier.");
        }

        return employes;
    }



}
