@ui
Feature: Search for testing

  Scenario: Searching for Wikipedia testing results
    Given I open Google
    When I search for "Unit testing"
    Then I should find "Unit testing - Wikipedia"