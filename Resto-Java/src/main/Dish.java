package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Dish {

    // ATTRIBUTS
    private int id;
    private String name, description, category, portionSize, ingredients, cuisineType, imageURL;
    private double price, specialPrice;
    private int calories, preparationTime;
    private LocalDate addedDate;
    private boolean availability;

    // CONSTRUCTEUR
    public Dish(int id, String name, String description, double price, int calories, String category,
                String portionSize, LocalDate addedDate, boolean availability, String ingredients,
                String cuisineType, int preparationTime, double specialPrice, String imageURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.category = category;
        this.portionSize = portionSize;
        this.addedDate = addedDate;
        this.availability = availability;
        this.ingredients = ingredients;
        this.cuisineType = cuisineType;
        this.preparationTime = preparationTime;
        this.specialPrice = specialPrice;
        this.imageURL = imageURL;
    }

    // GETTERS & SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPortionSize() { return portionSize; }
    public void setPortionSize(String portionSize) { this.portionSize = portionSize; }

    public LocalDate getAddedDate() { return addedDate; }
    public void setAddedDate(LocalDate addedDate) { this.addedDate = addedDate; }

    public boolean isAvailability() { return availability; }
    public void setAvailability(boolean availability) { this.availability = availability; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getCuisineType() { return cuisineType; }
    public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }

    public int getPreparationTime() { return preparationTime; }
    public void setPreparationTime(int preparationTime) { this.preparationTime = preparationTime; }

    public double getSpecialPrice() { return specialPrice; }
    public void setSpecialPrice(double specialPrice) { this.specialPrice = specialPrice; }

    public String getImageURL() { return imageURL; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    // MÉTHODE POUR CRÉER UN PLAT
    public static Dish createDish(Scanner scanner) {
        System.out.println("\nCréation d'un plat");

        int id = readInteger(scanner, "ID : ");
        String name = readText(scanner, "Nom du plat : ");
        String description = readText(scanner, "Description : ");
        double price = readDouble(scanner, "Prix : ");
        int calories = readInteger(scanner, "Calories : ");
        String category = readText(scanner, "Catégorie : ");
        String portionSize = readText(scanner, "Taille de la portion : ");
        LocalDate addedDate = readDate(scanner, "Date d'ajout (format: yyyy-MM-dd) : ");
        boolean availability = readBoolean(scanner, "Disponibilité (true/false) : ");
        String ingredients = readText(scanner, "Ingrédients : ");
        String cuisineType = readText(scanner, "Type de cuisine : ");
        int preparationTime = readInteger(scanner, "Temps de préparation (en minutes) : ");
        double specialPrice = readDouble(scanner, "Prix spécial (si applicable) : ");
        String imageURL = readText(scanner, "URL de l'image : ");

        return new Dish(id, name, description, price, calories, category, portionSize, addedDate,
                availability, ingredients, cuisineType, preparationTime, specialPrice, imageURL);
    }

    // MÉTHODES UTILITAIRES POUR LA SAISIE
    private static String readText(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInteger(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
    }

    private static double readDouble(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre décimal.");
            }
        }
    }

    private static boolean readBoolean(Scanner scanner, String message) {
        while (true) {
            String input = readText(scanner, message).toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Entrée invalide. Veuillez taper 'true' ou 'false'.");
        }
    }

    private static LocalDate readDate(Scanner scanner, String message) {
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
                id, name, description, price, calories, category, portionSize, addedDate,
                availability, ingredients, cuisineType, preparationTime, specialPrice, imageURL
        );
    }
}
