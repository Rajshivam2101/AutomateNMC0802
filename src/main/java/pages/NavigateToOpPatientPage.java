package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.CommonMethods;
import utilty.Waits;

public class NavigateToOpPatientPage {


    WebDriver driver;

    public NavigateToOpPatientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='topmenu']//li//a[text()='Patient']")
    private WebElement opPatientList;


    @FindBy(xpath = "//div[@id='topmenu']//li//a[text()='Out Patient List']")
    private WebElement opPatientOption;


    public void opPatientList() {
        Waits.waitForClickable(driver, opPatientList, 15);
        CommonMethods.jsClick(driver, opPatientList);
    }

    public void opPatientOptions() {
        Waits.waitForClickable(driver, opPatientOption, 15);
        CommonMethods.jsClick(driver, opPatientOption);
    }


}
