package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.*;

import java.time.LocalDate;
import java.util.List;

public class OpRegistrationPage {

    WebDriver driver;

    public OpRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td/h1[text()='OP Registration']")
    private WebElement opRegistrationHeader;

    @FindBy(xpath = "//td/select[@id='salutation']//option")
    public List<WebElement> salutationList;

    @FindBy(id = "salutation")
    private WebElement salutationChang;

    @FindBy(xpath = "//input[@id ='patient_name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id ='middle_name']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@id ='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id ='reg_patient_phone']")
    private WebElement mobileNumber;

    @FindBy(xpath = "//input[@id ='patient_phone2']")
    private WebElement additionalNumber;

    @FindBy(xpath = "//input[@id ='patient_care_oftext']")
    private WebElement contactNumber;

    @FindBy(xpath = "//input[@id='dobDay']")
    private WebElement birthdayDay;

    @FindBy(xpath = "//input[@id='dobMonth']")
    private WebElement birthdayMonth;

    @FindBy(xpath = "//input[@id='dobYear']")
    private WebElement birthdayYear;

    @FindBy(xpath = "//select[@id='patient_gender']")
    private WebElement gender;

    @FindBy(xpath = "//input[@id='relation']")
    private WebElement nextToKinName;

    @FindBy(xpath = "//select[@id='next_of_kin_relation']")
    private WebElement relation;

    @FindBy(xpath = "//input[@id='pat_city_name']")
    public WebElement patientCityFieldName;

    @FindBy(xpath = "//div[@id='city_state_country_dropdown']/div/div/ul/li")
    public List<WebElement> patientCityNameList;

    @FindBy(xpath = "//select[@id='pcp_status']")
    private WebElement patientActiveProblem;

    @FindBy(xpath = "//select[@id='custom_list1_value']")
    private WebElement patientNationality;


    @FindBy(xpath = "//select[@id='custom_list2_value']")
    private WebElement patientUnifiedHealthCare;


    @FindBy(xpath = "//select[@id='custom_list3_value']")
    private WebElement patientCountryOfResidence;

    @FindBy(xpath = "//select[@id='custom_list6_value']")
    private WebElement patientOccupation;

    @FindBy(xpath = "//select[@id='custom_list7_value']")
    private WebElement patientConsentCollected;

    @FindBy(xpath = "//select[@id='custom_list8_value']")
    private WebElement patientReferralSource;

    @FindBy(xpath = "//select[@id='custom_list9_value']")
    private WebElement patientSector;

    @FindBy(xpath = "//input[@name='custom_field2']")
    private WebElement patientPassportNo;

    @FindBy(xpath = "//input[@name='custom_field6']")
    private WebElement patientReferralRemarks;

    @FindBy(xpath = "//select[@id='identifier_id']")
    private WebElement patientIdType;

    @FindBy(xpath = "//input[@name='unified_id']")
    private WebElement patientUnifiedId;

    @FindBy(xpath = "//input[@id='email_id']")
    private WebElement patientEmailId;

    @FindBy(xpath = "//select[@id='visit_custom_list1']")
    private WebElement smsConsent;

    @FindBy(xpath = "//select[@id='visit_custom_list2']")
    private WebElement patientSurveyConsent;


    @FindBy(xpath = "//select[@id='dept_name']")
    private WebElement patientDepartment;


    @FindBy(xpath = "//input[@id='doctor_name']")
    public WebElement consultingDoctor;

    @FindBy(xpath = "//div[@id='doctor_wrapper']//div//div//div//ul//li")
    public List<WebElement> consultingDoctorList;


    @FindBy(xpath = "//select[@id='doctorCharge']")
    private WebElement patientConsultationType;

    @FindBy(xpath = "//button[@id='registerBtn']")
    private WebElement clickRegistration;

    @FindBy(xpath = "//div[@id='content']//h1")
    private WebElement registrationSuccess;


    public void ValidateOpRegistrationHeader() {
        Waits.waitForVisibility(driver, opRegistrationHeader, 10);
        Assert.assertTrue(opRegistrationHeader.isDisplayed());
        Logger.info(opRegistrationHeader.getText());

    }

    public void validateAllSalutationList() {
        for (WebElement element : salutationList) {
            Assert.assertTrue(element.isDisplayed());
            Logger.info(element.getText());
        }

    }

