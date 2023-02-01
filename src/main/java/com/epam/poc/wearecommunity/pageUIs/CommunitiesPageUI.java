package com.epam.poc.wearecommunity.pageUIs;

import org.openqa.selenium.By;

public class CommunitiesPageUI {
    public static final By SEARCH_BY = By.cssSelector(".evnt-search-filter input");
    public static final By SEARCH_RESULT_BY = By.cssSelector(".evnt-communities-row .evnt-communities-column");
    public static final By TEXT_SEARCH_RESULT_BY = By.cssSelector(".evnt-name-wrapper span");
    public static final By EVENT_GLOBAL_LOADER = By.cssSelector(".evnt-global-loader");
}
