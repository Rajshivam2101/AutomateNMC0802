package stepDefinition;

import drivermanager.DriverManager;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LogInPage;

public class LogInSteps {

    WebDriver driver;
    LogInPage logInPage;


    public LogInSteps() {
        this.driver = Hooks.getDriver();
        this.logInPage = new LogInPage(driver);
    }

    @Given("user login into nmc Application")
    public void user_login_into_nmc_Application() {
        DriverManager.applicationOpen();
    }

    @When("user enters the login details")
    public void userEntersTheLoginDetails() {
        logInPage.userEnterUsername();
        logInPage.userEnterPassword();
        logInPage.userClickOnSubmitButton();
    }
}



