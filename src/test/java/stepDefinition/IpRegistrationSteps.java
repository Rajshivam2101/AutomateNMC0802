package stepDefinition;

import hooks.Hooks;
import pages.InsurancePage;
import utilty.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.IpRegistrationPage;

public class IpRegistrationSteps {
    WebDriver driver;
    IpRegistrationPage ipRegistrationPage;

    public IpRegistrationSteps() {
        this.driver = Hooks.getDriver();
        this.ipRegistrationPage = new IpRegistrationPage(driver);
    }


    @When("user clicks on the ip registration link.")
    public void userClicksOnTheIpRegistrationLink() {
        ipRegistrationPage.openIpRegistrationPage();
    }

    @Then("user is in ip registration screen.")
    public void userIsInIpRegistrationScreen() {
        ipRegistrationPage.validateIpRegistrationScreen();

    }
}
