package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateOnly = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Reservation reservation = new Reservation();
        
        System.out.print("Room number: ");
        Integer roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        sc.nextLine();
        LocalDate checkin = LocalDate.parse(sc.nextLine(), dateOnly);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkout = LocalDate.parse(sc.nextLine(), dateOnly);
        reservation.UpdateDates(checkin, checkout);

        if (!checkout.isAfter(checkin)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation + "\n");
            
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            // sc.nextLine();
            checkin = LocalDate.parse(sc.nextLine(), dateOnly);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = LocalDate.parse(sc.nextLine(), dateOnly);

            LocalDate dateOfToday = LocalDate.now();
            
            if (checkin.isBefore(dateOfToday) || checkout.isBefore(dateOfToday)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (!checkout.isAfter(checkin)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
                reservation.UpdateDates(checkin, checkout);
        
                new Reservation(roomNumber, checkin, checkout);
                System.out.println(reservation);
            }

        }


        sc.close();
    }
}
