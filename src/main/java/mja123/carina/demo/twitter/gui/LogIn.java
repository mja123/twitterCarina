package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Iterator;
import java.util.Set;

public class LogIn extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//a[@data-testid='loginButton']")
    private ExtendedWebElement signIn;
    @FindBy(xpath = "//div[@id='container'][1]")
    private ExtendedWebElement accessWithGoogle;

    public LogIn(WebDriver driver) {
        super(driver);
        /*setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));*/
    }

    public HomePage loginGoogle(String email, String password) {
        LOGGER.info("Clicking sign in button");
        signIn.click();
        assertElementPresent(accessWithGoogle);
        accessWithGoogle.click();

        LOGGER.info("Changing the tab");
        Set<String> browsers = driver.getWindowHandles();

        Iterator<String> iterator = browsers.iterator();

        String parentWindow = iterator.next();
        String popUp = iterator.next();

        driver.switchTo().window(popUp);

        GoogleLogIn google = new GoogleLogIn(driver);
        HomePage homePage = google.logInWithGoogle(email, password);
        driver.switchTo().window(parentWindow);
        return homePage;
    }
}
