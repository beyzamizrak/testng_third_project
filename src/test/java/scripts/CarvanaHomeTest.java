package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarsPage;
import utilities.Waiter;

import java.util.stream.IntStream;

public class CarvanaHomeTest extends CarvanaBase {


    @BeforeMethod
    public void setPage(){
        carvanaHomePage = new CarvanaHomePage();
    }

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateCarvanaHomePageAndUrl(){

        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateTheCarvanaLogo(){
        Assert.assertTrue(carvanaHomePage.logo.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateTheMainNavigationSectionItems(){

        String[] navigationSectionItems = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};

        for (int i = 0; i < navigationSectionItems.length; i++) {
            Assert.assertTrue(carvanaHomePage.navigationSectionItems.get(i).isDisplayed());
            Assert.assertEquals(carvanaHomePage.navigationSectionItems.get(i).getText(), navigationSectionItems[i]);
        }
        /*
        Or I can do with InStream.range() method
        IntStream.range(0, carvanaHomePage.navigationSectionItems.size()).forEach(i->
        Assert.assertTrue(carvanaHomePage.navigationSectionItems.get(i).isDisplayed()));
         */
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateTheSignInErrorMessage(){
        carvanaHomePage.signInButton.click();
        Waiter.pause(5);
        carvanaHomePage.emailInputBox.sendKeys("johndoe@gmail.com");
        Waiter.pause(2);
        carvanaHomePage.continueButton.click();
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        Waiter.pause(2);
        carvanaHomePage.signInSubmit.click();
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect.");
        Waiter.pause(2);
    }





}
