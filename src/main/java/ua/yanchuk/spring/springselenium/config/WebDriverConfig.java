package ua.yanchuk.spring.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().driverVersion("131.0.6778.265").setup();
        return new ChromeDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().driverVersion("134.0 (64-bit)").setup();
        return new FirefoxDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}