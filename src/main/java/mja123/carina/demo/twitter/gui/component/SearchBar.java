package mja123.carina.demo.twitter.gui.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import mja123.carina.demo.twitter.gui.SearchPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SearchBar extends MyAbstractUIObject {

    @FindBy(xpath = "//input[@aria-label='Search query']")
    private ExtendedWebElement inputSearch;

    public SearchBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchPage search(String input) {
        inputSearch.type(input);

        return new SearchPage(driver);
    }
}
