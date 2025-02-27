package main;

import java.util.ArrayList;

public class Restaurant {
    private int restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    // private Menu menu;
    private ArrayList<Employee> employees;
    private ArrayList<Dish> dishes;

    public Restaurant(int restaurantId, String restaurantName, String restaurantAddress) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        // this.menu = menu;
        this.employees = new ArrayList<>();
        this.dishes = new ArrayList<>();
    }

    // Getters
    public int getRestaurantId() { return restaurantId; }
    public String getRestaurantName() { return restaurantName; }
    public String getRestaurantAddress() { return restaurantAddress; }
    // public Menu getMenu() { return menu; }
    public ArrayList<Employee> getEmployees() { return employees; }
    public ArrayList<Dish> getDishes() { return dishes; }

    // Ajouter un employé
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Ajouter un plat
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    @Override
    public String toString() {
        return "Restaurant : " + restaurantName +
               "\nAdresse : " + restaurantAddress +
            //    "\nMenu : " + (menu != null ? "Disponible" : "Non défini") +
               "\nNombre d'employés : " + employees.size() +
               "\nNombre de plats : " + dishes.size() +
               "\nID : " + restaurantId;
    }
}
