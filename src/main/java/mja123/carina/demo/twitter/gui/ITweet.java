package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public interface ITweet {
    default void postTweet(String content) {
        getDriver().findElement(By.xpath("//div[@aria-label='Tweet text']")).sendKeys(content);
        getDriver().findElement(By.xpath ("//div[@data-testid='tweetButtonInline']")).click();
    }
}
/*TODO:
- Solve this issue:
    Implement appropriate AbstractUIObject constructor for auto-initialization!
Goal: use this interface in home and header pages to give the ability to create tweets
from the default method.
Problems: find the way to use the driver to find elements and initialize them
Interfaces and classes to study: IDriverPool, SearchContext and AbstractUIObject.

Momentary solution:
 */

