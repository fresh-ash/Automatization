package goodtests.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Auth {

    Map<String, Class<?>> classMap;

    WebDriver driver;
    private static final Logger log = LogManager.getLogger(Auth.class);

    public Auth(WebDriver driver) {
        this.driver = driver;
        classMap.put("a", String.class);
        classMap.put("b", LogInPage.class);
    }

    private final By mailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By submit = By.xpath("//button[@type='submit']");
    private final By span = By.xpath("/html/body/div/nav/div/*/span");
    private final By logOutHref = By.xpath("/html/body/div/nav/div/div[2]/ul/li[3]/a");

    public <T> T logIn(){

        return (T) new DefaulPage();
    }


    public void logOut(){
        Auth auth = new Auth(driver);
        auth.<AsAdmin>logIn().getPage().goToStartPage().goToLessons().addLesson().goToStartPage();
        PageStore store = new PageStore(new LogInPage());
        driver.findElement(span).click();
        driver.findElement(logOutHref).click();
    }
}
