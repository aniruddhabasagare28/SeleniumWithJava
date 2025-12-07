package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements IWebDriverFactory {
    @Override
    public WebDriver createDriver() {
        // Ensure the correct chromedriver binary is downloaded and configured
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
