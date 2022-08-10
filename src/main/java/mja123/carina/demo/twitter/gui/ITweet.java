package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public interface ITweet extends IDriverPool {
    default void postTweet(String content) {
        getDriver().findElement(By.xpath("//div[@aria-label='Tweet text']")).sendKeys(content);
        getDriver().findElement(By.xpath ("//div[@data-testid='tweetButtonInline']")).click();
    }
}
