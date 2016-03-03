package JavaOOP.OneLevShop;

import JavaOOP.OneLevShop.enumerations.AgeRestriction;
import JavaOOP.OneLevShop.interfaces.Expirable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodProduct extends Product implements Expirable {

    private Date expirationDate;

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageR) {
        super(name, price, quantity, ageR);
    }

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageR, String expirationDate) {
        this (name, price, quantity, ageR);
        setExpirationDate(expirationDate);
    }

    @Override
    public double getPrice() {
        if (this.getDaysToExpiration() < 15) {
            return super.getPrice() * 0.7;
        } else {
            return super.getPrice();
        }
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(String expirationDate) {
        try {
            this.expirationDate = new SimpleDateFormat("dd-MM-yyyy").parse(expirationDate);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    @Override
    public int getDaysToExpiration() {
        if (this.expirationDate != null) {
            return (int)((this.getExpirationDate().getTime() - new Date().getTime())/(1000 * 60 * 60 * 24.0));
        } else {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public boolean hasExpired() {
        return getDaysToExpiration() < 0;
    }

    @Override
    public String toString() {
        if (this.getExpirationDate() != null) {
            return String.format(
                    "%S [ Name: %s; Price: $%.2f; Quantity: %d; Age restriction: %s; Expiration date: %6$td-%6$tm-%6$tY ]\n",
                    this.getClass().getSimpleName(),
                    this.getName(),
                    this.getPrice(),
                    this.getQuantity(),
                    this.getAgeRestriction(),
                    this.getExpirationDate());
        } else {
            return String.format(
                    "%S [ Name: %s; Price: $%.2f; Quantity: %d; Age restriction: %s; Expiration date: N/A ]\n",
                    this.getClass().getSimpleName(),
                    this.getName(),
                    this.getPrice(),
                    this.getQuantity(),
                    this.getAgeRestriction());
        }
    }
}
