package com.epam.poc.wearecommunity.pageObjects;

import com.epam.poc.wearecommunity.core.BasePage;
import org.openqa.selenium.WebDriver;

public class BasePageObject extends BasePage {

    private WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
