package pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Lessons {
    
    private final WebDriver driver;

    private final By pageName = By.tagName("h2");
    private final By addLessonButton = By.cssSelector("button.button__default___3hOmG:nth-child(2) > span:nth-child(1)");

    public Lessons(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    public String getTitle(){
        return driver.findElement(pageName).getText();
    }

    public AddLessonPage clickAddLesson(){
        System.out.println(driver.getCurrentUrl());
        driver.findElement(addLessonButton).click();
        return new AddLessonPage(driver);
    }
}
