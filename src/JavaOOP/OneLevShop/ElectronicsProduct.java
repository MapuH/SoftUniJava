package JavaOOP.OneLevShop;

import JavaOOP.OneLevShop.enumerations.AgeRestriction;

public abstract class ElectronicsProduct extends Product {

    private int guaranteePeriod;

    public ElectronicsProduct(String name, double price, int quantity, AgeRestriction ageR, int guaranteePeriod) {
        super(name, price, quantity, ageR);
        this.setGuaranteePeriod(guaranteePeriod);
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    @Override
    public String toString() {
        return String.format(
                "%S [ Name: %s; Price: $%.2f; Quantity: %d; Age restriction: %s; Guarantee period: %d months ]\n",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getPrice(),
                this.getQuantity(),
                this.getAgeRestriction(),
                this.getGuaranteePeriod());
    }
}
