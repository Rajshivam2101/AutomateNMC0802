package stepDefinition;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps {

    WebDriver driver;
    HomePage homePage;

    public HomePageSteps() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
    }

    @Then("user validates the homepage")
    public void userValidatesTheHomepage() {
        homePage.validateScreen();
    }



}
