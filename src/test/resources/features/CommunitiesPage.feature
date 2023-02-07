@Smoke
Feature: Open Communities Page
  As a user
  I want to see all communities
  So that I can verify Communities page works well

  @OpenCommunitiesPageSuccessfully
  Scenario: Test can open Communities page successfully without login to the system
    Given I open the home page of wearecommunity website
    When I click to "See all communities" link
    Then The Communities page will be opened successfully with title: "Communities | Community Platform" and the URL: "https://wearecommunity.io/communities"

  @SearchExistedCommunity
  Scenario Outline: Test can search an existed community in Communities page
    Given I open the home page of wearecommunity website
    When I click to "See all communities" link
    And I type keyword "<Keyword>" on search box
    Then The list search result communities will contains keyword "<Keyword>"
    When I click to the community with the title "<Page title>"
    Then The detail community page will be opened successfully with title: "<Page title>" and the URL: "<Page url>"
    Examples: Community page information
      | Keyword            | Page title                   | Page url                                             |
      | Automation testing | Automation Testing Community | https://wearecommunity.io/communities/testautomation1 |
      | Language Lea       | Language Learning Junkies    | https://wearecommunity.io/communities/junkies   2     |
      | Golang             | Golang United                | https://wearecommunity.io/communities/golang     3    |
