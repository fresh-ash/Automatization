package pageobj;

import interfaces.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static interfaces.Constants.BASE_URL;

public class AuthPage {

    private final WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    private final By inputEmail = By.id("email");
    private final By inputPass = By.id("password");
    private final By signIn = By.xpath("//button[@type='submit']");

    private AuthPage enterEmail(String str){
        driver.findElement(inputEmail).sendKeys(str);
        return this;
    }

    private AuthPage enterPass(String str){
        driver.findElement(inputPass).sendKeys(str);
        return this;
    }

    public String logIn(String mail, String pass){
        enterEmail(mail);
        enterPass(pass);
        driver.findElement(signIn).click();
        return driver.getCurrentUrl();
    }

    public LessonsPage logInAsMentor(){
        logIn(Constants.MENTOR_MAIL, Constants.MENTOR_PASS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(x -> driver.getCurrentUrl().equals(BASE_URL+"/lessons"));
        System.out.println(driver.getCurrentUrl());
        return new LessonsPage(driver);
    }

    public StudentsPage logInAsAdmin(){
        logIn(Constants.ADMIN_MAIL, Constants.ADMIN_PASS);
        System.out.println(driver.getCurrentUrl());
        return new StudentsPage();
    }

}
