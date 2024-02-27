package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Employee;
import models.entities.OutsourcedEmployee;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        int count = 0;
        while (count < n) {
            ++count;
            System.out.println("Employee #" + count + " data:");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            
            if (ch == 'y' || ch == 'Y') {
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                list.add(new Employee(name, hours, valuePerHour));
            }

            
        }
        
        System.out.println();
        System.out.println("Payments:");
        for (Employee each : list) {
            System.out.println(each.getName() + " - $ " +
                String.format("%.2f", each.payment())
            );
        }

        sc.close();
    }
}
