package com.epam.poc.wearecommunity.stepDefinitions;

import com.epam.poc.wearecommunity.core.hook.Hook;
import com.epam.poc.wearecommunity.pageObjects.HeaderPageObject;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MainNavigationSteps {

    private static final String DARK_COLOR = "#2f2e2d";
    private static final String HIGHLIGHT_COLOR = "#40c5df";
    private static final String POSITION_FIXED = "fixed";

    private final WebDriver driver;
    private final HeaderPageObject headerPageObject;

    public MainNavigationSteps() {
        driver = Hook.driver;
        headerPageObject = new HeaderPageObject(driver);
    }

    @Then("The main navigation bar is located at the top of the website")
    public void theMainNavigationBarIsLocatedAtTheTopOfTheWebsite() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(headerPageObject.getElementPositionCssValue("Communities")).as("Communities link was located at the top of the page").isEqualTo(POSITION_FIXED);
        softly.assertThat(headerPageObject.getElementPositionCssValue("Events")).as("Events link was located at the top of the page").isEqualTo(POSITION_FIXED);
        softly.assertThat(headerPageObject.getElementPositionCssValue("Articles")).as("Articles link was located at the top of the page").isEqualTo(POSITION_FIXED);
        softly.assertThat(headerPageObject.getElementPositionCssValue("Videos")).as("Videos link was located at the top of the page").isEqualTo(POSITION_FIXED);
        softly.assertThat(headerPageObject.getElementPositionCssValue("About")).as("About link was located at the top of the page").isEqualTo(POSITION_FIXED);

        softly.assertAll();
    }

    @Then("The main navigation bar is visible on the screen while scrolling through the website")
    public void theMainNavigationBarIsVisibleOnTheScreenWhileScrollingThroughTheWebsite() {
        assertThat(headerPageObject.isMainNavigationVisibleWhileScrolling()).as("Main navigation was visible while scrolling through the website").isTrue();
    }

    @Then("{string} link has a darker hover effect, indicating that it is clickable")
    public void linkHasADarkerHoverEffectIndicatingThatItIsClickable(String linkName) {
        assertThat(headerPageObject.getElementColor(linkName, "background-color")).as("%s link had a darker hover effect", linkName).isEqualTo(DARK_COLOR);
    }

    @Then("{string} link will be highlighted")
    public void linkWillBeHighlighted(String linkName) {
        assertThat(headerPageObject.getElementColor(linkName, "color")).as("%s link was be highlighted", linkName).isEqualTo(HIGHLIGHT_COLOR);
    }

    @Then("The new page will be opened successfully with the URL: {string}")
    public void theNewPageWillBeOpenedSuccessfullyWithTheURL(String pageUrl) {
        assertThat(headerPageObject.getCurrentUrl(driver)).as("The new page was be opened successfully with the expected URL").isEqualTo(pageUrl);
    }
}
