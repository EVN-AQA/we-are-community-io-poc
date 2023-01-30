package com.epam.poc.wearecommunity.utilities;

import com.epam.poc.wearecommunity.configs.drivers.DriverConfig;
import com.epam.poc.wearecommunity.core.GlobalConstants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Hook {

    protected static WebDriver driver = null;
    protected Logger logger;

    public Hook(){
        logger = LogManager.getLogger(getClass());
    }

    @Before
    public void setUp() {
        String pageUrl = new PropertyReader(GlobalConstants.PAGE_URL).getValue(GlobalConstants.PAGE_URL);
        String browserName = new PropertyReader(GlobalConstants.BROWSER_NAME).getValue(GlobalConstants.BROWSER_NAME).toUpperCase();

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
