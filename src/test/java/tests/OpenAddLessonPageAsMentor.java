package tests;

import driver.ChromeDriverManager;
import driver.DriverManager;
import interfaces.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobj.AddLessonPage;
import pageobj.AuthPage;
import pageobj.Lessons;

import java.time.Duration;

public class OpenAddLessonPageAsMentor {

    DriverManager manager;
    WebDriver driver;
    Lessons lessons;

    @BeforeTest
    public void preconditions(){
        manager = new ChromeDriverManager();
        driver = manager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get(Constants.BASE_URL);
        AuthPage authPage = new AuthPage(driver);
        lessons = authPage.logInAsMentor();
    }

    @Test
    public void shouldBeOpenedAddLessonPage(){

        String expectedResult = "Add a Lesson";

        AddLessonPage addLessonPage = lessons.clickAddLesson();
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(addLessonPage.getTitle(), expectedResult);
    }

    @AfterTest
    public void shutDown(){
        manager.quitDriver();
    }
}
