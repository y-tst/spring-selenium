package ua.yanchuk.spring.springselenium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    private Address address;

    @Autowired
    private Salary salary;

    /*
    public User(Address address, Salary salary) {
        this.address = address;
        this.salary = salary;
    }
     */

    /*
        @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Autowired
    public void setSalary(Salary salary) {
        this.salary = salary;
    }
     */


    public void printDetails() {
        System.out.println("Address: "+ this.address.getStreet());
        System.out.println("Salary: "+ this.salary.getAmount());
    }
}
