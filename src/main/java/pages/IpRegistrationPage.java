package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.CommonMethods;
import utilty.Logger;
import utilty.Waits;

public class IpRegistrationPage {

    WebDriver driver;
    public IpRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='topmenu']//li//a[text()='Registration']")
    WebElement openOptions;

    @FindBy(xpath = "//div[@id='grp_registration']//li//a[text()='IP Registration']")
    WebElement ipRegistration;


    public void openIpRegistrationPage() {
        Waits.waitForVisibility(this.driver, openOptions, 25);
        CommonMethods.click(this.driver, openOptions);

        Waits.waitForVisibility(this.driver, ipRegistration, 25);
        CommonMethods.jsClick(this.driver, ipRegistration);
    }

    public void validateIpRegistrationScreen() {
        Logger.info("Page logged in Successfully");
    }
}
