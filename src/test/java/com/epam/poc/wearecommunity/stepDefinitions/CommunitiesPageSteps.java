package com.epam.poc.wearecommunity.stepDefinitions;

import com.epam.poc.wearecommunity.pageObjects.CommunitiesPageObject;
import com.epam.poc.wearecommunity.pageObjects.CommunityDetailPageObject;
import com.epam.poc.wearecommunity.utilities.hook.Hook;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CommunitiesPageSteps {

    private final WebDriver driver;
    private final CommunitiesPageObject communitiesPageObject;

    public CommunitiesPageSteps() {
        driver = Hook.driver;
        communitiesPageObject = new CommunitiesPageObject(driver);
    }

    @Then("The Communities page will be opened successfully with title: {string} and the URL: {string}")
    public void theCommunitiesPageWillBeOpenedSuccessfullyWithTitleAndTheURL(String titleName, String urlName) {
        Assert.assertTrue(communitiesPageObject.isPageOpenSuccessfully(titleName, urlName));
    }

    @When("I type keyword {string} on search box")
    public void iTypeKeywordOnSearchBox(String keySearch) {
        communitiesPageObject.searchByKeyword(keySearch);
    }

    @Then("The list search result communities will contains keyword {string}")
    public void theCommunityWithTheTitleWillBeDisplayedAsASearchResult(String keySearch) {
        Assert.assertTrue(communitiesPageObject.isExpectedCommunitiesDisplayed(keySearch));
    }

    @When("I click to the community with the title {string}")
    public void iClickToTheCommunityWithTheTitle(String communityTitle) {
        communitiesPageObject.openPageByCommunityTitle(communityTitle);
    }

    @Then("The detail community page will be opened successfully with title: {string} and the URL: {string}")
    public void theDetailCommunityPageWillBeOpenedSuccessfullyWithTitleAndTheURL(String titleName, String urlName) {
        CommunityDetailPageObject communityDetailPageObject = new CommunityDetailPageObject(driver);
        Assert.assertTrue(communityDetailPageObject.isPageOpenSuccessfully(titleName, urlName));
    }
}
