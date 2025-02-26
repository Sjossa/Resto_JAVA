package main;

import java.time.LocalDate;

public class Employe {

    // ATTRIBUTS
    private int id;
    private String nom, prenom;
    private LocalDate dateEmbauche;
    private double salaire;

    // CONSTRUCTEUR
    public Employe(int id, String nom, String prenom, LocalDate dateEmbauche, double salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    // GETTERS & SETTERS
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateEmbauche() { return dateEmbauche; }
    public double getSalaire() { return salaire; }

    // MÉTHODE TO STRING
    @Override
    public String toString() {
        return "Employé{" +
               "ID=" + id +
               ", Nom='" + nom + '\'' +
               ", Prénom='" + prenom + '\'' +
               ", Date d'embauche=" + dateEmbauche +
               ", Salaire=" + salaire +
               '}';
    }
}
