package drivermanager;

import EnumType.ConfigKey;
import config.ConfigLoader;
import io.cucumber.java.it.Ed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilty.Logger;

public class DriverManager {


    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initDriver() {
        String brows = ConfigLoader.get(ConfigKey.BROWSER);
        openBrowser(brows);

    }

    public static void openBrowser(String BrowserName) {

        switch (BrowserName) {

            case "chrome":
                ChromeOptions chromeOptions = getChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = getEdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;


            case "firefox":
                FirefoxOptions firefoxOptions = getFirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;


            default:
                driver = new ChromeDriver(getChromeOptions());

        }
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
        return chromeOptions;

    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        return edgeOptions;

    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--start-maximized");
        return firefoxOptions;

    }

    public static void applicationOpen() {
        Logger.info("Application Started");
        String url = ConfigLoader.get(ConfigKey.URL);
        driver.get(url);
    }

    public static void close() {

        if (driver != null) {
            Logger.info("Browser Closing");
            driver.quit();


        }
    }

}

