package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.*;

import java.util.List;
import java.util.logging.XMLFormatter;

public class IpRegistrationPage {

    WebDriver driver;

    public IpRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='topmenu']//li//a[text()='Registration']")
    private WebElement openOptions;

    @FindBy(xpath = "//div[@id='grp_registration']//li//a[text()='IP Registration']")
    private WebElement ipRegistration;

    @FindBy(xpath = "//span[@class='pageHeader']")
    private WebElement validateIpRegistration;

    @FindBy(xpath = "//select[@id='dept_name']")
    private WebElement departmentName;

    @FindBy(xpath = "//input[@id='doctor_name']")
    private WebElement docName;

    @FindBy(xpath = "//div[@id='doctor_wrapper']//div//div//div//ul//li")
    private List<WebElement> docNameList;

    @FindBy(xpath = "//select[@id='ward_id']")
    private WebElement wardNamee;

    @FindBy(xpath = "//select[@id='bed_id']")
    private WebElement bedName;

    @FindBy(xpath = "//button[@id='registerBtn']")
    private WebElement clickRegistration;

    @FindBy(xpath = "//td//fieldset[@id='regInfo']//tr")
    private List<WebElement> registrationDetails;


    public void openIpRegistrationPage() {
        Waits.waitForVisibility(this.driver, openOptions, 25);
        CommonMethods.clickByAction(this.driver, openOptions);

        Waits.waitForVisibility(this.driver, ipRegistration, 25);
        CommonMethods.clickByAction(this.driver, ipRegistration);
    }

    public void validateIpRegistrationScreen() {
        Assert.assertTrue(validateIpRegistration.isDisplayed());
        Logger.info(validateIpRegistration.getText());

    }

    public void admissionInformation() {
        String departmentOfPatient = JsonUtils.getValue("userData", "departmentOfPatient");
        Waits.waitForVisibility(driver, departmentName, 15);
        SelectCommonMethods.selectByVisibleText(departmentName, departmentOfPatient);

        Waits.waitForVisibility(driver, docName, 15);
        String doctorName = JsonUtils.getValue("userData", "doctorName");
        SelectCommonMethods.selectFromAutoSuggest(driver, docName, docNameList, doctorName);


        Waits.waitForVisibility(driver, docName, 15);
        String wardName = JsonUtils.getValue("userData", "wardName");
        SelectCommonMethods.selectByVisibleText(wardNamee, wardName);

        Waits.waitForClickable(driver, bedName, 20);
        SelectCommonMethods.selectRandomOption(bedName);

        Waits.waitForClickable(driver, clickRegistration, 15);
        CommonMethods.doubleClick(driver, clickRegistration);

    }

    public void validateRegistrationDetails() {
        Waits.waitForVisibility(driver, validateIpRegistration, 25);
        for (WebElement store : registrationDetails) {

            Waits.waitForVisibility(driver, store, 25);
            Assert.assertTrue(store.isDisplayed());
            String regDetails = store.getText();
            Logger.info(regDetails);

        }

    }

    public void checkForRepo() {
        System.out.println("HI");
    }


}
