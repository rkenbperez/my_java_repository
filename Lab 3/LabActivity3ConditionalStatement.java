package org.example;

import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Name, Age and Role
        System.out.print("Input your first name: ");
        String firstName = scanner.nextLine().toUpperCase();
        System.out.print("Input your last name: ");
        String lastName = scanner.nextLine().toUpperCase();
        System.out.print("Input your age: ");
        int age = scanner.nextInt();

        // Checking of age

        if (age < 18) {
            System.out.println("Minors are not allowed");
            System.exit(0);
        } else if (age >= 65) {
            System.out.println("Senior Citizens are not allowed");
            System.exit(0);
        }

        // Job Details
        System.out.print("Enter hours worked: ");
        double hours = scanner.nextFloat();

        // Checking hours
        if (hours > 24) {
            System.out.println("Number of hours worked cannot exceed 24 hours");
            System.exit(0);
        } else if (hours < 1) {
            System.out.println("Wrong input on daily work hours");
            System.exit(0);
        }

        System.out.print("Enter hourly wage: ");
        double hourly_Wage = scanner.nextFloat();
        System.out.print("Input your Role (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int role = scanner.nextInt();
        String roleType = "";


        // Categorizing Roles
        switch (role) {
            case 1 -> roleType = "Manager";
            case 2 -> roleType = "Supervisor";
            case 3 -> roleType = "Staff";
            case 4 -> roleType = "Intern";
            default -> roleType = "Undefined";
        }

        // Compute Daily Salary
        double dailySalary = hourly_Wage * hours;
        double weeklySalary = dailySalary * 5;
        double monthlySalary = weeklySalary * 4;
        double grossYearlySalary = monthlySalary * 12;

        // Checking of Salary
        double totalDeductions = (grossYearlySalary > 250000) ? (grossYearlySalary * 0.32) + 1500 : 1500;
        double netYearlySalary = grossYearlySalary - totalDeductions;
        int retirementAge = 65;
        int yearsToRetirement = retirementAge - age;

        // Output
        System.out.println(); // Spacing
        System.out.println("Employee Information");
        System.out.println("-------------------------------------------");
        System.out.printf("%-20s: %s, %s%n", "Full Name", firstName, lastName);
        System.out.printf("%-20s: %d years old%n", "Age", age);
        System.out.printf("%-20s: %s%n", "Position", roleType);
        System.out.printf("%-20s: %d years%n", "Years to Retirement", yearsToRetirement);
        System.out.printf("%-20s: PHP %.2f%n", "Daily Salary", dailySalary);
        System.out.printf("%-20s: PHP %.2f%n", "Weekly Salary", weeklySalary);
        System.out.printf("%-20s: PHP %.2f%n", "Monthly Salary", monthlySalary);
        System.out.printf("%-20s: PHP %.2f%n", "Gross Yearly Salary", grossYearlySalary);
        System.out.printf("%-20s: PHP %.2f%n", "Net Yearly Salary", netYearlySalary);

        scanner.close();
    }
}