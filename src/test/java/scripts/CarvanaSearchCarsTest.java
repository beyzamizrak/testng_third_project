package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarsPage;
import utilities.Waiter;

import java.util.stream.IntStream;

public class CarvanaSearchCarsTest extends CarvanaBase{

    @BeforeMethod
    public void setPage(){
        carvanaHomePage = new CarvanaHomePage();
        carvanaSearchCarsPage = new CarvanaSearchCarsPage();

    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateTheSearchFilterOptionsAndSearchButton(){
        /*
         since this homework was created the website seems to be changed in this section
         they added more filter options, I will automate it with new filter options
         */
        carvanaSearchCarsPage.goCarvanaSearchCarsPage();
        String[] filterOptions = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE",
            "WAYS TO SAVE", "FUEL", "MPG", "FEATURES", "COLORS", "INTERIOR COLORS", "DRIVETRAINS",
            "TRANSMISSIONS", "CYLINDERS"};

        for (int i = 0; i < filterOptions.length; i++) {
            Assert.assertEquals(carvanaSearchCarsPage.filterOptions.get(i).getText(), filterOptions[i]);
        }

    }

    @Test(priority = 6, description = "Validate the search result tiles")
    public void validateTheSearchResultTiles(){
        carvanaSearchCarsPage.goCarvanaSearchCarsPage();
        Waiter.pause(2);
        carvanaSearchCarsPage.searchCarsSearchBox.sendKeys("mercedes-benz");
        Waiter.pause(2);
        carvanaSearchCarsPage.searchCarsSearchBox.sendKeys(Keys.ENTER);
        Waiter.pause(5);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars/mercedes-benz?email-capture=");

        IntStream.range(0, carvanaSearchCarsPage.resultTiles.size()).forEach(i -> {
            Assert.assertTrue(carvanaSearchCarsPage.resultTiles.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.imagesResultTile.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.addFavouriteButtonResultTile.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.tileBody.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.inventoryType.get(i).getText());
            Assert.assertTrue(carvanaSearchCarsPage.trimAndMileage.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.trimAndMileage.get(i).getText());

            Assert.assertTrue(Integer.parseInt(carvanaSearchCarsPage.priceOfTiles.get(i).getText().replaceAll("[^0-9]", ""))
                    > 0);

            Assert.assertTrue(carvanaSearchCarsPage.monthlyDownPayments.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.monthlyDownPayments.get(i).getText());
            Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.deliveryChip.get(i).getText());
        });
    }

}
