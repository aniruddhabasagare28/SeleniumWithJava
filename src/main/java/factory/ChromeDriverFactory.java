package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements IWebDriverFactory {
    @Override
    public WebDriver createDriver() {
        return new ChromeDriver();
    }
}
