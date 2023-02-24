package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.Driver;
import utilities.Waiter;

import java.util.List;

public class CarvanaSearchCarsPage extends CarvanaHomePage{

    public CarvanaSearchCarsPage(){
        super();
    }


    @FindBy(css = "div[data-test='FilterDrawer']")
    public List<WebElement> filterOptions;

    @FindBy(css = "input[data-test='SearchBarInput']")
    public WebElement searchCarsSearchBox;

    @FindBy(css = "div[data-test='ResultTile']")
    public List<WebElement> resultTiles;

    @FindBy(css = "div[class='result-tile'] img")
    public List<WebElement> imagesResultTile;

    @FindBy(css = "div[class='result-tile'] svg")
    public List<WebElement> addFavouriteButtonResultTile;

    @FindBy(css = "div[class='tk-frame middle-frame']")
    public List<WebElement> tileBody;

    @FindBy(css = "carvana-certified")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[class='make-model']")
    public List<WebElement> yearModelInfo;

    @FindBy(css = "div[class='trim-mileage']")
    public List<WebElement> trimAndMileage;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> priceOfTiles;

    @FindBy(css = "div[data-qa='base-terms']")
    public List<WebElement> monthlyDownPayments;

    @FindBy(css = "div[data-qa='shipping-cost']")
    public List<WebElement> deliveryChip;


    public void goCarvanaSearchCarsPage(){
        searchCars.click();
        Waiter.pause(3);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.carvana.com/cars");
    }

}
