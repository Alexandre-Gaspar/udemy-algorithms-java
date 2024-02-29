package application;

// import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExeption;

public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateOnly = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        try {

            System.out.print("Room number: ");
            Integer roomNumber = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            sc.nextLine();
            LocalDate checkin = LocalDate.parse(sc.nextLine(), dateOnly);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkout = LocalDate.parse(sc.nextLine(), dateOnly);
    
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation + "\n");
            
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = LocalDate.parse(sc.nextLine(), dateOnly);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = LocalDate.parse(sc.nextLine(), dateOnly);
    
            reservation.UpdateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch (DomainExeption e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }

        sc.close();
    }
}
