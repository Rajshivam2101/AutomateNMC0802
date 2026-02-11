package utilty;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    static WebDriver driver;


    Waits(WebDriver driver) {
        Waits.driver = driver;

    }


    // ---------------- IMPLICIT WAIT ----------------
    public static void implicitWait(WebDriver driver, int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }


    // ---------------- EXPLICIT WAIT ----------------
    public static WebElement waitForVisibility(
            WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(
            WebDriver driver,
            WebElement element,
            int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPresence(
            WebDriver driver,
            By locator,
            int seconds) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


}
