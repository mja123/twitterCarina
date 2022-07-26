package mja123.carina.demo.twitter.gui.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import mja123.carina.demo.twitter.gui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HeaderPage extends MyAbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//a[@href='/notifications']")
    private ExtendedWebElement notification;
    @FindBy(xpath = "//a[@href='/home']")
    private ExtendedWebElement home;
    @FindBy(xpath = "//a[@href='/explore']")
    private ExtendedWebElement explore;
    @FindBy(xpath = "//a[@href='/messages']")
    private ExtendedWebElement messages;
    @FindBy(xpath = "//a[@aria-label='Profile']")
    private ExtendedWebElement profile;
    @FindBy(xpath = "//div[@aria-label='Account menu']")
    private ExtendedWebElement accountMenu;
    @FindBy(xpath = "//a[@href='/compose/tweet']")
    private ExtendedWebElement displayTweet;
    @FindBy(xpath = "//div[@aria-label='Tweet text']")
    private ExtendedWebElement inputTweet;
    @FindBy(xpath = "//div[@data-testid='tweetButtonInline']")
    private ExtendedWebElement buttonTweet;


    public HeaderPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage goHomePage() {
        home.click();
        return new HomePage(driver);
    }
    public MessagesPage goMessagesPage() {
        messages.click();
        return new MessagesPage(driver);
    }
    public ExplorePage goExplorePage() {
        explore.click();
        return new ExplorePage(driver);
    }
    public NotificationPage goNotificationPage() {
        notification.click();
        return new NotificationPage(driver);
    }
    public ProfilePage goProfilePage() {
        profile.click();
        return new ProfilePage(driver);
    }
    public void goAccountPage() {
        accountMenu.click();
    }

    public void postTweetFromHeader(String content) {
       displayTweet.click();
       inputTweet.type(content);
       buttonTweet.click();
    }
}


