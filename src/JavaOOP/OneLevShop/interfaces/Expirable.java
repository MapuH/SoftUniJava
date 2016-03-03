package JavaOOP.OneLevShop.interfaces;

import java.util.Date;

public interface Expirable {

    Date getExpirationDate();

    void setExpirationDate(String expirationDate);

    int getDaysToExpiration();

    boolean hasExpired();
}
