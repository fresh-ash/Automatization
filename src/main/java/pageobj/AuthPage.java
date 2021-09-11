package pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {

    private final WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By inputEmail = By.id("email");
    private final By inputPass = By.id("password");
    private final By signIn = By.xpath("//button[@type='submit']");

    public AuthPage enterEmail(String str){
        driver.findElement(inputEmail).sendKeys(str);
        return this;
    }

    public AuthPage enterPass(String str){
        driver.findElement(inputPass).sendKeys(str);
        return this;
    }
    public Lessons clickSignInButton(){
        driver.findElement(signIn).click();
        return new Lessons(driver);
    }

}
