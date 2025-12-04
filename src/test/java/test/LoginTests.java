package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("google"));
    }

    @Test
    public void searchOnGoogle() {
        driver.get("https://www.google.com");
        WebElement searchBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleContains("Selenium WebDriver"));
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"));
    }
}
