package mja123.carina.demo.twitter.gui.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MyAbstractUIObject extends AbstractUIObject {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public MyAbstractUIObject(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
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
}
