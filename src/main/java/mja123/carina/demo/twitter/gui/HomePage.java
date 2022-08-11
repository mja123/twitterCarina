package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import mja123.carina.demo.twitter.gui.component.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends MyAbstractPage {
    @FindBy(xpath = "//header")
    private HeaderPage header;
    @FindBy(xpath = "//div[@data-testid='sidebarColumn']")
    private SearchPage searchBar;
    @FindBy(xpath = "//div[@aria-label='Tweet text']")
    private ExtendedWebElement inputTweet;
    @FindBy(xpath = "//div[@data-testid='tweetButtonInline']")
    private ExtendedWebElement buttonTweet;

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

    public void postTweet(String content) {
        inputTweet.type(content);
        buttonTweet.click();
    }
}
