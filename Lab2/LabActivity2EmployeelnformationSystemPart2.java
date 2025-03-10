package org.example;

import java.util.Scanner;

public class LabActivity2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Name and Age
        System.out.print("Input your first name: ");
        String firstName = scanner.nextLine().toUpperCase();
        System.out.print("Input your last name: ");
        String lastName = scanner.nextLine().toUpperCase();
        System.out.print("Input your age: ");
        int age = scanner.nextInt();

        // Job Details
        System.out.print("Enter hours worked: ");
        double hours = scanner.nextFloat();
        System.out.print("Enter hourly wage: ");
        double hourly_Wage = scanner.nextFloat();

        // Compute Daily Salary
        double dailySalary = hourly_Wage * hours;
        double weeklySalary = dailySalary * 5;
        double monthlySalary = weeklySalary * 4;
        double grossYearlySalary = monthlySalary * 12;
        double totalDeductions = 34677.60;
        double netYearlySalary = grossYearlySalary - totalDeductions;
        int retirementAge = 65;
        int yearsToRetirement = retirementAge - age;

        // Output
        System.out.println(); // Spacing
        System.out.println("Employee Information");
        System.out.println("-------------------------------------------");
        System.out.println("Full Name     : " + firstName + ", " + lastName);
        System.out.println("Age           : " + age + " years old");
        System.out.println("Years to Retirement : " + yearsToRetirement + " years");
        System.out.printf("Daily Salary  : PHP %.2f%n", dailySalary);
        System.out.printf("Weekly Salary : PHP %.2f%n", weeklySalary);
        System.out.printf("Monthly Salary: PHP %.2f%n", monthlySalary);
        System.out.printf("Gross Yearly Salary: PHP %.2f%n", grossYearlySalary);
        System.out.printf("Net Yearly Salary   : Php %.2f%n", netYearlySalary);

        scanner.close();

    }
}