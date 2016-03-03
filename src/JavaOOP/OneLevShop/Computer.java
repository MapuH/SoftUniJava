package JavaOOP.OneLevShop;

import JavaOOP.OneLevShop.enumerations.AgeRestriction;

public class Computer extends ElectronicsProduct {

    public Computer(String name, double price, int quantity, AgeRestriction ageR) {
        super(name, price, quantity, ageR, 24);
    }

    @Override
    public double getPrice() {
        if (this.getQuantity() > 1000) {
            return super.getPrice() * 0.95;
        } else {
            return super.getPrice();
        }
    }
}
