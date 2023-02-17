@Regression
Feature: EPMRDVN-7132 - Test Home Button
  As a user
  I want to see Home button on all pages
  So that I can click on button and redirects the user to the main homepage

  Background:
    Given I open the home page of wearecommunity website

  @Smoke
  Scenario: EPMRDVN-7335 - Verify Home button is clickable and that it redirects the user to the main homepage
    When I click on "See all communities" link
    And I click Home button
    Then Verify clicked on Home button redirects the user to the main homepage

  @Smoke
  Scenario Outline: EPMRDVN-7336 - Verify Home button is visible and accessible on all pages
    When I click on "<Link Name>" link
    Then Verify Home button is visible on all pages
    Examples:
    | Link Name     |
    | Communities   |
    | Events        |
    | Articles      |
    | Videos        |
    | About         |