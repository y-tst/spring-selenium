package ua.yanchuk.spring.springselenium.page.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ua.yanchuk.spring.springselenium.page.Base;

import java.util.List;

@Component
public class SearchResult extends Base {

    @FindBy(css = "#rso>div")
    public List<WebElement> searchResults;

    public int getCount() {
        return this.searchResults.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> !this.searchResults.isEmpty());
    }
}
