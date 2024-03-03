package model.services;

public class AngolaTaxService implements TaxService {
    
    public double tax(double amount) {
        if (amount <= 100.0) {
            return amount * .2;
        }
        else {
            return amount * .15;
        }
    }
}
