import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CreatePastePage;
import pageObjects.businessObjects.MainBO;
import resources.ConfProperties;

public class BringItOutTest {

    @BeforeMethod
    private void setup(){
        DriverFactory.initDriver();
        new MainBO().openPage();
    }

    @Test(description = "second test")
    public void secondTest(){
        new CreatePastePage()
                .inputDescription(ConfProperties.getProperty("TEXT_2"))
                .clickHighlightingSelect()
                .selectHighlighting(ConfProperties.getProperty("HIGHLIGHTING"))
                .clickExpirationSelect()
                .selectExpiration(ConfProperties.getProperty("EXPIRATION"))
                .inputName(ConfProperties.getProperty("NAME_2"))
                .clickCreateNewPaste()
                .verifyThatPageHaveCorrectTitle(ConfProperties.getProperty("NAME_2"))
                .verifyThatPageHaveCorrectText(ConfProperties.getProperty("TEXT_2"))
                .verifyThatPageHaveCorrectHighlighted(ConfProperties.getProperty("HIGHLIGHTING"));
    }

    @AfterMethod
    private void close() throws InterruptedException {
        Thread.sleep(5000);
        DriverFactory.quitDriver();
    }
}
