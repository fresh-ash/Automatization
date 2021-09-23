package driver;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public abstract class DriverManager {

    static {
        System.setProperty("webdriver.chrome.driver", "/home/fresh-ash/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/fresh-ash/geckodriver");
        PropertyConfigurator.configure("/home/fresh-ash/IdeaProjects/Automatization/src/main/resources/log4j.properties");
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
