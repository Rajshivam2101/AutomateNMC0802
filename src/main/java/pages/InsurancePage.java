package pages;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import utilty.*;

public class InsurancePage {


    WebDriver driver;

    public InsurancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//select[@name='primary_sponsor']")
    private WebElement primaryInsurance;


    @FindBy(xpath = "//select[@id='primary_insurance_co']")
    private WebElement getInsuranceCompany;

    @FindBy(xpath = "//select[@id='primary_sponsor_id']")
    private WebElement getPrimarySponsor;

    @FindBy(xpath = "//select[@id='primary_plan_type']")
    private WebElement getPrimaryPlanType;

    @FindBy(xpath = "//select[@id='primary_plan_id']")
    private WebElement primary_plan_id;


    @FindBy(xpath = "//input[@id='primary_member_id']")
    private WebElement primaryMemberId;

    @FindBy(xpath = "//input[@id='primary_policy_validity_start']")  // //11-02-2026
    private WebElement validityStartDate;

    @FindBy(xpath = "//input[@id='primary_policy_validity_end']")
    private WebElement validityEndDate;

    @FindBy(xpath = "//input[@id='primary_insurance_approval']")
    private WebElement approvalAmount;


    //Sponsor Information
    public void setPrimaryInsurance() {

        Waits.waitForVisibility(driver, primaryInsurance, 10);
        SelectCommonMethods.selectByVisibleText(primaryInsurance, "Insurance");


        String insuranceCompany = JsonUtils.getValue("userData", "insuranceCompany");
        Waits.waitForVisibility(driver, getInsuranceCompany, 10);
        SelectCommonMethods.selectByVisibleText(getInsuranceCompany, insuranceCompany);

        String tpa = JsonUtils.getValue("userData", "tpa");
        Waits.waitForVisibility(driver, getPrimarySponsor, 10);
        SelectCommonMethods.selectByVisibleText(getPrimarySponsor, tpa);

        String networkPlanType = JsonUtils.getValue("userData", "networkPlanType");
        Waits.waitForVisibility(driver, getPrimaryPlanType, 10);
        SelectCommonMethods.selectByVisibleText(getPrimaryPlanType, networkPlanType);

        String planName = JsonUtils.getValue("userData", "planName");
        Waits.waitForVisibility(driver, primary_plan_id, 10);
        SelectCommonMethods.selectByVisibleText(primary_plan_id, planName);


        primaryMemberId.sendKeys(RandomUtils.randomNumber(8));


//        validityStartDate.click();
        String startDate = JsonUtils.getValue("userData", "startDate");
        validityStartDate.sendKeys(startDate);
        Logger.info("if start date is null:" + startDate);

//        CommonMethods.jsClick(driver, validityEndDate);
//        validityEndDate.click();
        String endDate = JsonUtils.getValue("userData", "endDate");
        validityEndDate.sendKeys(endDate);
        Logger.info("if end date is null:" + startDate);

        approvalAmount.sendKeys(RandomUtils.randomNumber(4));


    }

}
