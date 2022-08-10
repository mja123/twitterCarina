package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class MyAbstractPage extends AbstractPage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public MyAbstractPage(WebDriver driver) {
        super(driver);
    }

    protected void waitVisibility(ExtendedWebElement target) {
        try {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOf(target.getElement()));

        } catch (TimeoutException ex) {
            LOGGER.error("The element " + target.getText() + " is not visible.");
        }
    }

    protected void waitClickable(ExtendedWebElement target) {
        try {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.elementToBeClickable(target.getElement()));
        } catch (TimeoutException ex) {
            LOGGER.error("The element " + target.getText() + " is not clickable.");
        }
    }
}
