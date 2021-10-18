package pageObjects;

import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.businessObjects.PasteBO;

import java.util.List;

public class CreatePastePage {
    private final static Logger LOG = Logger.getLogger(CreatePastePage.class);
    private final BasePage basePage = new BasePage();

    @FindBy(xpath = "//textarea[@id = 'postform-text']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//span[@id = 'select2-postform-format-container']")
    private WebElement highlightingSelect;

    @FindBy(xpath = "//input[@class = 'select2-search__field']")
    private WebElement highlightingSearch;

    @FindBy(xpath = "//li[@class = 'select2-results__option' and @role = 'option']")
    private List<WebElement> listOfHighlighting;

    @FindBy(xpath = "//span[@id = 'select2-postform-expiration-container']")
    private WebElement expirationSelect;

    @FindBy(xpath = "//ul[@id = 'select2-postform-expiration-results']//li")
    private List<WebElement> expirationValues;

    @FindBy(xpath = "//input[@id = 'postform-name']")
    private WebElement nameInput;

    @FindBy(xpath = "//button[@type ='submit']")
    private WebElement btnCreateNewPaste;

    public CreatePastePage() {
        WebDriver driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public CreatePastePage inputDescription(String text){
        basePage.waitToVisibilityOf(5000, descriptionInput);
        descriptionInput.clear();
        descriptionInput.sendKeys(text);
        LOG.info(String.format("Input '%s' to description input", text));
        return new CreatePastePage();
    }

    public CreatePastePage clickExpirationSelect(){
        basePage.waitToVisibilityOf(5000, expirationSelect);
        expirationSelect.click();
        LOG.info("Click on expiration select");
        return new CreatePastePage();
    }

    public CreatePastePage selectExpiration(String expiration){
        for (WebElement element: expirationValues) {
            if(element.getText().trim().equals(expiration)){
                element.click();
                LOG.info(expiration + " selected!");
                break;
            }
        }
        return new CreatePastePage();
    }

    public CreatePastePage clickHighlightingSelect(){
        basePage.waitToVisibilityOf(5000, highlightingSelect);
        highlightingSelect.click();
        LOG.info("Click on highlighting select");
        return new CreatePastePage();
    }

    public CreatePastePage inputHighlightingInSearch(String highlighting){
        highlightingSelect.clear();
        highlightingSelect.sendKeys(highlighting);
        return new CreatePastePage();
    }

    public CreatePastePage selectHighlighting(String highlighting){
        basePage.waitToVisibilityOf(5000, listOfHighlighting.get(0));
        for (WebElement element: listOfHighlighting) {
            if(element.getText().trim().equals(highlighting)){
                element.click();
                LOG.info(highlighting + " selected!");
                break;
            }
        }
        return new CreatePastePage();
    }

    public CreatePastePage inputName(String name){
        basePage.waitToVisibilityOf(5000, nameInput);
        nameInput.clear();
        nameInput.sendKeys(name);
        return new CreatePastePage();
    }

    public PasteBO clickCreateNewPaste(){
        basePage.waitToBeClickable(5000, btnCreateNewPaste);
        btnCreateNewPaste.click();
        return new PasteBO();
    }


}
