package goodtests.resetpass;

import driver.ChromeDriverManager;
import driver.DriverManager;
import interfaces.Constants;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ResetPasswordValidDataTest {
    DriverManager manager;
    WebDriver driver;

    @BeforeTest
    public void setup(){
        manager = new ChromeDriverManager();
        driver = manager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(Constants.BASE_URL + "/reset-password");
    }

    @Test
    public void shouldBeAbleToResetPassword(){
        User user = new User(driver);
        user.emailIs("doll@doll.com");
        user.newPasswordIs("What_124");
        user.confirmPasswordIs("What_124");
        System.out.println(driver.getCurrentUrl());
        user.resetPassword();
    }


    @AfterTest
    public void shutDown(){
        manager.quitDriver();
    }

}
