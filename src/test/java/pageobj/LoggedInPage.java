package pageobj;

import org.openqa.selenium.WebDriver;

class LoggedInPage extends BasePage{

    protected SideBar sideBar;

    public LoggedInPage(WebDriver driver) {
        super(driver);
        sideBar = new SideBar(driver);
    }

    public SideBar getSideBar() {
        return sideBar;
    }
}
