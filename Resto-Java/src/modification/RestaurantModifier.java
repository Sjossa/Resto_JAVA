package modification;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantModifier {

    public static boolean modifyRestaurantInfo(Scanner scanner, int restaurantId, String prefix, String label, boolean isList) {
        File file = new File("Restaurants/" + restaurantId + "/restaurant.txt");

        List<String> lines = readFile(file);
        boolean modified = false;

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(prefix)) {
                System.out.print("Entrez la nouvelle valeur pour " + label.toLowerCase() + " : ");
                lines.set(i, prefix + " " + scanner.nextLine());
                modified = true;
                break;
            }
        }

        if (modified) updateFile(file, lines);
        return modified;
    }

    protected static boolean modifyElement(Scanner scanner, int restaurantId, String idPrefix, String namePrefix, String label) {
        File file = new File("Restaurants/" + restaurantId + "/restaurant.txt");

        if (!file.exists()) {
            System.out.println("Le fichier du restaurant n'existe pas.");
            return false;
        }

        List<String> lines = readFile(file);
        List<Integer> ids = new ArrayList<>();
        boolean modified = false;

        // Extraction des IDs avec debug pour vérifier ce qui est lu
        for (String line : lines) {
            if (line.startsWith(idPrefix)) {
                String[] parts = line.split(":");
                if (parts.length > 1) {
                    String idText = parts[1].trim();
                    System.out.println("ID extrait : '" + idText + "'");
                    ids.add(Integer.parseInt(idText));
                } else {
                    System.out.println("Erreur : ligne mal formatée -> " + line);
                }
            }
        }

        if (ids.isEmpty()) {
            System.out.println("Aucun élément trouvé.");
            return false;
        }

        System.out.println("Liste des éléments disponibles :");
        ids.forEach(id -> System.out.println("- " + idPrefix + " " + id));

        System.out.print("Entrez l'ID de l'élément à modifier : ");
        int chosenId = scanner.nextInt();
        scanner.nextLine();

        if (!ids.contains(chosenId)) {
            System.out.println("ID invalide.");
            return false;
        }

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).equals(idPrefix + " " + chosenId)) {
                // On a trouvé l'ID, maintenant on cherche la ligne correspondante
                for (int j = i + 1; j < lines.size(); j++) {
                    if (lines.get(j).startsWith(namePrefix)) {  // Vérifie qu'on modifie bien le bon champ
                        System.out.print("Entrez la nouvelle valeur pour " + label + " : ");
                        lines.set(j, namePrefix + " " + scanner.nextLine());
                        modified = true;
                        break;
                    }
                }
            }
        }

        if (modified) {
            updateFile(file, lines);
            System.out.println("Modification enregistrée.");
        } else {
            System.out.println("Échec de la modification.");
        }

        return modified;
    }

protected static boolean deleteElement(Scanner scanner, int restaurantId, String idPrefix, String endPrefix, String label) {
    File file = new File("Restaurants/" + restaurantId + "/restaurant.txt");

    List<String> lines = readFile(file);
    List<Integer> ids = new ArrayList<>();
    boolean modified = false;

    // Extraction des IDs avec debug pour vérifier ce qui est lu
    for (String line : lines) {
        if (line.startsWith(idPrefix)) {
            String[] parts = line.split(":");
            if (parts.length > 1) {
                String idText = parts[1].trim();
                System.out.println("ID extrait : '" + idText + "'");
                ids.add(Integer.parseInt(idText));
            } else {
                System.out.println("Erreur : ligne mal formatée -> " + line);
            }
        }
    }

    if (ids.isEmpty()) {
        System.out.println("Aucun élément trouvé.");
        return false;
    }

    System.out.println("Liste des éléments disponibles :");
    ids.forEach(id -> System.out.println("- " + idPrefix + " " + id));

    System.out.print("Entrez l'ID de l'élément à supprimer : ");
    int chosenId = scanner.nextInt();
    scanner.nextLine();

    if (!ids.contains(chosenId)) {
        System.out.println("ID invalide.");
        return false;
    }

    boolean foundStart = false;
    int startIndex = -1;

    for (int i = 0; i < lines.size(); i++) {
        if (lines.get(i).equals(idPrefix + " " + chosenId)) {
            startIndex = i; // L'index de la ligne contenant l'identifiant trouvé
            foundStart = true;
        }

        if (foundStart && lines.get(i).startsWith(endPrefix)) {
            // Supprimer toutes les lignes entre startIndex et la ligne contenant le salaire
            for (int j = startIndex; j <= i; j++) {
                lines.remove(startIndex);
            }
            modified = true;
            break;
        }
    }

    if (modified) {
        updateFile(file, lines);
        System.out.println("Suppression enregistrée.");
    } else {
        System.out.println("Échec de la suppression.");
    }

    return modified;
}

    private static List<String> readFile(File file) {
        try {
            return Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier.");
            return new ArrayList<>();
        }
    }

    private static void updateFile(File file, List<String> lines) {
        try {
            Files.write(Paths.get(file.getPath()), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier.");
        }
    }
}
