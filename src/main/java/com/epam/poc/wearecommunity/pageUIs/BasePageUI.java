package com.epam.poc.wearecommunity.pageUIs;

import org.openqa.selenium.By;

public class BasePageUI {
    public static final By EVENT_GLOBAL_LOADER = By.cssSelector(".evnt-global-loader");

    public static final String LINK_XPATH = "//a[text()='%s']";
    public static final String BTN_XPATH = "//button[text()='%s']";

}
