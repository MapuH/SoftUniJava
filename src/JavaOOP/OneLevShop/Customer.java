package JavaOOP.OneLevShop;

import JavaOOP.OneLevShop.enumerations.AgeRestriction;

public class Customer {

    private String name;
    private int age;
    private double balance;

    public Customer(String name, int age, double balance) {
        this.setName(name);
        this.setAge(age);
        this.setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Age cannot be a negative number!");
        } else {
            this.age = age;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isAllowedToBuy(Product product) {
        if (this.getAge() >= 18 || product.getAgeRestriction() == AgeRestriction.NONE) {
            return true;

        } else if (this.getAge() >= 14 && product.getAgeRestriction() == AgeRestriction.TEENAGER) {
            return true;

        } else return false;
    }

    @Override
    public String toString() {
        return String.format(
                "%S [ Name: %s, Age: %d, Balance: $%,.2f ]\n",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getBalance());
    }
}
