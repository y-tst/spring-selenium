package ua.yanchuk.spring.springselenium.googletest;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import ua.yanchuk.spring.springselenium.SpringBaseTesNGTest;
import ua.yanchuk.spring.springselenium.page.google.GooglePage;
import ua.yanchuk.spring.springselenium.utils.ScreenShotUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleTest extends SpringBaseTesNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("environment ");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
//        this.screenShotUtil.takeScreenShot("img.png");
    }
}
