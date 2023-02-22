package com.epam.poc.wearecommunity.stepDefinitions;

import com.epam.poc.wearecommunity.core.GlobalConstants;
import com.epam.poc.wearecommunity.core.hook.Hook;
import com.epam.poc.wearecommunity.pageObjects.HeaderPageObject;
import com.epam.poc.wearecommunity.utilities.PropertyReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LanguageSelectionSteps {

    private final WebDriver driver;

    private final HeaderPageObject headerPageObject;

    public LanguageSelectionSteps() {
        driver = Hook.driver;
        headerPageObject = new HeaderPageObject(driver);
    }

    @When("I click on the language link")
    public void iClickOnTheLanguageLink() {
        headerPageObject.clickOnLanguageDropdownLink();
    }

    @Then("A dropdown menu appears that allows the user to select their preferred language: {string}, {string}, and {string}")
    public void aDropdownMenuAppearsThatAllowsTheUserToSelectTheirPreferredLanguageAnd(String valueDropdown1, String valueDropdown2, String valueDropdown3) {
        List<String> valueLanguageDropdown = headerPageObject.getValueLanguageDropdown();
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(valueLanguageDropdown.contains(valueDropdown1)).as("%s was one of values in Language Dropdown", valueDropdown1).isTrue();
        softly.assertThat(valueLanguageDropdown.contains(valueDropdown2)).as("%s was one of values in Language Dropdown", valueDropdown2).isTrue();
        softly.assertThat(valueLanguageDropdown.contains(valueDropdown3)).as("%s was one of values in Language Dropdown", valueDropdown3).isTrue();

        softly.assertAll();
    }

    @Then("The language selection is presented with {string} label")
    public void theLanguageSelectionIsPresentedWithLabel(String label) {
        headerPageObject.waitForSelectedLanguageValueTobePresent(label);
        Assertions.assertThat(headerPageObject.getSelectedLanguageDropdown()).as("The selected language dropdown had text: %s", label).isEqualTo(label);
    }

    @Then("The main navigation bar is displayed with the text in order from left to right {string}, {string}, {string}, {string}, {string}")
    public void theMainNavigationBarIsDisplayedWithTheTextInOrderFromLeftToRight(String communitiesTextTranslated, String eventsTextTranslated, String articlesTextTranslated, String videosTextTranslated, String aboutTextTranslated) {
        SoftAssertions softly = new SoftAssertions();

        String communitiesHref = "/communities";
        softly.assertThat(headerPageObject.getTextByLinkHref(communitiesHref)).as("The Communities link had been translated to %s", communitiesTextTranslated).isEqualTo(communitiesTextTranslated.toUpperCase());

        String eventsHref = "/all-events";
        softly.assertThat(headerPageObject.getTextByLinkHref(eventsHref)).as("The Events link had been translated to %s", eventsTextTranslated).isEqualTo(eventsTextTranslated.toUpperCase());

        String articlesHref = "/articles";
        softly.assertThat(headerPageObject.getTextByLinkHref(articlesHref)).as("The Articles link had been translated to %s", articlesTextTranslated).isEqualTo(articlesTextTranslated.toUpperCase());

        String videosHref = "/videos";
        softly.assertThat(headerPageObject.getTextByLinkHref(videosHref)).as("The Videos link had been translated to %s", videosTextTranslated).isEqualTo(videosTextTranslated.toUpperCase());

        String aboutHref = "/communities/community-platform";
        softly.assertThat(headerPageObject.getTextByLinkHref(aboutHref)).as("The About link had been translated to %s", aboutTextTranslated).isEqualTo(aboutTextTranslated.toUpperCase());

        softly.assertAll();
    }

    @Then("The language selection is visible")
    public void theLanguageSelectionIsVisible() {
        Assertions.assertThat(headerPageObject.isLanguageSelectionDisplayed()).as("The Language selection was visible").isTrue();
    }

    @When("I wait for until the page is translated with the {string} successfully")
    public void iWaitForUntilThePageIsTranslatedWithTheSuccessfully(String selectedLanguage) {
        headerPageObject.waitForSelectedLanguageValueTobePresent(selectedLanguage);
    }

    @When("I open the home page of wearecommunity website in a new tab")
    public void iOpenTheHomePageOfWeAreCommunityWebsiteInANewTab() {
        headerPageObject.openAndSwitchToNewTab(driver);
        String pageUrl = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY).getValue(GlobalConstants.PAGE_URL);
        driver.get(pageUrl);
    }
}
