package pageObjects.businessObjects;

import driver.DriverFactory;
import org.apache.log4j.Logger;
import resources.ConfProperties;

public class MainBO {
    private static final Logger LOG = Logger.getLogger(MainBO.class);

    public MainBO openPage(){
        DriverFactory.getDriver().get(ConfProperties.getProperty("BASE_URL"));
        LOG.info(String.format("Page '%s' is opened!", ConfProperties.getProperty("BASE_URL")));
        return new MainBO();
    }


}
