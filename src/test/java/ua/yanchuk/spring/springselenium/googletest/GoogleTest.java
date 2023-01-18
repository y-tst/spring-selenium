package ua.yanchuk.spring.springselenium.googletest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import ua.yanchuk.spring.springselenium.SpringBaseTesNGTest;
import ua.yanchuk.spring.springselenium.page.google.GooglePage;
import ua.yanchuk.spring.springselenium.utils.ScreenShotUtil;

import java.io.IOException;

public class GoogleTest extends SpringBaseTesNGTest {

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotUtil.takeScreenShot();
    }
}
