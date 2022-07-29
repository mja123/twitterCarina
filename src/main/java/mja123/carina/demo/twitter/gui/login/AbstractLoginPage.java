package mja123.carina.demo.twitter.gui.login;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import mja123.carina.demo.twitter.gui.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class AbstractLoginPage extends AbstractPage {

    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//input")
    protected ExtendedWebElement usernameInput;
    @FindBy(xpath = "//span[text()='Siguiente']/../../..")
    protected ExtendedWebElement usernameNextButton;
    @FindBy(xpath = "//span[contains(text(),'Introduce tu número de teléfono')]")
    protected ExtendedWebElement validationPopup;

    public AbstractLoginPage(WebDriver driver) {
        super(driver);
    }

    protected Boolean waitVisibility(ExtendedWebElement target) {
        try {

            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOf(target.getElement()));
            return true;
        } catch (RuntimeException ex) {
            LOGGER.error("The element " + target.getText() + " is not visible.");
            return false;
        }
    }

    protected Boolean waitClickable(ExtendedWebElement target) {
        try {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.elementToBeClickable(target.getElement()));
            return true;
        } catch (RuntimeException ex) {
            LOGGER.error("The element " + target.getText() + " is not clickable.");
            return false;
        }
    }
    //When Twitter sends the unusual login's page
    protected void sendUsername(String username) {

        if (waitVisibility(validationPopup)) {
            waitVisibility(usernameInput);
            usernameInput.type(username);

            usernameNextButton.click();
        }
    }

     protected abstract HomePage logIn(String email, String username, String password);
}
