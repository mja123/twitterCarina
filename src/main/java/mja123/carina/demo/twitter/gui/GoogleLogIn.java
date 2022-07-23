package mja123.carina.demo.twitter.gui;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class GoogleLogIn extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//input[@type='email']")
    private ExtendedWebElement email;
    @FindBy(xpath = "//input[@type='password']")
    private ExtendedWebElement password;
    @FindBy(xpath = "//span[text()=('Siguiente')]")
    private ExtendedWebElement nextButton;

    public GoogleLogIn(WebDriver driver) {
        super(driver);
    }

    public HomePage logInWithGoogle(String address, String pwd) {
        LOGGER.info("Sending keys");
        email.type(address);
        nextButton.click();
        assertElementPresent(password);
        password.type(pwd);
        nextButton.click();
        return new HomePage(driver);
    }
}
