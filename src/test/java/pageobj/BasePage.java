package pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void fillField(WebElement field, String text){
        field.click();
        field.clear();
        field.sendKeys(text);
    }

    protected WebElement getItemFromMenu(List<WebElement> webElementList, String name){
        return webElementList.stream()
                .filter(element -> name.equals(element.getText()))
                .findAny()
                .orElse(null);
    }

    protected void clickItem(WebElement element){
        element.click();
    }
}
