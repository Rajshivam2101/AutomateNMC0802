package stepDefinition;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.OpRegistrationPage;

public class OpRegistrationSteps {

    WebDriver driver;
    OpRegistrationPage opRegistrationPage;


    public OpRegistrationSteps() {
        this.driver = Hooks.getDriver();

        this.opRegistrationPage = new OpRegistrationPage(driver);
    }


    @Then("user open the OP registration screen and validates OP Registration header")
    public void userOpenTheOPRegistrationScreenAndValidatesOPRegistrationHeader() {
        opRegistrationPage.ValidateOpRegistrationHeader();
    }

    @Then("user validates all salutations from Op Registration")
    public void userValidatesAllSalutationsFromOpRegistration() {
        opRegistrationPage.validateAllSalutationList();
    }

    @And("user enters all the Basic Information details")
    public void userEntersAllTheBasicInformationDetails() {
        opRegistrationPage.basicInformation();

    }
    @And("User enters all the Additional Patient Information")
    public void userEntersAllTheAdditionalPatientInformation() {

        opRegistrationPage.AdditionalPatientInformation();
        opRegistrationPage.additionalVisitInformation();
        opRegistrationPage.selectCityName();

    }
    @And("User enters all the Additional Patient Information and city name as {string}")
    public void userEntersAllTheAdditionalPatientInformationAndCityNameAs(String str) {
        opRegistrationPage.AdditionalPatientInformation();
        opRegistrationPage.additionalVisitInformation();
        opRegistrationPage.selectCityName(str);
    }

    @And("User enters Visit Information")
    public void userEntersVisitInformation() {
        opRegistrationPage.VisitInfo();
    }

    @And("User OP Registration Successful")
    public void userOPRegistrationSuccessful() {
        opRegistrationPage.registrationDone();
    }

}
//    @And("User enters Visit Information and with multiple teleconsultation {string}")
//    public void userEntersVisitInformationAndWithMultipleTeleconsultation(String str) {
//        opRegistrationPage.VisitInfo(str);
//    }





