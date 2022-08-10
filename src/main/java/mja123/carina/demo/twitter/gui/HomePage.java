package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import mja123.carina.demo.twitter.gui.component.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends MyAbstractPage implements ITweet {
    @FindBy(xpath = "//header")
    private HeaderPage header;
    @FindBy(xpath = "//div[@data-testid='sidebarColumn']")
    private SearchPage searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderPage getHeader() {

        return header;
    }

    public SearchPage getSearchBar() {
        return searchBar;
    }

    public void setHeader(HeaderPage header) {
        this.header = header;
    }

    public void setSearchBar(SearchPage searchBar) {
        this.searchBar = searchBar;
    }
}
