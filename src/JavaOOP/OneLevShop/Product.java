package JavaOOP.OneLevShop;

import JavaOOP.OneLevShop.enumerations.AgeRestriction;
import JavaOOP.OneLevShop.interfaces.Buyable;

public abstract class Product implements Buyable {

    private String name;
    private double price;
    private int quantity;
    private AgeRestriction ageR;

    public Product(String name, double price, int quantity, AgeRestriction ageR) {
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setAgeRestriction(ageR);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalStateException("Price cannot have a negative value!");
        } else {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalStateException("Quantity cannot be negative number!");
        } else {
            this.quantity = quantity;
        }
    }

    public AgeRestriction getAgeRestriction() {
        return ageR;
    }

    public void setAgeRestriction(AgeRestriction ageR) {
        this.ageR = ageR;
    }
}
