package com.epam.poc.wearecommunity.pageUIs;

public class LoginPageUI {
    public static final String OPTION_XPATH = "//a[@title='%s']";
    public static final String SOCIAL_NAME_XPATH = "//span[@class='social-name' and text()='%s']";
    public static final String LABEL_XPATH = "//label[text()='%s']";
    public static final String SHOW_MORE_BUTTON_CSS = "#form-login-social-show-more";
    public static final String LOGIN_OPTIONS_XPATH = "//a[./span[contains(text(),'Continue with')] and not(contains(@class,'hidden'))]";
}
