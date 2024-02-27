package entities;

public class Company extends TaxPayer {
    
    private int numberOfEmpoyees;

    public Company(String name, Double annualIncome, int numberOfEmpoyees) {
        super(name, annualIncome);
        this.numberOfEmpoyees = numberOfEmpoyees;
    }

    public int getNumberOfEmpoyees() {
        return numberOfEmpoyees;
    }

    public void setNumberOfEmpoyees(int numberOfEmpoyees) {
        this.numberOfEmpoyees = numberOfEmpoyees;
    }
    


    @Override
    public Double tax() {
        if (numberOfEmpoyees > 10) {
            return getAnnualIncome()*.14;
        }

        return getAnnualIncome()*.16;
    }
}
