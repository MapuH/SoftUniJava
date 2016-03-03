package JavaOOP.OneLevShop;

import JavaOOP.OneLevShop.comparators.ExpirationDateComparator;
import JavaOOP.OneLevShop.comparators.RestrictedProductsComparator;
import JavaOOP.OneLevShop.enumerations.AgeRestriction;
import java.util.*;

/**
 * Created by marin on 3/3/16.
 *
 * Design a class hierarchy that models a shop.
 *
 * Happy Liberation Day, Bulgaria!
 */
public class PurchaseManager {

    public static void processPurchase(Product product, Customer customer) throws Exception {

        if (product.getQuantity() < 1) {
            throw new Exception("Product is no longer available!");
        }

        if (product instanceof FoodProduct && ((FoodProduct) product).hasExpired()) {
            throw new Exception("This product has expired!");
        }

        if (customer.getBalance() < product.getPrice()) {
            throw new Exception(String.format("%s hasn't got enough money to buy %s!\n",
                            customer.getName(), product.getName()));
        }

        if (!customer.isAllowedToBuy(product)) {
            throw new Exception(String.format("%s is not allowed to buy this product!", customer.getName()));
        }

        customer.setBalance(customer.getBalance() - product.getPrice());
        product.setQuantity(product.getQuantity() - 1);
        System.out.printf("%s bought one %s!\n", customer.getName(), product.getName());

    }

    public static void main(String[] args) {

        try {

            // Create products
            Product yogurt = new FoodProduct("Balkan Yogurt", 0.70, 250, AgeRestriction.NONE, "15-03-2016");
            Product bread = new FoodProduct("Bread \'Bulgaria\'", 0.85, 120, AgeRestriction.NONE, "06-03-2016");
            Product vodka = new FoodProduct("Absolut Vodka", 12.0, 56, AgeRestriction.ADULT);
            Product cigarettes = new FoodProduct("Arda no filter", 2.60, 70, AgeRestriction.ADULT);
            Product cheese = new FoodProduct("Vitosha cheese", 5.80, 43, AgeRestriction.NONE, "25-04-2016");
            Product salami = new FoodProduct("Tandem salami", 7.99, 65, AgeRestriction.NONE, "01-05-2016");
            Product protein = new FoodProduct("Power Protein Gainer", 25.59, 24, AgeRestriction.TEENAGER, "05-02-2017");
            Product lenovo = new Computer("Lenovo G580", 679.00, 58, AgeRestriction.NONE);
            Product acer = new Computer("Acer X564", 584.00, 45, AgeRestriction.NONE);
            Product toaster = new Appliance("Toaster Bosch", 89.0, 42, AgeRestriction.NONE);
            Product oven = new Appliance("Oven Gorenje", 549.00, 23, AgeRestriction.NONE);

            // Create customers
            Customer vladi = new Customer("Vladi", 39, 4320.0);
            Customer peter = new Customer("Peter", 24, 960.0);
            Customer dinko = new Customer("Dinko", 16, 54.0);

            // Sort expirable and restricted products
            // NOTE: Not using lambda expressions as working on Java 7
            List<Product> allProducts = new ArrayList<>(Arrays.asList(yogurt, bread, vodka, cigarettes, cheese,
                    salami, protein, lenovo, acer, toaster, oven));
            List<FoodProduct> expirableProducts = new ArrayList<>();
            List<Product> restrictedProducts = new ArrayList<>();

            for (Product product : allProducts) {
                if (product instanceof FoodProduct && ((FoodProduct) product).getExpirationDate() != null) {
                    expirableProducts.add((FoodProduct) product);
                }

                if (product.getAgeRestriction() == AgeRestriction.ADULT) {
                    restrictedProducts.add(product);
                }
            }

            Collections.sort(expirableProducts, new ExpirationDateComparator());
            System.out.println("Product, which will expire the soonest:");
            System.out.printf("%s, expiration date: %2$td-%2$tm-%2$tY\n",
                    expirableProducts.get(0).getName(), expirableProducts.get(0).getExpirationDate());
            System.out.println();

            System.out.println("Adult restricted products sorted by price:");
            Collections.sort(restrictedProducts, new RestrictedProductsComparator());
            for (Product product : restrictedProducts) {
                System.out.println(product.toString().replace("\n", ""));
            }
            System.out.println();

            // Make some purchases
            System.out.println("Customers' purchases:");
            processPurchase(lenovo, vladi);
            processPurchase(vodka, peter);
            processPurchase(cigarettes, dinko);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
