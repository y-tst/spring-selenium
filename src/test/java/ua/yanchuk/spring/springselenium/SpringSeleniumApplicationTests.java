package ua.yanchuk.spring.springselenium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSeleniumApplicationTests {

	@Test
	void contextLoads() {

		Address address = new Address();
		Salary salary = new Salary();

		User user = new User(address, salary);
		user.printDetails();
	}

}
