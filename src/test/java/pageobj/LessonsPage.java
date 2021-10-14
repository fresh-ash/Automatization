package pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LessonsPage extends LoggedInPage {

    private final By pageName = By.xpath("//h2[text()='Lessons']");
    //private final By sideBar = By.xpath("//span[@class='sidebar__menu-item___1MMsk']");
    private final By addLessonButton = By.xpath("//button[contains(.,'Add a lesson')]");
    private final By addLessonButton1 = By.xpath("//span[text()='lessonDate']");

    private final By addTheme = By.cssSelector(".btn-warning");

    public LessonsPage(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

    }

    public String getTitle(){
        return driver.findElement(pageName).getText();
    }

    public AddLessonPage clickAddLessonButton(){
        System.out.println(driver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addLessonButton));
        driver.findElement(addLessonButton).click();
        return new AddLessonPage(driver);
    }
}
