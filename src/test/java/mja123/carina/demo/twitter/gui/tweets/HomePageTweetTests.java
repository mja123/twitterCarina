package mja123.carina.demo.twitter.gui.tweets;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import mja123.carina.demo.twitter.gui.HomePage;
import mja123.carina.demo.twitter.gui.utilsLogin.LoginWithCredentials;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalTime;

import static org.testng.AssertJUnit.*;

public class HomePageTweetTests implements IAbstractTest {
    @Test
    public void postACorrectTweet() throws IOException {

        HomePage homePage = new LoginWithCredentials().loginCredentials();
        String content = "Tweet tweet tweet" + LocalTime.now();
        homePage.postTweet(content);
        assertTrue(getDriver().getPageSource().contains("Your Tweet was sent."));
    }
}
