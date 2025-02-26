package formatage;

import main.Employe;
import main.Plat;
import main.Restaurant;

public class Formatage {

    public static String formatterRestaurant(Restaurant restaurant) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Restaurant : ").append(restaurant.getIdRestaurant()).append("\n")
          .append("Nom du restaurant : ").append(restaurant.getNomRestaurant()).append("\n")
          .append("Adresse :").append(restaurant.getAdresseRestaurant()).append("\n")
          .append("Menu : ").append(restaurant.getMenu() != null ? "Disponible" : "Non défini").append("\n\n");

        sb.append("Liste des employés : \n");
        for (Employe employe : restaurant.getEmployes()) {
            sb.append(formatterEmploye(employe));
        }

        sb.append("\nListe des plats : \n");
        for (Plat plat : restaurant.getPlats()) {
            sb.append(formatterPlat(plat));
        }

        return sb.toString();
    }

    public static String formatterEmploye(Employe employe) {
        return "ID : " + employe.getId() + "\n" +
               "Nom de l'employé :" + employe.getNom() + "\n" +
               "Prénom : " + employe.getPrenom() + "\n" +
               "Date d'embauche : " + employe.getDateEmbauche() + "\n" +
               "Salaire : " + employe.getSalaire() + "\n" +
               "------------------------------\n";
    }

    private static String formatterPlat(Plat plat) {
        return "ID : " + plat.getId() + "\n" +
               "Nom : " + plat.getNom() + "\n" +
               "Prix : " + plat.getPrix() + "€\n" +
               "Description : " + plat.getDescription() + "\n" +
               "Calories : " + plat.getCalories() + " kcal\n" +
               "Catégorie : " + plat.getCategorie() + "\n" +
               "Taille de la portion : " + plat.getTaillePortion() + "\n" +
               "Date d'ajout : " + plat.getDateAjout() + "\n" +
               "Disponibilité : " + (plat.isDisponibilite() ? "Disponible" : "Indisponible") + "\n" +
               "Ingrédients : " + plat.getIngredients() + "\n" +
               "Type de cuisine : " + plat.getTypeCuisine() + "\n" +
               "Temps de préparation : " + plat.getTempsPreparation() + " minutes\n" +
               "Prix spécial : " + plat.getPrixSpecial() + "€\n" +
               "URL de l'image : " + plat.getImageURL() + "\n" +
               "------------------------------\n";
    }
}
