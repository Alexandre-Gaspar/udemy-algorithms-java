package models.entities;

public class ImportedProduct extends Product{
    
    private Double customsTag;

    public ImportedProduct(String name, Double price, Double customsTag) {
        super(name, price);
        this.customsTag = customsTag;
    }

    public Double getCustomsTag() {
        return customsTag;
    }

    public void setCustomsTag(Double customsTag) {
        this.customsTag = customsTag;
    }
    
    @Override
    public String priceTag() {

    }

    public Double totalPrice() {

    }

}
