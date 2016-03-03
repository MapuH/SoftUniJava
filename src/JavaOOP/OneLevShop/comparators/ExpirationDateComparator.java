package JavaOOP.OneLevShop.comparators;

import JavaOOP.OneLevShop.FoodProduct;

import java.util.Comparator;

public class ExpirationDateComparator implements Comparator<FoodProduct> {

    @Override
    public int compare(FoodProduct o1, FoodProduct o2) {
        return o1.getExpirationDate().compareTo(o2.getExpirationDate());
    }
}
