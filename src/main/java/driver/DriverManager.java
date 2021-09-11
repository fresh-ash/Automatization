package driver;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public abstract class DriverManager {

    static {
        System.setProperty("webdriver.chrome.driver", "/home/fresh-ash/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/fresh-ash/geckodriver");
    }

    protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if (null != drivers.get()) {
            try {
                drivers.get().quit();
                drivers.remove();
            } catch (Exception e) {
                System.err.println("Unable to gracefully quit WebDriver.");
            }

        }
    }

    public WebDriver getDriver() {
        if (null == drivers.get()) {
            drivers.set(this.createDriver());
        }
        drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        return drivers.get();
    }

}
