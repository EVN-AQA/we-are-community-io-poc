package com.epam.poc.wearecommunity.pageObjects;

import com.epam.poc.wearecommunity.core.BasePage;
import com.epam.poc.wearecommunity.pageUIs.HeaderPageUI;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class HeaderPageObject extends BasePage {
    private final WebDriver driver;

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomeButton() {
        clickToElement(driver, HeaderPageUI.HOME_BUTTON_BY);
    }

    public boolean isHomeButtonDisplayed() {
        return isElementDisplayed(driver, HeaderPageUI.HOME_BUTTON_BY);
    }
}
