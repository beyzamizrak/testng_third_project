package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaHomePage {

    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class*='14r2405']")
    public WebElement logo;

    @FindBy(css = "div[class*='pqwx2h-0']>div>a")
    public List<WebElement> navigationSectionItems;

    @FindBy(css = "div[class*='k2q06e-2']>a")
    public WebElement signInButton;

    @FindBy(css = "div[class='scope-reset_auth-flows-reset__pxFap']")
    public WebElement signInModal;

    @FindBy(css = "div[class='i1j6fosc']>input")
    public WebElement emailInputBox;

    @FindBy(css = "button[class$='d14aom7e']")
    public WebElement continueButton;

    @FindBy(css = "input[data-qa='sign-in-password']")
    public WebElement passwordInputBox;

    @FindBy(css = "button[data-qa='sign-in-submit']")
    public WebElement signInSubmit;

    @FindBy(css = "div[class$='7-XzW'] p")
    public WebElement errorMessage;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCars;


    //@FindBy(css = "div[data-test='SearchInput']")
    //public WebElement searchInput;







}
