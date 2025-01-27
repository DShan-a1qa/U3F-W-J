package tests;

import aquality.selenium.browser.AqualityServices;
import utils.EnvDataReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;


public abstract class BaseTest {

    @BeforeMethod
    public void setup() {

        String browserName = System.getProperty("browser");
        if (browserName != null) {
            System.out.println("Browser name is set to " + System.getProperty("browserName"));
            System.setProperty("browserName", browserName);
            System.out.println("Browser name is set to " + System.getProperty("browserName"));
        }
        getBrowser().maximize();
        getBrowser().goTo(EnvDataReader.getEnvData().getHost());
    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}
