import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CreatePastePage;
import pageObjects.businessObjects.MainBO;
import resources.ConfProperties;

public class ICanWinTest {
    @BeforeMethod
    private void setup(){
        DriverFactory.initDriver();
        new MainBO().openPage();
    }

    @Test(description = "first test")
    public void firstTest(){
        new CreatePastePage()
                .inputDescription(ConfProperties.getProperty("TEXT"))
                .clickExpirationSelect()
                .selectExpiration(ConfProperties.getProperty("EXPIRATION"))
                .inputName(ConfProperties.getProperty("NAME"))
                .clickCreateNewPaste();
    }

    @AfterMethod
    private void close() throws InterruptedException {
        Thread.sleep(5000);
        DriverFactory.quitDriver();
    }
}
