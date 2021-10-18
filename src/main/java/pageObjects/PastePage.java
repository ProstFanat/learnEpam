package pageObjects;

import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.businessObjects.PasteBO;

import java.util.List;

public class PastePage {
    private static final Logger LOG = Logger.getLogger(PastePage.class);

    @FindBy(xpath = "//h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class = 'highlighted-code']//a")
    private List<WebElement> listOfHighlighting;

    @FindBy(xpath = "//textarea")
    private WebElement textarea;

    public PastePage(){
        WebDriver driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isPageContainsCorrectTitle(String title){
        new BasePage().waitToVisibilityOf(5000, pageTitle);
        boolean result = pageTitle.getText().trim().equals(title);
        LOG.info("Is page contains correct title - " + result);
        return result;
    }

    public boolean isPageContainsCorrectHighlight(String highlighted){
        new BasePage().waitToVisibilityOf(5000, listOfHighlighting.get(0));
        boolean result = false;
        for (WebElement element: listOfHighlighting) {
            if(element.getText().trim().equals(highlighted)){
                result = true;
                LOG.info("Is page contains correct title - " + result);
                break;
            }
        }
        return result;
    }

    public boolean isPageContainsCorrectText(String text){
        new BasePage().waitToVisibilityOf(5000, textarea);
        boolean result = textarea.getText().trim().equals(text);
        LOG.info("Is page contains correct text - " + result);
        return result;
    }
}
