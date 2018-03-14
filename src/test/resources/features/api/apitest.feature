Feature: Hit the Pega Endpoint

  Scenario: Test we can hit the endpoint for the PEGA Solution
    Given the PEGA endpoint is availble
    When I hit the endpoint
    Then I should get 200 back