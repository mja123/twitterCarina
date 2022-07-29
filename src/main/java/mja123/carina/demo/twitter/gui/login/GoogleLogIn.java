package mja123.carina.demo.twitter.gui.login;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import mja123.carina.demo.twitter.gui.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class GoogleLogIn extends AbstractLoginPage {

    @FindBy(xpath = "//iframe[contains(@src, 'https://accounts.google.com')]")
    private List<ExtendedWebElement> frames;
    @FindBy(xpath = "//span[@class= 'nsm7Bb-HzV7m-LgbsSe-BPrWId']")
    private ExtendedWebElement accessWithGoogle;
    @FindBy(xpath = "//input[@type='email']")
    private ExtendedWebElement emailInput;
    @FindBy(xpath = "//input[@type='password']")
    private ExtendedWebElement passwordInput;
    @FindBy(xpath = "//span[text()=('Siguiente')]")
    private ExtendedWebElement nextButton;

    public GoogleLogIn(WebDriver driver) {
        super(driver);
    }

    public void switchFrame() {

        LOGGER.info("Switching to google login window");
        LOGGER.info("List size: " + frames.size());
        driver.switchTo().frame(frames.get(0).getElement());
        accessWithGoogle.click();
        /*for (ExtendedWebElement frame : frames) {
            new WebDriverWait(driver, 3000)
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame.getElement()));
            driver.switchTo().frame(frame.getElement())
            driver.switchTo().frame(frame.getElement());
            frame.click();
            break;
        }*/


    }

    @Override
    public HomePage logIn(String email, String username, String password) {
        LOGGER.info("Sending keys");
        waitVisibility(emailInput);
        emailInput.type(email);
        nextButton.click();

        sendUsername(username);

        waitVisibility(passwordInput);
        passwordInput.type(password);
        nextButton.click();

        return new HomePage(driver);
    }
}
