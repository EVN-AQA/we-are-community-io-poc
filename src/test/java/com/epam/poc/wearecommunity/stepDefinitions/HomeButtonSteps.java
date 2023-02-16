package com.epam.poc.wearecommunity.stepDefinitions;

import com.epam.poc.wearecommunity.core.hook.Hook;
import com.epam.poc.wearecommunity.pageObjects.HeaderPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomeButtonSteps {

    private final WebDriver driver;
    private final HeaderPageObject headerPageObject;

    public HomeButtonSteps() {
        driver = Hook.driver;
        headerPageObject = new HeaderPageObject(driver);
    }

    @When("I click Home button")
    public void iClickHomeButton() {
        headerPageObject.clickHomeButton();
    }

    @Then("Verify clicked on Home button redirects the user to the main homepage")
    public void verifyRedirectToHomePage() {
        String currentPageTitle = headerPageObject.getPageTitle(driver);
        String currentURL = headerPageObject.getCurrentUrl(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(currentPageTitle).isEqualTo("Community Platform");
        softAssertions.assertThat(currentURL).isEqualTo("https://wearecommunity.io/");
        softAssertions.assertAll();
    }

    @Then("Verify Home button is visible on all pages")
    public void verifyHomePageIsDisplayed() {
        Assert.assertTrue(headerPageObject.isHomeButtonDisplayed());
    }
}
