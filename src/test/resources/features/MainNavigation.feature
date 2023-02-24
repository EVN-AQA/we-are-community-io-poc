@Regression
@MainNavigation

Feature: EPMRDVN-7131 - Test the Main Navigation
  As a guest,
  I would like to view and access to main pages through a navigation bar,
  So that I can quickly navigate to different pages

  Background:
    Given I open the home page of wearecommunity website

  Scenario: EPMRDVN-7331 - Verify the Main Navigation is located at the top of the page and visible on the screen while scrolling through the website
    Then The main navigation bar is located at the top of the website
    And The main navigation bar is visible on the screen while scrolling through the website

  Scenario Outline: EPMRDVN-7332 - Verify the Main Navigation is visible on all pages
    When I click on "<Link Name>" link
    Then The main navigation bar is visible on the screen while scrolling through the website
    Examples:
      | Link Name   |
      | Communities |
      | Events      |
      | Articles    |
      | Videos      |
      | About       |

  Scenario Outline: EPMRDVN-7333 - Verify the Main Navigation has a darker hover effect when user hover on it
    When I hover on "<Link Name To Hover>" link
    Then "<Link Name To Hover>" link has a darker hover effect, indicating that it is clickable
    Examples:
      | Link Name To Hover |
      | Communities        |
      | Events             |
      | Articles           |
      | Videos             |
      | About              |

  Scenario Outline: EPMRDVN-7334 - Verify the Main Navigation will be highlighted and the new page will be opened with the expected URL when user click on it
    When I hover on "<Link Name To Hover>" link
    And I click on "<Link Name To Click>" link
    Then The new page will be opened successfully with the URL: "<Page Url>"
    And "<Link Name To Highlight>" link will be highlighted
    Examples:
      | Link Name To Hover | Link Name To Click | Link Name To Highlight | Page Url                                                                  |
      | Communities        | Communities        | Communities            | https://wearecommunity.io/communities                                     |
#      | Events             | Events             | Events                 | https://wearecommunity.io/all-events                                      |  //Comment this case because this can cause a bug when running on Firefox, and assume that this bug has already been fixed after Sprint 2
      | Events             | Online events      | Events                 | https://wearecommunity.io/online-events?f%5B0%5D%5Bonline%5D%5B%5D=Online |
      | Events             | All Events         | Events                 | https://wearecommunity.io/all-events                                      |
      | Events             | Speakers           | Events                 | https://wearecommunity.io/speakers                                        |
      | Events             | Calendar           |                        | https://wearecommunity.io/calendar                                        |
      | Articles           | Articles           | Articles               | https://wearecommunity.io/articles                                        |
      | Videos             | Videos             | Videos                 | https://wearecommunity.io/videos                                          |
      | About              | About              | Home                   | https://wearecommunity.io/communities/community-platform                  |