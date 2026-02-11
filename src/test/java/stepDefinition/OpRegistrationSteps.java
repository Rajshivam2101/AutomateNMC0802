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

    @And("User enters Visit Information")
    public void userEntersVisitInformation() {
        opRegistrationPage.VisitInfo();
    }

    @And("User OP Registration Successful")
    public void userOPRegistrationSuccessful() {
        opRegistrationPage.registrationDone();
    }

    @And("User enters all the Additional Patient Information and city name as {string}")
    public void userEntersAllTheAdditionalPatientInformationAndCityNameAs(String str) {
        opRegistrationPage.AdditionalPatientInformation();
        opRegistrationPage.additionalVisitInformation();
        opRegistrationPage.selectCityName(str);
    }
}

//    @Then("user validates through Name for Salutations")
//    public void userValidatesThroughNameForSalutations(DataTable dataTable) {
//        List<String> expected = dataTable.asList();
//        List<WebElement> actual = doOpRegistrationPage.salutationList;
//        for (String expectedValue : expected) {
//            for (WebElement element : actual) {
//                String actualValue = element.getText();
//                Assert.assertEquals(expectedValue, actualValue);
//            }
//        }
//    }

//    @Then("user validates through Name for Salutation List")
//    public void userValidatesThroughNameForSalutationList(DataTable dataTable) {

//        List<String> expected = dataTable.asList();
//        List<WebElement> actual = doOpRegistrationPage.salutationList;
//
//
//        for (int i = 0; i < expected.size(); i++) {
//            String actualValue = actual.get(i).getText().trim();
//            Assert.assertEquals(actualValue, expected.get(i), "Mismatch at index " + i
//            );
//        }


