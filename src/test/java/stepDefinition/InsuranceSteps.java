package stepDefinition;

import hooks.Hooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import pages.InsurancePage;

public class InsuranceSteps {

    WebDriver driver;
    InsurancePage insurancePage;

    public InsuranceSteps() {
        this.driver = Hooks.getDriver();
        this.insurancePage = new InsurancePage(driver);
    }

    @And("user enters insurance details")
    public void userEntersInsuranceDetails() {
        insurancePage.setPrimaryInsurance();


    }

}