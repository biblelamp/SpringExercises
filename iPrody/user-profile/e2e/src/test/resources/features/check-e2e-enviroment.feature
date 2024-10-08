Feature: Checking e2e environment

  Scenario: Checking the successful launch of the e2e test environment
    Given API Service is started
    When I run test
    Then Test should be finished successfully
