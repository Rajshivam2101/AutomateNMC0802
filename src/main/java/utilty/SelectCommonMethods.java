package utilty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class SelectCommonMethods {

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
