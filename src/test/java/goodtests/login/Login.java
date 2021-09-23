package goodtests.login;

import interfaces.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;
    private static final Logger log = LogManager.getLogger(Login.class);

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    private final By mailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By submit = By.xpath("//button[@type='submit']");

    private final By span = By.xpath("/html/body/div/nav/div/*/span");
    private final By logOutHref = By.xpath("/html/body/div/nav/div/div[2]/ul/li[3]/a");

    public boolean logIn(String mail, String password){
        driver.get(Constants.BASE_URL);
        log.info("URL: " + driver.getCurrentUrl());
        driver.findElement(mailField).sendKeys(mail);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submit).click();
        return true;
    }

    public void logOut(){
        driver.findElement(span).click();
        driver.findElement(logOutHref).click();
    }
}
