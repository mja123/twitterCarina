package mja123.carina.demo.twitter.gui;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;


public class LoginTests implements IAbstractTest {

    @Test
    public void logInWithGoogle() {
        LogIn logIn = new LogIn(getDriver());
        logIn.open();
        Assert.assertTrue(logIn.isPageOpened());
        Properties properties = new Properties();

        HomePage homePage = logIn.loginGoogle(properties.getProperty("email"), properties.getProperty("password"));

        Assert.assertNotNull(homePage);

    }
}