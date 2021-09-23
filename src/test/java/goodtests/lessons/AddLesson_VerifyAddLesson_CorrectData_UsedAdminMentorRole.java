package goodtests.lessons;

import driver.ChromeDriverManager;
import driver.DriverManager;
import goodtests.login.Login;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class AddLesson_VerifyAddLesson_CorrectData_UsedAdminMentorRole {
    DriverManager manager;
    WebDriver driver;
    private static final Logger log =
            LogManager.getLogger(AddLesson_VerifyAddLesson_CorrectData_UsedAdminMentorRole.class);

    @BeforeTest
    public void setup(){
        manager = new ChromeDriverManager();
        driver = manager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
    }

    @Test
    public void shouldBeAddedLesson(){

    }

    @AfterTest
    public void shutDown(){
        manager.quitDriver();
    }
}
