package main;

import java.util.ArrayList;

public class Restaurant {
    private int idRestaurant;
    private String nomRestaurant;
    private String adresseRestaurant;
    private Menu menu;
    private ArrayList<Employe> employes;
    private ArrayList<Plat> plats;

    public Restaurant(int idRestaurant, String nomRestaurant, String adresseRestaurant, Menu menu) {
        this.idRestaurant = idRestaurant;
        this.nomRestaurant = nomRestaurant;
        this.adresseRestaurant = adresseRestaurant;
        this.menu = menu;
        this.employes = new ArrayList<>();
        this.plats = new ArrayList<>();
    }

    // Getters
    public int getIdRestaurant() { return idRestaurant; }
    public String getNomRestaurant() { return nomRestaurant; }
    public String getAdresseRestaurant() { return adresseRestaurant; }
    public Menu getMenu() { return menu; }
    public ArrayList<Employe> getEmployes() { return employes; }
    public ArrayList<Plat> getPlats() { return plats; }

    // Ajouter un employé
    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    // Ajouter un plat
    public void ajouterPlat(Plat plat) {
        plats.add(plat);
    }

    @Override
    public String toString() {
        return "Restaurant : " + nomRestaurant +
               "\nAdresse : " + adresseRestaurant +
               "\nMenu : " + (menu != null ? "Disponible" : "Non défini") +
               "\nNombre d'employés : " + employes.size() +
               "\nNombre de plats : " + plats.size() +
               "\nID : " + idRestaurant;
    }
}
