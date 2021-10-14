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


    String LESSON_THEME_ERROR_CLASS = "add-lesson__error___2dTXe";
    String GROUP_NAME_ERROR_ID = "group-error";
    String MENTOR_MAIL_ERROR_ID = "mentor-error";


    String EDIT_LESSON_THEME_ERROR_CLASS = "edit-lesson__error___3MZKw";


    String MENTOR_NAME_LINK_XPATH = "//a[@class='text-decoration-none text-white' and contains(@href, 'mentors')]";
    String GROUP_NAME_LINK_XPATH = "//a[@class='text-decoration-none text-white' and contains(@href, 'groups')]";
    String LIST_OF_STUDENTS_CLASS = "lesson-details__link___1nOLw";


    public List<WebElement> getSideBar(){
        return driver.findElements(sideBar);
    }

}
