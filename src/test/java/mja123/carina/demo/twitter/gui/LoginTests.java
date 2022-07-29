package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import mja123.carina.demo.twitter.gui.login.CredentialsLogin;
import mja123.carina.demo.twitter.gui.login.GoogleLogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class LoginTests implements IAbstractTest {

    private  WelcomePage welcomePage;
    private Properties properties;
    private String email;
    private String password;
    private String username;

    @BeforeMethod
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