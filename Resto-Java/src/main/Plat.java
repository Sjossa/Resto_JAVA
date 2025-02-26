package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Plat {

    // ATTRIBUTS
    private int id;
    private String nom, description, categorie, taillePortion, ingredients, typeCuisine, imageURL;
    private double prix, prixSpecial;
    private int calories, tempsPreparation;
    private LocalDate dateAjout;
    private boolean disponibilite;

    // CONSTRUCTEUR
    public Plat(int id, String nom, String description, double prix, int calories, String categorie,
                String taillePortion, LocalDate dateAjout, boolean disponibilite, String ingredients,
                String typeCuisine, int tempsPreparation, double prixSpecial, String imageURL) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.calories = calories;
        this.categorie = categorie;
        this.taillePortion = taillePortion;
        this.dateAjout = dateAjout;
        this.disponibilite = disponibilite;
        this.ingredients = ingredients;
        this.typeCuisine = typeCuisine;
        this.tempsPreparation = tempsPreparation;
        this.prixSpecial = prixSpecial;
        this.imageURL = imageURL;
    }

    // GETTERS & SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public String getTaillePortion() { return taillePortion; }
    public void setTaillePortion(String taillePortion) { this.taillePortion = taillePortion; }

    public LocalDate getDateAjout() { return dateAjout; }
    public void setDateAjout(LocalDate dateAjout) { this.dateAjout = dateAjout; }

    public boolean isDisponibilite() { return disponibilite; }
    public void setDisponibilite(boolean disponibilite) { this.disponibilite = disponibilite; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getTypeCuisine() { return typeCuisine; }
    public void setTypeCuisine(String typeCuisine) { this.typeCuisine = typeCuisine; }

    public int getTempsPreparation() { return tempsPreparation; }
    public void setTempsPreparation(int tempsPreparation) { this.tempsPreparation = tempsPreparation; }

    public double getPrixSpecial() { return prixSpecial; }
    public void setPrixSpecial(double prixSpecial) { this.prixSpecial = prixSpecial; }

    public String getImageURL() { return imageURL; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    // MÉTHODE POUR CRÉER UN PLAT
    public static Plat creerPlat(Scanner scanner) {
        System.out.println("\nCréation d'un plat");

        int id = lireEntier(scanner, "ID : ");
        String nom = lireTexte(scanner, "Nom du plat : ");
        String description = lireTexte(scanner, "Description : ");
        double prix = lireDouble(scanner, "Prix : ");
        int calories = lireEntier(scanner, "Calories : ");
        String categorie = lireTexte(scanner, "Catégorie : ");
        String taillePortion = lireTexte(scanner, "Taille de la portion : ");
        LocalDate dateAjout = lireDate(scanner, "Date d'ajout (format: yyyy-MM-dd) : ");
        boolean disponibilite = lireBoolean(scanner, "Disponibilité (true/false) : ");
        String ingredients = lireTexte(scanner, "Ingrédients : ");
        String typeCuisine = lireTexte(scanner, "Type de cuisine : ");
        int tempsPreparation = lireEntier(scanner, "Temps de préparation (en minutes) : ");
        double prixSpecial = lireDouble(scanner, "Prix spécial (si applicable) : ");
        String imageURL = lireTexte(scanner, "URL de l'image : ");

        return new Plat(id, nom, description, prix, calories, categorie, taillePortion, dateAjout,
                disponibilite, ingredients, typeCuisine, tempsPreparation, prixSpecial, imageURL);
    }

    // MÉTHODES UTILITAIRES POUR LA SAISIE
    private static String lireTexte(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int lireEntier(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
    }

    private static double lireDouble(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre décimal.");
            }
        }
    }

    private static boolean lireBoolean(Scanner scanner, String message) {
        while (true) {
            String entree = lireTexte(scanner, message).toLowerCase();
            if (entree.equals("true") || entree.equals("false")) {
                return Boolean.parseBoolean(entree);
            }
            System.out.println("Entrée invalide. Veuillez taper 'true' ou 'false'.");
        }
    }

    private static LocalDate lireDate(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Format de date incorrect. Veuillez utiliser yyyy-MM-dd.");
            }
        }
    }

    // MÉTHODE TO STRING
    @Override
    public String toString() {
        return String.format(
                "Plat { ID = %d, Nom = '%s', Description = '%s', Prix = %.2f€, Calories = %d, Catégorie = '%s', " +
                "Taille = '%s', Date d'ajout = %s, Disponible = %b, Ingrédients = '%s', Type = '%s', " +
                "Préparation = %d min, Prix spécial = %.2f€, Image = '%s' }",
                id, nom, description, prix, calories, categorie, taillePortion, dateAjout,
                disponibilite, ingredients, typeCuisine, tempsPreparation, prixSpecial, imageURL
        );
    }
}
