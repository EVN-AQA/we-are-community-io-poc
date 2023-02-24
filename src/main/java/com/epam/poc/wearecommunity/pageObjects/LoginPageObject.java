package com.epam.poc.wearecommunity.pageObjects;

import com.epam.poc.wearecommunity.core.BasePage;
import com.epam.poc.wearecommunity.pageUIs.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends BasePage {

    private final WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginOption(String option) {
        return getElement(driver, By.xpath(String.format(LoginPageUI.OPTION_XPATH, option)));
    }

    public WebElement getLabelOption(String option) {
        return getElement(driver, By.xpath(String.format(LoginPageUI.LABEL_XPATH, option)));
    }

    public void waitUntilSocialNameVisible(String name) {
        waitForElementUntilVisible(driver, By.xpath(String.format(LoginPageUI.SOCIAL_NAME_XPATH, name)));
    }
}
