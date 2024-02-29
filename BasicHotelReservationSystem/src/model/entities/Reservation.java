package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainExeption;

public class Reservation {
    
    public static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    LocalDate dateOfToday = LocalDate.now(); // Get the current date
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;
    
    public Reservation() {} // Empty construtor ...

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        if (checkin.isBefore(dateOfToday) || checkout.isBefore(dateOfToday)) {
            throw new DomainExeption("Reservation dates for update must be future dates");
        }
        if (!checkout.isAfter(checkin)) {
            throw new DomainExeption("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }
    
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public long duration() {
        long durationInDays = ChronoUnit.DAYS.between(checkin, checkout); // Faz a diferênça de datas e retorna em dias
        return durationInDays;
    }

    public String UpdateDates(LocalDate checkin, LocalDate checkout) {
        
        if (checkin.isBefore(dateOfToday) || checkout.isBefore(dateOfToday)) {
            throw new DomainExeption("Reservation dates for update must be future dates");
        }
        if (!checkout.isAfter(checkin)) {
            throw new DomainExeption("Check-out date must be after check-in date");
        }
        
        this.checkin = checkin;
        this.checkout = checkout;

        return null;
    }

    @Override
    public String toString() {
        return "Room "
            + this.roomNumber
            + ", check-in: "
            + checkin.format(format)
            + ", check-out: "
            + checkout.format(format)
            + ", "
            + duration()
            + " nights";
    }

    
}