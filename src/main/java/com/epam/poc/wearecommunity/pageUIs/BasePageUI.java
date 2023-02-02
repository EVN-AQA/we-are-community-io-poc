package com.epam.poc.wearecommunity.pageUIs;

import org.openqa.selenium.By;

public class BasePageUI {
    public static final By EVENT_GLOBAL_LOADER = By.cssSelector(".evnt-global-loader");

    public static String linkXpath(String linkName) {
        return "//a[text()='" + linkName + "']";
    }

    public static String btnXpath(String btnName) {
        return "//button[text()='" + btnName + "']";
    }
}
