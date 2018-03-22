@rob
Feature: Hit the OPEN Endpoint

  Scenario: Test we can hit the endpoint for the OPEN Solution
    Given the OPEN endpoint is available
    When I hit the endpoint
    Then I should get 200 back