@Regression
@LanguageSelection

Feature: EPMRDVN-7129 - Test Language Selection
  As a user,
  I should be able to have a language selection button on the main navigation bar,
  So that I can easily switch between different languages on the website:
  - English
  - Russian (Русский)
  - Ukrainian (Українська)

  Background:
    Given I open the home page of wearecommunity website

  Scenario: EPMRDVN-7351 - Verify when the user clicks on the language button, a dropdown menu appears that allows the user to select their preferred language
    When I click on the language link
    Then A dropdown menu appears that allows the user to select their preferred language: "English", "Русский", and "Українська"

  Scenario Outline: EPMRDVN-7352 - Verify the selected language selection button is present on the main navigation bar and it is clearly labeled
    When I click on the language link
    And I click on "<Link Name>" link
    Then The language selection is presented with "<Label>" label

    Examples:
      | Link Name  | Label |
      | Українська | Укр   |
      | Русский    | Ру    |
      | English    | Eng   |

  Scenario Outline: EPMRDVN-7353 - Verify when the user selects a specific language, the website content is displayed in the selected language
    When I click on the language link
    And I click on "<Link Name>" link
    And I wait for until the page is translated with the "<Selected Language>" successfully
    Then The main navigation bar is displayed with the text in order from left to right "<Communities By Language>", "<Events By Language>", "<Articles By Language>", "<Videos By Language>", "<About By Language>"

    Examples:
      | Link Name  | Selected Language | Communities By Language | Events By Language | Articles By Language | Videos By Language | About By Language |
      | Русский    | Ру                | Сообщества              | События            | Статьи               | Видео              | О нас             |
      | Українська | Укр               | Спільноти               | Події              | Статті               | Відео              | Про нас           |
      | English    | Eng               | Communities             | Events             | Articles             | Videos             | About             |

  Scenario Outline: EPMRDVN-7354 - Verify that the language selection button is visible and accessible on all pages of the website
    When I click on "<Link Name>" link
    Then The language selection is visible
    When I click on the language link
    Then A dropdown menu appears that allows the user to select their preferred language: "English", "Русский", and "Українська"

    Examples:
      | Link Name   |
      | Communities |
      | Events      |
      | Articles    |
      | Videos      |
      | About       |

  Scenario Outline: EPMRDVN-7355 - Verify that the website saves the user's selected language preference for the next visit (open new tab)
    When I click on the language link
    And I click on "<Link Name>" link
    And I wait for until the page is translated with the "<Selected Language>" successfully
    And I open the home page of wearecommunity website in a new tab
    Then The main navigation bar is displayed with the text in order from left to right "<Communities By Language>", "<Events By Language>", "<Articles By Language>", "<Videos By Language>", "<About By Language>"

    Examples:
      | Link Name  | Selected Language | Communities By Language | Events By Language | Articles By Language | Videos By Language | About By Language |
      | Русский    | Ру                | Сообщества              | События            | Статьи               | Видео              | О нас             |
      | Українська | Укр               | Спільноти               | Події              | Статті               | Відео              | Про нас           |
      | English    | Eng               | Communities             | Events             | Articles             | Videos             | About             |