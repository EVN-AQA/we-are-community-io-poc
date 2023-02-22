package com.epam.poc.wearecommunity.pageObjects;

import com.epam.poc.wearecommunity.core.BasePage;
import com.epam.poc.wearecommunity.core.GlobalConstants;
import com.epam.poc.wearecommunity.pageUIs.BasePageUI;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePageObject extends BasePage {

    private final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForGlobalLoaderInvisible() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        waitForElementUntilInvisible(driver, BasePageUI.EVENT_GLOBAL_LOADER, GlobalConstants.TIMEOUT_IN_3_SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(propertyReader.getValue(GlobalConstants.SHORT_TIMEOUT_KEY)), TimeUnit.SECONDS);
    }
}
