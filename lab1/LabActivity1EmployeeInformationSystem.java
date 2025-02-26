
import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Name and Age
        System.out.print("Input your first name: ");
        String firstName = scanner.next();
        System.out.print("Input your last name: ");
        String lastName = scanner.next();
        System.out.print("Input your age: ");
        int age = scanner.nextInt();

        // Job Details
        System.out.print("Enter hours worked: ");
        double hours = scanner.nextFloat();
        System.out.print("Enter hourly wage: ");
        double hourly_Wage = scanner.nextFloat();

        // Compute Daily Salary
        double daily_Salary = hourly_Wage * hours;

        // Close Scanner
        scanner.close();

        // Output
        System.out.println(); // spacing
        System.out.println("Employee Information");
        System.out.println("--------------------");
        System.out.println("Full Name   : " + firstName + " " + lastName);
        System.out.println("Age         : " + age + " years old");
        System.out.printf("Daily Salary: PHP %.2f%n", daily_Salary);

    }
}