package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarsPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class CarvanaBase {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;

    CarvanaSearchCarsPage carvanaSearchCarsPage;



    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        carvanaHomePage = new CarvanaHomePage();
        carvanaSearchCarsPage = new CarvanaSearchCarsPage();
    }

    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean ups
        Driver.quitDriver();
    }
}
