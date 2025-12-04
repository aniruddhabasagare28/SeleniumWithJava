package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverFactory implements IWebDriverFactory {
    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
