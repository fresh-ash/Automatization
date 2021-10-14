package pageobj;

import interfaces.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class AddLessonPage {

    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(AddLessonPage.class);

    public AddLessonPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    private final By inputLessonTheme = By.id("inputLessonTheme");
    private final By inputGroupName = By.id("inputGroupName");
    private final By chooseDateTime = By.id("choose-date-time");
    private final By mentorEmail = By.id("mentorEmail");
    private final By classRegisterButton = By.id("class-register-btn");
    //private final By cancelButton = By.className("btn btn-secondary btn-lg");
    private final By addLessonButton2 = By.id("group-list");

    public AddLessonPage fillLessonTheme(String str){
        driver.findElement(inputLessonTheme).sendKeys(str);
        return this;
    }

    public void clickClassRegisterButton(){
        driver.findElement(classRegisterButton).click();
    }


    public String getTitle(){
        List<WebElement> elementList = driver.findElements(addLessonButton2);
        for (WebElement element : elementList){
            System.out.println(element);
        }

        return null;
    }
}
