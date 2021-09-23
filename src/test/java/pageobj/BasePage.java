package pageobj;

import org.openqa.selenium.WebDriver;
import pageobj.elements.NavigationBar;

public abstract class BasePage {

    private WebDriver driver;
    private NavigationBar sideBar;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.sideBar = new NavigationBar(driver);

    }

}
