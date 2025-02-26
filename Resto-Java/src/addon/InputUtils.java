package addon;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtils {

    public static String lireTexte(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public static int lireEntier(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int valeur = Integer.parseInt(scanner.nextLine().trim());
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
    }

    public static double lireDouble(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                double valeur = Double.parseDouble(scanner.nextLine().trim());
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre décimal.");
            }
        }
    }

    public static LocalDate lireDate(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Format de date incorrect. Veuillez utiliser AAAA-MM-JJ.");
            }
        }
    }
}
