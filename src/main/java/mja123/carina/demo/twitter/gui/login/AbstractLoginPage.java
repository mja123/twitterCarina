package mja123.carina.demo.twitter.gui.login;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import mja123.carina.demo.twitter.gui.HomePage;
import mja123.carina.demo.twitter.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class AbstractLoginPage extends MyAbstractPage {

    @FindBy(xpath = "//input")
    protected ExtendedWebElement usernameInput;
    @FindBy(xpath = "//span[text()='Next']/../../..")
    protected ExtendedWebElement usernameNextButton;
    @FindBy(xpath = "//span[contains(text(),'Enter your phone number')]")
    protected ExtendedWebElement validationPopup;

    public AbstractLoginPage(WebDriver driver) {
        super(driver);
    }


    //When Twitter sends the unusual login's page
    protected void sendUsername(String username) {
        /*waitVisibility(validationPopup);
        waitVisibility(usernameInput);*/
        if (validationPopup.isElementPresent()) {
            LOGGER.info(username);
            usernameInput.type(username);
            usernameNextButton.click();
        }

    }

     protected abstract HomePage logIn(String email, String username, String password);
}
