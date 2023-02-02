package com.epam.poc.wearecommunity.pageObjects;

import com.epam.poc.wearecommunity.core.BasePage;
import org.openqa.selenium.WebDriver;

public class CommunityDetailPageObject extends BasePage {

    private final WebDriver driver;

    public CommunityDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpenSuccessfully(String titleName, String urlName) {
        return titleName.equalsIgnoreCase(getPageTitle(driver)) && urlName.equalsIgnoreCase(getCurrentUrl(driver));
    }
}
