package com.epam.poc.wearecommunity.stepDefinitions;

import com.epam.poc.wearecommunity.core.hook.Hook;
import com.epam.poc.wearecommunity.pageObjects.LoginPageObject;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class LoginFunctionalitySteps {
    private final WebDriver driver;

    private final LoginPageObject loginPageObject;

    public LoginFunctionalitySteps() {
        driver = Hook.driver;
        loginPageObject = new LoginPageObject(driver);
    }

    @Then("All login options are displayed")
    public void allLoginOptionsAreDisplayed() {
        SoftAssertions soft = new SoftAssertions();

        loginPageObject.waitUntilSocialNameVisible("EPAM");

        soft.assertThat(loginPageObject.getLoginOption("EPAM").isDisplayed()).as("Login with EPAM is displayed").isTrue();
        soft.assertThat(loginPageObject.getLoginOption("LinkedIn").isDisplayed()).as("Login with LinkedIn is displayed").isTrue();
        soft.assertThat(loginPageObject.getLoginOption("Google").isDisplayed()).as("Login with Google is displayed").isTrue();
        soft.assertThat(loginPageObject.getLoginOption("Facebook").isDisplayed()).as("Login with Facebook is displayed").isTrue();
        soft.assertThat(loginPageObject.getLoginOption("Apple").isDisplayed()).as("Login with Apple is displayed").isTrue();
        soft.assertThat(loginPageObject.getLoginOption("GitHub").isDisplayed()).as("Login with GitHub is displayed").isTrue();
        soft.assertThat(loginPageObject.getLoginOption("GitLab").isDisplayed()).as("Login with GitLab is displayed").isTrue();
        soft.assertThat(loginPageObject.getLoginOption("Twitter").isDisplayed()).as("Login with Twitter is displayed").isTrue();
        soft.assertThat(loginPageObject.getLoginOption("VK").isDisplayed()).as("Login with VK is displayed").isTrue();
        soft.assertThat(loginPageObject.getLabelOption("Use your personal or corporate email").isDisplayed()).as("Use your personal or corporate email label is displayed").isTrue();

        soft.assertAll();
    }
}
