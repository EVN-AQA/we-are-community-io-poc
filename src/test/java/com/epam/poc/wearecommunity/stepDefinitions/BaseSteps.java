package com.epam.poc.wearecommunity.stepDefinitions;

import com.epam.poc.wearecommunity.core.hook.Hook;
import com.epam.poc.wearecommunity.pageObjects.BasePageObject;
import com.epam.poc.wearecommunity.pageUIs.BasePageUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    private final WebDriver driver;
    private final BasePageObject basePageObject;
    protected Logger logger;

    public BaseSteps() {
        logger = LogManager.getLogger(getClass());
        driver = Hook.driver;
        basePageObject = new BasePageObject(driver);
    }

    @Given("I open the home page of wearecommunity website")
    public void iOpenTheHomePageOfWearecommunityWebsite() {
    }

    @When("I click on {string} link")
    public void iClickToLink(String linkName) {
        basePageObject.clickToElement(driver, By.xpath(BasePageUI.linkXpath(linkName)));
    }
}
