package ua.yanchuk.spring.springselenium.page.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.yanchuk.spring.springselenium.page.Base;

import java.util.List;
import java.util.stream.Collectors;

public class SearchComponent extends Base {

    @FindBy (name = "q")
    private WebElement searchBox;

    @FindBy (name = "btnK")
    private List <WebElement> searchBtns;

    public void search(String keyword) {
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    protected boolean isAt() {
        return this.wait.until(d -> this.searchBox.isDisplayed());
    }
}
