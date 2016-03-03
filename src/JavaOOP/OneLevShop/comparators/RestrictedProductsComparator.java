package JavaOOP.OneLevShop.comparators;

import JavaOOP.OneLevShop.Product;

import java.util.Comparator;

public class RestrictedProductsComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
