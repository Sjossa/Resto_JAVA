package interraction;

import main.Employe;
import addon.InputUtils;
import java.time.LocalDate;
import java.util.Scanner;

public class EmployeService {

    public static Employe creerEmploye(Scanner scanner) {
        System.out.println("\nCréation d'un employé");

        int id = InputUtils.lireEntier(scanner, "ID : ");
        String nom = InputUtils.lireTexte(scanner, "Nom de l'employé : ");
        String prenom = InputUtils.lireTexte(scanner, "Prénom : ");
        LocalDate dateEmbauche = InputUtils.lireDate(scanner, "Date d'embauche (AAAA-MM-JJ) : ");
        double salaire = InputUtils.lireDouble(scanner, "Salaire : ");

        System.out.println("Employé ajouté avec succès !");
        return new Employe(id, nom, prenom, dateEmbauche, salaire);
    }
}
