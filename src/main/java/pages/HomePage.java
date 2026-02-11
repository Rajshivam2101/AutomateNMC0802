package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.Logger;
import utilty.Waits;


public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//center//div[contains(text(),'Statistics')]")
    private WebElement validation;


    public void validateScreen() {
        Waits.waitForVisibility(driver, validation, 10);
        Assert.assertTrue(validation.isDisplayed());

    }
}
