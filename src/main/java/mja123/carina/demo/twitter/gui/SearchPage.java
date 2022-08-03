package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends MyAbstractPage {
    @FindBy(xpath = "//span[text()='Top']")
    private ExtendedWebElement topSection;
    @FindBy(xpath = "//span[text()='Latest']")
    private ExtendedWebElement latestSection;
    @FindBy(xpath = "//span[text()='People']")
    private ExtendedWebElement peopleSection;
    @FindBy(xpath = "//span[text()='Photos']")
    private ExtendedWebElement imageSection;
    @FindBy(xpath = "//span[text()='Videos']")
    private ExtendedWebElement videoSection;

    public SearchPage(WebDriver driver) {
        super(driver);
    }


}
