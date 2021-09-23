package tests;

import driver.ChromeDriverManager;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestGitHub {

    DriverManager manager;
    WebDriver driver;

    @BeforeTest
    public void preconditions(){
        manager = new ChromeDriverManager();
        driver = manager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://github.com/");
    }

    @Test
    public void testRedirect(){
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a")).click();
        System.out.println(driver.getCurrentUrl());
    }

    @AfterTest
    public void shutDown(){
        manager.quitDriver();
    }

}
