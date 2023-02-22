package com.epam.poc.wearecommunity.pageObjects;

import com.epam.poc.wearecommunity.core.BasePage;
import com.epam.poc.wearecommunity.core.GlobalConstants;
import com.epam.poc.wearecommunity.pageUIs.BasePageUI;
import com.epam.poc.wearecommunity.pageUIs.HeaderPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

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

    public String getElementPositionCssValue(String linkName) {
        waitForElementUntilVisible(driver, By.xpath(String.format(HeaderPageUI.HEADER_BY_NAVIGATION_NAME_XPATH, linkName)), GlobalConstants.SHORT_TIMEOUT_KEY);
        return getElementCssValue(driver, By.xpath(String.format(HeaderPageUI.HEADER_BY_NAVIGATION_NAME_XPATH, linkName)), "position");
    }

    public boolean isMainNavigationVisibleWhileScrolling() {
        boolean isVisible = true;
        if (isElementDisplayed(driver, HeaderPageUI.MAIN_NAVIGATION_BY)) {
            scrollToMiddle(driver);
            if (!isElementDisplayed(driver, HeaderPageUI.MAIN_NAVIGATION_BY)) {
                isVisible = false;
            }
            scrollToBottom(driver);
            if (!isElementDisplayed(driver, HeaderPageUI.MAIN_NAVIGATION_BY)) {
                isVisible = false;
            }
        } else {
            isVisible = false;
        }
        return isVisible;
    }

    public String getElementColor(String linkName, String colorAttribute) {
        return Color.fromString(getElementCssValue(driver, By.xpath(String.format(BasePageUI.LINK_XPATH, linkName)), colorAttribute)).asHex();
    }
}
