package com.epam.poc.wearecommunity.core.hook;

import com.epam.poc.wearecommunity.configs.drivers.DriverConfig;
import com.epam.poc.wearecommunity.core.GlobalConstants;
import com.epam.poc.wearecommunity.utilities.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Hook {

    public static WebDriver driver = null;
    protected Logger logger;

    public Hook() {
        logger = LogManager.getLogger(getClass());
    }

    @Before
    public void setUp() {
        String pageUrl = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY).getValue(GlobalConstants.PAGE_URL);
        String browserName = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY).getValue(GlobalConstants.BROWSER_NAME).toUpperCase();

        logger.info("Page Url: " + pageUrl + "with browser name: " + browserName);
        driver = DriverConfig.getDriver(browserName);
        driver.get(pageUrl);
    }

    @After
    public void tearDown() {
        DriverConfig.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
