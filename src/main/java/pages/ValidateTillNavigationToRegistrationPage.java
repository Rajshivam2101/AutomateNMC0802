package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.CommonMethods;
import utilty.Logger;
import utilty.Waits;

public class ValidateTillNavigationToRegistrationPage {

    WebDriver driver;

    public ValidateTillNavigationToRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='topmenu']//li//a[text()='Registration']")
    private WebElement clickRegistration;

    @FindBy(xpath = "//div[@id='grp_registration']//li//a[text()='OP Registration']")
    private WebElement openRegistrationScreen;


    public void setClickRegistration() {
        Waits.waitForClickable(driver, clickRegistration, 25);
        CommonMethods.clickByAction(driver, clickRegistration);
    }

    public void setOpenRegistrationScreen() {
        Waits.waitForVisibility(driver, openRegistrationScreen, 25);
        CommonMethods.clickByAction(driver, openRegistrationScreen);
    }


}