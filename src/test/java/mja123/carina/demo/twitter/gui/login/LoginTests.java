package mja123.carina.demo.twitter.gui.login;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import mja123.carina.demo.twitter.gui.HomePage;
import mja123.carina.demo.twitter.gui.login.CredentialsLogin;
import mja123.carina.demo.twitter.gui.login.ELoginPage;
import mja123.carina.demo.twitter.gui.login.GoogleLogIn;
import mja123.carina.demo.twitter.gui.login.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class LoginTests implements IAbstractTest {

    private WelcomePage welcomePage;
    private Properties properties;
    private String email;
    private String password;
    private String username;

    @BeforeClass
    public void setUp() throws IOException {
        welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        Assert.assertTrue(welcomePage.isPageOpened());

        properties = new Properties();
        FileReader reader = new FileReader(System.getenv("TWITTER_CREDENTIALS"));
        properties.load(reader);
        email = properties.getProperty("EMAIL");
        password = properties.getProperty("PASSWORD");
        username = properties.getProperty("USERNAME");
    }

    @Test
    public void logInWithGoogle() {
        GoogleLogIn login = (GoogleLogIn) welcomePage.goLoginPage(ELoginPage.CREDENTIALS);

        login.switchFrame();
        HomePage homePage = login.logIn(email, username, password);

        Assert.assertNotNull(homePage);
    }

    @Test
    public void loginWithCredentials() {
        CredentialsLogin login = (CredentialsLogin) welcomePage.goLoginPage(ELoginPage.CREDENTIALS);

        HomePage homePage = login.logIn(email, username, password);

        Assert.assertNotNull((homePage));

    }
}