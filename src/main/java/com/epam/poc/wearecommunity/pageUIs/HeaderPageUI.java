package com.epam.poc.wearecommunity.pageUIs;

import org.openqa.selenium.By;

public class HeaderPageUI {
    public static final By HOME_BUTTON_BY = By.cssSelector("a.evnt-brand-logo");
    public static final String HEADER_BY_NAVIGATION_NAME_XPATH = "//a[text()='%s']/ancestor::header";
    public static final By MAIN_NAVIGATION_BY = By.cssSelector(".evnt-navigation");
    public static final By LANGUAGE_DROPDOWN_LINK_BY = By.id("languageDropdown");
    public static final By LANGUAGE_DROPDOWN_VALUE_BY = By.cssSelector(".language .dropdown-item");
    public static final By LANGUAGE_DROPDOWN_SELECTED_BY = By.cssSelector("#languageDropdown span");
    public static final String LINK_MAIN_NAVIGATION_BY_HREF_XPATH = "//a[@href='%s' and contains(@class, 'nav-link')]";
}
