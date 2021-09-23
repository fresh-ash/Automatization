package pageobj;

import interfaces.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

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

    private String logIn(String mail, String pass){
        enterEmail(mail);
        enterPass(pass);
        driver.findElement(signIn).click();
        return driver.getCurrentUrl();
    }

    public Lessons logInAsMentor(){
        logIn(Constants.MENTOR_MAIL, Constants.MENTOR_PASS);
        System.out.println(driver.getCurrentUrl());
        return new Lessons(driver);
    }

}
