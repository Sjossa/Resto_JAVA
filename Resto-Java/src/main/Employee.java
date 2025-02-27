package main;

import java.time.LocalDate;

public class Employee {

    // ATTRIBUTS
    private int id;
    private String lastName, firstName;
    private LocalDate hireDate;
    private double salary;

    // CONSTRUCTEUR
    public Employee(int id, String lastName, String firstName, LocalDate hireDate, double salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    // GETTERS & SETTERS
    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public LocalDate getHireDate() { return hireDate; }
    public double getSalary() { return salary; }

    // MÉTHODE TO STRING
    @Override
    public String toString() {
        return "Employé{" +
               "ID=" + id +
               ", Nom='" + lastName + '\'' +
               ", Prénom='" + firstName + '\'' +
               ", Date d'embauche=" + hireDate +
               ", Salaire=" + salary +
               '}';
    }
}
