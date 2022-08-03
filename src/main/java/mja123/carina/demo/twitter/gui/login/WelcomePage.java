package mja123.carina.demo.twitter.gui.login;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import mja123.carina.demo.twitter.gui.login.AbstractLoginPage;
import mja123.carina.demo.twitter.gui.login.CredentialsLogin;
import mja123.carina.demo.twitter.gui.login.ELoginPage;
import mja123.carina.demo.twitter.gui.login.GoogleLogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class WelcomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@data-testid='loginButton']")
    private ExtendedWebElement signIn;
    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public AbstractLoginPage goLoginPage(ELoginPage loginPage) {
        LOGGER.info("Clicking sign in button");
        signIn.click();

        if (loginPage == ELoginPage.CREDENTIALS) {
            return new CredentialsLogin(driver);
        }
        return new GoogleLogIn(driver);
    }


    public void loginPopUp() {

    }
}
