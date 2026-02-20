package stepDefinition;


import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.NavigateToOpPatientPage;

public class NavigateToOpPatientSteps {


    WebDriver driver;
    NavigateToOpPatientPage navigateToOpPatientPage;

    public NavigateToOpPatientSteps() {
        this.driver = Hooks.getDriver();
        this.navigateToOpPatientPage = new NavigateToOpPatientPage(driver);
    }

    @And("user click on patient option")
    public void userClickOnPatientOption() {
        navigateToOpPatientPage.opPatientList();
    }

    @And("user navigate to OP List")
    public void userNavigateToOPList() {
        navigateToOpPatientPage.opPatientOptions();

    }
}
