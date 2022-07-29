package mja123.carina.demo.twitter.gui.login;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import mja123.carina.demo.twitter.gui.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CredentialsLogin extends AbstractLoginPage {
    @FindBy(xpath = "//input[@autocomplete='username']")
    private ExtendedWebElement emailnput;
    @FindBy(xpath = "//span[text()='Siguiente']/../../..")
    private ExtendedWebElement nextButton;
    @FindBy(xpath = "//input[@autocomplete='current-password']")
    private ExtendedWebElement passwordInput;
    @FindBy(xpath = "//div[@data-testid='LoginForm_Login_Button']")
    private ExtendedWebElement loginButton;

    public CredentialsLogin(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage logIn(String email, String username, String password) {
        LOGGER.info("Logging with credentials");

        waitVisibility(emailnput);
        LOGGER.info("Typing username");
        emailnput.type(email, 3000L);
        nextButton.click();

        sendUsername(username);

        LOGGER.info("Typing password");
        waitVisibility(passwordInput);
        passwordInput.type(password, 3000L);
        loginButton.click();

        return new HomePage(driver);
    }

}