    public void basicInformation() {
        //Select SName

        String salutationList1 = JsonUtils.getValue("userData", "salutationList1");
        Waits.waitForVisibility(driver, opRegistrationHeader, 25);
        SelectCommonMethods.selectByVisibleText(salutationChang, salutationList1);

        //EnterFirstName
        firstName.sendKeys(RandomUtils.randomString(7));

        //EnterFirstName
        middleName.sendKeys(RandomUtils.randomString(5));

        //EnterFirstName
        lastName.sendKeys(RandomUtils.randomString(6));

        //Enter Mobile No.:
        mobileNumber.sendKeys(RandomUtils.randomNumber(10));

        //Enter Additional No.:
        additionalNumber.sendKeys(RandomUtils.randomNumber(10));

        //Enter Contact No.:
        contactNumber.sendKeys(RandomUtils.randomNumber(10));


        //Enter DOB
//        Waits.waitForClickable(driver, birthdayDay, 10);
//        birthdayDay.sendKeys(RandomUtils.randomNumber(1));
//        Waits.waitForClickable(driver, birthdayMonth, 10);
//        birthdayMonth.sendKeys(RandomUtils.randomNumber(1));
//        Waits.waitForClickable(driver, birthdayYear, 10);
//        birthdayYear.sendKeys(RandomUtils.randomNumber(4));

        LocalDate startDate = LocalDate.of(1990, 1, 1);
        LocalDate endDate = LocalDate.of(2005, 12, 31);

        // Step 2: Generate random DOB
        LocalDate dob =
                DateWithInTheRange.randomDobBetween(startDate, endDate);

        // Step 3: Extract day / month / year
        String day = String.format("%02d", dob.getDayOfMonth());
        String month = String.format("%02d", dob.getMonthValue());
        String year = String.valueOf(dob.getYear());

        birthdayDay.clear();
        birthdayDay.sendKeys(day);

        birthdayMonth.clear();
        birthdayMonth.sendKeys(month);

        birthdayYear.clear();
        birthdayYear.sendKeys(year);

        Logger.info("DOB entered: " + day + "-" + month + "-" + year);

        String genderList1 = JsonUtils.getValue("userData", "genderList1");
        Waits.waitForClickable(driver, gender, 10);
        SelectCommonMethods.selectByVisibleText(gender, genderList1);

        nextToKinName.sendKeys(RandomUtils.randomString(8));

        Waits.waitForClickable(driver, relation, 10);
        SelectCommonMethods.selectRandomOption(relation);

    }

    public void selectCityName() {

        SelectCommonMethods.selectFromAutoSuggest(driver, patientCityFieldName, patientCityNameList, "MAMZER - DUBAI - United Arab Emirates");
    }

    public void selectCityName(String str) {

        SelectCommonMethods.selectFromAutoSuggest(driver, patientCityFieldName, patientCityNameList, str);
    }

    public void AdditionalPatientInformation() {

        String patientActiveProblemList = JsonUtils.getValue("userData", "patientActiveList1");
        Waits.waitForClickable(driver, patientActiveProblem, 15);
        SelectCommonMethods.selectByVisibleText(patientActiveProblem, patientActiveProblemList);

        Waits.waitForClickable(driver, patientNationality, 15);
        SelectCommonMethods.selectByVisibleText(patientNationality, "Indian");

        Waits.waitForClickable(driver, patientUnifiedHealthCare, 15);
        SelectCommonMethods.selectByVisibleText(patientUnifiedHealthCare, "VIP Status");

        Waits.waitForClickable(driver, patientCountryOfResidence, 15);
        SelectCommonMethods.selectByVisibleText(patientCountryOfResidence, "India");

        Waits.waitForClickable(driver, patientOccupation, 15);
        SelectCommonMethods.selectByVisibleText(patientOccupation, "SALARIED");

        Waits.waitForClickable(driver, patientConsentCollected, 15);
        SelectCommonMethods.selectByVisibleText(patientConsentCollected, "Yes");

        Waits.waitForClickable(driver, patientReferralSource, 15);
        SelectCommonMethods.selectByVisibleText(patientReferralSource, "ADNOC DISTRIBUTION");

        Waits.waitForClickable(driver, patientSector, 15);
        SelectCommonMethods.selectByVisibleText(patientSector, "Energy");

        Waits.waitForClickable(driver, patientIdType, 15);
        SelectCommonMethods.selectByVisibleText(patientIdType, "Expatriate resident without a card");


        patientPassportNo.sendKeys(RandomUtils.randomNumber(6));

        patientUnifiedId.sendKeys(RandomUtils.randomNumber(8));

        patientReferralRemarks.sendKeys(RandomUtils.randomString(7));

        patientEmailId.sendKeys(RandomUtils.randomString(6) + "@gmail.com");

    }

    //Additional Visit Information Section
    public void additionalVisitInformation() {

        Waits.waitForClickable(driver, smsConsent, 10);
        SelectCommonMethods.selectByVisibleText(smsConsent, "YES");

        Waits.waitForClickable(driver, patientSurveyConsent, 10);
        SelectCommonMethods.selectByVisibleText(patientSurveyConsent, "YES");

    }

    //doctorCharge
    public void VisitInfo() {

        Waits.waitForVisibility(driver, patientDepartment, 15);
        SelectCommonMethods.selectByVisibleText(patientDepartment, "Surgery");

        Waits.waitForVisibility(driver, consultingDoctor, 15);
        SelectCommonMethods.selectFromAutoSuggest(driver, consultingDoctor, consultingDoctorList, "Dr. Aaron Paul Garrison (Surgery)(GD17522)");

        Waits.waitForVisibility(driver, patientConsultationType, 15);
        SelectCommonMethods.selectByVisibleText(patientConsultationType, "01204-EXAM-DIAG OF SPECIFIC SITUATION");

        Waits.waitForClickable(driver, clickRegistration, 15);
        CommonMethods.doubleClick(driver, clickRegistration);
        //driver.switchTo().alert().accept();
    }

    public void registrationDone() {
        Waits.waitForVisibility(driver, registrationSuccess, 50);
        Assert.assertTrue(registrationSuccess.isDisplayed());
    }

}



