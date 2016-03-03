package JavaOOP.OneLevShop;

import JavaOOP.OneLevShop.enumerations.AgeRestriction;

public class Appliance extends ElectronicsProduct {

    public Appliance(String name, double price, int quantity, AgeRestriction ageR) {
        super(name, price, quantity, ageR, 6);
    }

    @Override
    public double getPrice() {
        if (this.getQuantity() < 50) {
            return super.getPrice() * 1.05;
        } else {
            return super.getPrice();
        }
    }
}
