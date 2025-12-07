package test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    private final By searchBoxLocator = By.name("q");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement findSearchBoxWithRetry() {
        int attempts = 0;
        int maxAttempts = 3;
        long pauseMs = 300;
        while (attempts < maxAttempts) {
            try {
                return wait.until(ExpectedConditions.elementToBeClickable(searchBoxLocator));
            } catch (StaleElementReferenceException | TimeoutException | NoSuchElementException e) {
                attempts++;
                try {
                    Thread.sleep(pauseMs);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        return driver.findElement(searchBoxLocator);
    }

    public HomePage open() {
        driver.get("https://www.google.com");
        return this;
    }

    public HomePage search(String query) {
        WebElement box = findSearchBoxWithRetry();
        box.clear();
        box.sendKeys(query);
        box.submit();
        return this;
    }

    public HomePage waitForTitleContains(String text) {
        wait.until(ExpectedConditions.titleContains(text));
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
