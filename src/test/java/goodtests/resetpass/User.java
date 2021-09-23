package goodtests.resetpass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User {
    WebDriver driver;

    public User(WebDriver driver) {
        this.driver = driver;
    }

    public void resetPassword(){
         WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
         if(!submit.getAttribute("disabled").equals("true")){
             submit.click();
         }
    }

    public void emailIs(String email){
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void newPasswordIs(String newPassword){
        driver.findElement(By.id("newPassword")).sendKeys(newPassword);
    }

    public void confirmPasswordIs(String confirmPassword){
        driver.findElement(By.id("confirmNewPassword")).sendKeys(confirmPassword);
    }
}
