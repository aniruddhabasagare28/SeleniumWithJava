package test;

import factory.ChromeDriverFactory;
import factory.DriverFactoryProvier;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public BaseTest(){
        if(driver.get() == null){
            driver.set(DriverFactoryProvier.getDriverFactory("chrome").createDriver());
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public WebDriver setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
        return driverInstance;
    }

    @BeforeTest
    public void beforeMethod(){
        //driver.set(new ChromeDriverFactory().createDriver());
    }

    @AfterTest
    public void afterMethod() {
        getDriver().quit();
    }
}
