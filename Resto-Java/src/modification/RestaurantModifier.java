package modification;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantModifier {

    // Méthode pour modifier les informations d'un restaurant
    public static boolean modifierRestaurantInfo(Scanner scanner, int idRestaurant, String prefix, String label, boolean estListe) {
        String cheminFichier = "Restaurants/" + idRestaurant + "/restaurant.txt";
        File fichier = new File(cheminFichier);

        if (!fichier.exists()) {
            System.out.println("Le fichier du restaurant n'existe pas.");
            return false;
        }

        List<String> lignes = new ArrayList<>();
        boolean idRestaurantTrouve = false;
        boolean modifie = false; // Indicateur de modification

        try (Scanner fileScanner = new Scanner(fichier)) {
            while (fileScanner.hasNextLine()) {
                String ligne = fileScanner.nextLine();
                lignes.add(ligne);

                // Vérification de l'ID du restaurant
                if (ligne.startsWith("ID Restaurant :")) {
                    String[] parts = ligne.split(":");
                    if (parts.length > 1) {
                        try {
                            int idDansFichier = Integer.parseInt(parts[1].trim());
                            if (idDansFichier == idRestaurant) {
                                idRestaurantTrouve = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Erreur : ID du restaurant mal formaté.");
                            return false;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier.");
            return false;
        }

        if (!idRestaurantTrouve) {
            System.out.println("L'ID du restaurant ne correspond pas.");
            return false;
        }

        // Modification de la donnée si nécessaire
        if (estListe) {
        } else {
            for (int i = 0; i < lignes.size(); i++) {
                if (lignes.get(i).startsWith(prefix)) {
                    System.out.print("Entrez la nouvelle valeur pour " + label.toLowerCase() + " : ");
                    String nouvelleValeur = scanner.nextLine();
                    lignes.set(i, prefix + " " + nouvelleValeur);
                    modifie = true; // Indiquer que la donnée a été modifiée
                    break;
                }
            }
        }

        // Si modification effectuée, réécrire dans le fichier
        if (modifie) {
            modifierFichier(fichier, lignes);
        }

        return modifie; // Retourner true si la modification a été effectuée
    }

    // Méthode pour réécrire le fichier avec les nouvelles données
    private static void modifierFichier(File fichier, List<String> lignes) {
        try (FileWriter writer = new FileWriter(fichier)) {
            for (String ligne : lignes) {
                writer.write(ligne + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier.");
        }
    }
}
