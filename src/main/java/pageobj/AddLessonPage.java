package pageobj;

import interfaces.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddLessonPage {

    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(AddLessonPage.class);

    public AddLessonPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(Constants.BASE_URL + "/lessons/add");
    }

    private final By inputLessonTheme = By.id("inputLessonTheme");
    private final By inputGroupName = By.id("inputGroupName");
    private final By chooseDateTime = By.id("choose-date-time");
    private final By mentorEmail = By.id("mentorEmail");
    private final By classRegisterButton = By.id("class-register-btn");
    private final By cancelButton = By.className("btn btn-secondary btn-lg");

    public AddLessonPage fillLessonTheme(String str){
        driver.findElement(inputLessonTheme).sendKeys(str);
        return this;
    }

    public void clickClassRegisterButton(){
        driver.findElement(classRegisterButton).click();
    }

    public Lessons clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new Lessons(driver);
    }
}
