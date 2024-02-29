package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountException;

public class App {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = scanner.nextInt();
            System.out.print("Holder: ");
            scanner.nextLine();
            String holder = scanner.nextLine();
            System.out.print("Initial balance: ");
            Double balance = scanner.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = scanner.nextDouble();
            System.out.print("\nEnter amount for withdraw: ");
            Double amountForWithdraw = scanner.nextDouble();
    
            Account account = new Account(number, holder, balance, withdrawLimit);
            account.withdraw(amountForWithdraw);
            System.out.printf("New balance: %.2f%n", account.getBalance());
        }
        catch (AccountException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }

        scanner.close();
    }
}
