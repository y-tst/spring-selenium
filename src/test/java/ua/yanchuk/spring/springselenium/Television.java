package ua.yanchuk.spring.springselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Television {

    @Value("${tv.name:sony}")
    private String name;

    public Television() {
        System.out.println("Inside container: " + this.name);
    }

    @PostConstruct
    private void init() {
        System.out.println("Inside the init: " + this.name);
        System.out.println(" TV is turned on.");
    }

    public void playMovie() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Playing scene: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PreDestroy
    public void turnOff() {
        System.out.println("Television is turned off...");
    }
}


