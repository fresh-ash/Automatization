import driver.ChromeDriverManager;
import driver.DriverManager;
import interfaces.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobj.AuthPage;
import pageobj.Lessons;
import java.time.Duration;


public class TestDriver {

    DriverManager manager = new ChromeDriverManager();

    @Test
    public void test(){

        WebDriver driver = manager.getDriver();
        driver.get(Constants.BASE_URL + "/auth");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        AuthPage authPage = new AuthPage(driver);
        authPage.enterEmail("MentoR01@gmail.com");
        authPage.enterPass("What_123");
        Lessons lessons = authPage.clickSignInButton();
    }

    @AfterTest
    public void close(){
        manager.quitDriver();
    }
}
