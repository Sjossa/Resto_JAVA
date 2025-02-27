package formatage;

import main.Dish;
import main.Employee;
import main.Restaurant;

public class Formatting {

    public static String formatRestaurant(Restaurant restaurant) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Restaurant : ").append(restaurant.getRestaurantId()).append("\n")
          .append("Nom du restaurant : ").append(restaurant.getRestaurantName()).append("\n")
          .append("Adresse : ").append(restaurant.getRestaurantAddress()).append("\n");
        //   .append("Menu : ").append(restaurant.getMenu() != null ? "Disponible" : "Non défini").append("\n\n") ;

        sb.append("Liste des employés : \n");
        for (Employee employee : restaurant.getEmployees()) {
            sb.append(formatEmployee(employee));
        }

        sb.append("\nListe des plats : \n");
        for (Dish dish : restaurant.getDishes()) {
            sb.append(formatDish(dish));
        }

        return sb.toString();
    }

    public static String formatEmployee(Employee employee) {
        return "ID : " + employee.getId() + "\n" +
               "Nom de l'employé : " + employee.getLastName() + "\n" +
               "Prénom : " + employee.getFirstName() + "\n" +
               "Date d'embauche : " + employee.getHireDate() + "\n" +
               "Salaire : " + employee.getSalary() + "\n" +
               "------------------------------\n";
    }

    public static String formatDish(Dish dish) {
        return "ID : " + dish.getId() + "\n" +
               "Nom : " + dish.getName() + "\n" +
               "Prix : " + dish.getPrice() + "€\n" +
               "Description : " + dish.getDescription() + "\n" +
               "Calories : " + dish.getCalories() + " kcal\n" +
               "Catégorie : " + dish.getCategory()+ "\n" +
               "Taille de la portion : " + dish.getPortionSize() + "\n" +
               "Date d'ajout : " + dish.getAddedDate() + "\n" +
               "Disponibilité : " + (dish.isAvailability() ? "Disponible" : "Indisponible") + "\n" +
               "Ingrédients : " + dish.getIngredients() + "\n" +
               "Type de cuisine : " + dish.getCuisineType() + "\n" +
               "Temps de préparation : " + dish.getPreparationTime() + " minutes\n" +
               "Prix spécial : " + dish.getSpecialPrice() + "€\n" +
               "URL de l'image : " + dish.getImageURL() + "\n" +
               "------------------------------\n";
    }
}
