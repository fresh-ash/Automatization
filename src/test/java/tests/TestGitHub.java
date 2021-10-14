package tests;

import driver.ChromeDriverManager;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestGitHub extends BaseTest{

    @BeforeClass
    public void preconditions(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://github.com/");
    }

    public Number add(){
        return 6.88;
    }

    @Test
    public void testRedirect(){
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a")).click();

        System.out.println(driver.getCurrentUrl());
        Number x = add();
    }

}
