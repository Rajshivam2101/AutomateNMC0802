package pages;

import EnumType.ConfigKey;
import config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilty.Logger;
import utilty.Waits;

public class LogInPage {

    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userId")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "button")
    private WebElement button;


    public void userEnterUsername() {
        String user = ConfigLoader.get(ConfigKey.USERNAME);
        login.sendKeys(user);
    }

    public void userEnterPassword() {
        String pass = ConfigLoader.get(ConfigKey.PASSWORD);
        password.sendKeys(pass);

    }

    public void userClickOnSubmitButton() {
        Waits.waitForClickable(driver, button, 5);
        button.click();;
    }


//    public void logInn() {
//
//        try {
//
//            Waits.implicitWait(5);
//            login.click();
//        } catch (Exception e) {
//            System.out.println("Wait time is not enough");
//        }
//    }
}
