package ua.yanchuk.spring.springselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

    @Value("${street}")
    private String street;

    /*
        public Address() {
        this.street = "101 non main Street";
    }
     */

    public String getStreet() {
        return street;
    }
}
