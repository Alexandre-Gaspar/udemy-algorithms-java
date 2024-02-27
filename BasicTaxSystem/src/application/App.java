package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayer = new ArrayList<>();

        System.out.print("\nEnter the number of tax payers: ");
        int numberOfTaxPayer = sc.nextInt();

        int count = 0;
        while (count < numberOfTaxPayer) {
            ++count;
            System.out.println("Tax payer #" + count + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            Double annualIncome = sc.nextDouble();

            if (type == 'i' || type == 'I') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();

                taxPayer.add(new Individual(name, annualIncome, healthExpenditures));
            } else if (type == 'c' || type == 'C') {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();

                taxPayer.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }

        System.out.println("\nTAXES PAID:");
        for (TaxPayer each : taxPayer) {
            System.out.printf("%s: $ %.2f%n", each.getName(), each.tax());
        }

        Double totalTaxes = .0; // Initializing the totalTaxes variable assgning 0.0 ...
        for (TaxPayer each : taxPayer) {
            totalTaxes += each.tax();
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f%n", totalTaxes);
        
    
        sc.close();
    }
}
