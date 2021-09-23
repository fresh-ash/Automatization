package pageobj.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigationBar {

    private WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    private By sideBar = By.className("nav-item nav-link d-flex justify-content-left");


    public List<WebElement> getSideBar(){
        return driver.findElements(sideBar);
    }

}
