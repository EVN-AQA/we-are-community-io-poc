@Regression
Feature: EPMRDVN-7130 - Test Login Functionality
  As a EPAMer
  I want to be able to log into the WeAreCommunity page
  So that I can access my account information and participate in the community

  Background:
    Given I open the home page of wearecommunity website

  Scenario: EPMRDVN-7368 - Verify that the member can see 10 different login options
    When I click on "Login" link
    And I click on "Show more" link
    Then All login options are displayed
