package hooks;

import drivermanager.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utilty.Logger;

public class Hooks {


    @Before
    public void setUp() {
        DriverManager.initDriver();
    }

//    @After
//    public void tierDown() {
//        Logger.info("Execution Completed");
//
//        DriverManager.close();
//    }

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

}
