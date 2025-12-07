package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    WebDriver driver;

    public LoginTests() {
        super();
    }

    @BeforeTest
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void openGoogle() {
        HomePage home = new HomePage(driver).open();
        Assert.assertTrue(home.getTitle().toLowerCase().contains("google"));
    }

    @Test
    public void searchOnGoogle() {
        HomePage home = new HomePage(driver)
                .open()
                .search("Selenium WebDriver")
                .waitForTitleContains("Selenium WebDriver");

        Assert.assertTrue(home.getTitle().contains("Selenium WebDriver"));
    }
}
