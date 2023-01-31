package com.epam.poc.wearecommunity.pageUIs;

public class BasePageUI {
    public static String linkXpath(String linkName) {
        return "//a[text()='" + linkName + "']";
    }

    public static String btnXpath(String btnName) {
        return "//button[text()='" + btnName + "']";
    }
}
