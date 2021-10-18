package pageObjects;

import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGooglePage {

    private static final Logger LOG = Logger.getLogger(CloudGooglePage.class);

    @FindBy(xpath = "//input[@name = 'q']")
    private WebElement searchField;

    public CloudGooglePage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public CloudGooglePage clickBtnSearch(){
        new BasePage().waitToVisibilityOf(5000, searchField);
        searchField.click();
        return this;
    }

    public CloudGooglePage inputTextToSearchFilter(String text){
        searchField.clear();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }
}
