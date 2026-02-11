package stepDefinition;

import hooks.Hooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.ValidateTillNavigationToRegistrationPage;

public class ValidateTillNavigationToRegistrationSteps {

    WebDriver driver;
    ValidateTillNavigationToRegistrationPage validateTillNavigationToRegistrationPage;

    public ValidateTillNavigationToRegistrationSteps() {
        this.driver = Hooks.getDriver();
        this.validateTillNavigationToRegistrationPage = new ValidateTillNavigationToRegistrationPage(driver);
    }


    @And("user Click In OP Registration Option")
    public void userClickInOPRegistrationOption() {
        validateTillNavigationToRegistrationPage.setClickRegistration();
    }

    @And("user Navigate To OP Registration Screen")
    public void userNavigateToOPRegistrationScreen() {
        validateTillNavigationToRegistrationPage.setOpenRegistrationScreen();

    }


}
