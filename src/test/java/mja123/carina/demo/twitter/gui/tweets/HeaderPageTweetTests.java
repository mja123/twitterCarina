package mja123.carina.demo.twitter.gui.tweets;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import mja123.carina.demo.twitter.gui.HomePage;
import mja123.carina.demo.twitter.gui.component.HeaderPage;
import mja123.carina.demo.twitter.gui.utilsLogin.LoginWithCredentials;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalTime;

import static org.testng.AssertJUnit.assertTrue;

public class HeaderPageTweetTests implements IAbstractTest {
    @Test
    public void postAValidTweet() throws IOException {
        HomePage homePage = new LoginWithCredentials().loginCredentials();
        HeaderPage headerPage = homePage.getHeader();
        headerPage.postTweetHeaderPage(LocalTime.now().toString());
        assertTrue(getDriver().getPageSource().contains("Your Tweet was sent."));
    }
}
