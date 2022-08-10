package mja123.carina.demo.twitter.gui.utilsLogin;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import mja123.carina.demo.twitter.gui.HomePage;
import mja123.carina.demo.twitter.gui.login.CredentialsLogin;
import mja123.carina.demo.twitter.gui.login.ELoginPage;
import mja123.carina.demo.twitter.gui.login.WelcomePage;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class LoginWithCredentials implements IAbstractTest {
    public HomePage loginCredentials() throws IOException {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();

        Properties properties = new Properties();
        FileReader reader = new FileReader(System.getenv("TWITTER_CREDENTIALS"));
        properties.load(reader);
        String email = properties.getProperty("EMAIL");
        String password = properties.getProperty("PASSWORD");
        String username = properties.getProperty("USERNAME");

        CredentialsLogin login = (CredentialsLogin) welcomePage.goLoginPage(ELoginPage.CREDENTIALS);

        return login.logIn(email, username, password);
    }
}
