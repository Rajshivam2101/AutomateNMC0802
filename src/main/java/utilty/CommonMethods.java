package utilty;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class CommonMethods {
    static WebDriver driver;

    CommonMethods(WebDriver driver) {
        Waits.driver = driver;
    }

    public static void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Waits.implicitWait(driver, 15);
        js.executeScript("arguments[0].click;", element);

    }

    //==========================================Action Class Common Methods===================================
    public static void clickByAction(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .build()
                .perform();
    }

    public static void click(WebDriver driver, WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .click()
                .build()
                .perform();
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        new Actions(driver)
                .doubleClick(element)
                .build()
                .perform();
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        new Actions(driver)
                .contextClick(element)
                .build()
                .perform();
    }

    // ---------------- DRAG & DROP ----------------

    public static void dragAndDrop(
            WebDriver driver,
            WebElement source,
            WebElement target) {

        new Actions(driver)
                .dragAndDrop(source, target)
                .build()
                .perform();
    }

    // ---------------- KEYBOARD ACTIONS ----------------

    public static void sendKeys(
            WebDriver driver,
            WebElement element,
            String text) {

        new Actions(driver)
                .click(element)
                .sendKeys(text)
                .build()
                .perform();
    }

    public static void keyDown(
            WebDriver driver,
            Keys key) {

        new Actions(driver)
                .keyDown(key)
                .build()
                .perform();
    }

    public static void keyUp(
            WebDriver driver,
            Keys key) {

        new Actions(driver)
                .keyUp(key)
                .build()
                .perform();
    }

    public static void pressEnter(WebDriver driver) {
        new Actions(driver)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    // ---------------- SCROLL ACTIONS ----------------

    public static void scrollToElement(
            WebDriver driver,
            WebElement element) {

        new Actions(driver)
                .scrollToElement(element)
                .build()
                .perform();
    }

    public static void scrollByOffset(
            WebDriver driver,
            int x,
            int y) {

        new Actions(driver)
                .scrollByAmount(x, y)
                .build()
                .perform();
    }

    //==========================================Select Class Common Methods===================================
    public static void selectRandomOption(WebElement dropdown) {

        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();

        if (options.size() <= 1) {
            throw new RuntimeException("Dropdown has no selectable options");
        }

        Random random = new Random();

        // Skip first option if it's like "Select"
        int randomIndex = random.nextInt(options.size() - 1) + 1;

        select.selectByIndex(randomIndex);

        System.out.println(options.get(randomIndex).getText());
    }


    // ---------------- DROPDOWN SELECT ----------------

    public static void selectByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // ---------------- CUSTOM LIST SELECT ----------------
    public static void selectFromList(
            List<WebElement> elements,
            String expectedText) {

        for (WebElement element : elements) {
            if (element.getText().trim().equalsIgnoreCase(expectedText)) {
                element.click();
                return;
            }
        }
        throw new RuntimeException(
                "Value '" + expectedText + "' not found in list");
    }

    //==================================AutoSelect==========================================
    public static void selectFromAutoSuggest(
            WebDriver driver,
            WebElement inputField,
            List<WebElement> suggestionList,
            String valueToSelect) {

        inputField.clear();
        inputField.sendKeys(valueToSelect);

        Waits.waitForVisibility(driver, suggestionList.get(0), 10);

        for (WebElement option : suggestionList) {
            String text = option.getText().trim();
            if (text.equalsIgnoreCase(valueToSelect)) {
                option.click();
                return;
            }
        }
        throw new RuntimeException(
                "Auto-suggest value not found: " + valueToSelect
        );
    }
}


