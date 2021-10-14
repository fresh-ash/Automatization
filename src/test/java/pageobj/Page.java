package pageobj;

import org.openqa.selenium.WebDriver;

public class Page extends BasePage{

    SideBar sideBar;

    public Page(WebDriver driver) {
        super(driver);
        sideBar = new SideBar(driver);
    }
}
