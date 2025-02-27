package interaction;

import addon.InputUtils;
import java.time.LocalDate;
import java.util.Scanner;
import main.Employee;

public class EmployeeService {

    public static Employee createEmployee(Scanner scanner) {
        System.out.println("\nCreating a new employee");

        int id = InputUtils.readInteger(scanner, "ID: ");
        String nom = InputUtils.readText(scanner, "Employee's last name: ");
        String prenom = InputUtils.readText(scanner, "Employee's first name: ");
        LocalDate dateEmbauche = InputUtils.readDate(scanner, "Hiring date (YYYY-MM-DD): ");
        double salaire = InputUtils.readDouble(scanner, "Salary: ");

        System.out.println("Employee added successfully!");
        return new Employee(id, nom, prenom, dateEmbauche, salaire);
    }
}
