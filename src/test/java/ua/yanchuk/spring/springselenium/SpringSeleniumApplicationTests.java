package ua.yanchuk.spring.springselenium;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringSeleniumApplicationTests {

    @Autowired
    private User user;

//    @Value("${PATH}")
//    private String path;

    @Value("${fruits}")
    private List<String> fruits;   // Spring automatically converts variable type from property

    @Value("${timeout}")
    private int timeout;

    @Value("${myusername}")
    private String username;

    @Test
    void contextLoads() {

        System.out.println(this.fruits);
        System.out.println(this.fruits.size());
        System.out.println(this.timeout);
        System.out.println(this.username);

//        user.printDetails();
    }

	/*
		Address address = new Address();
		Salary salary = new Salary();
		User user = new User(address, salary);
		user.printDetails();
	 */

}
