Feature: Google Page Validation

  Scenario: Verify Google Page Title

    Given User launches Google website
    When User gets the page title
    Then Title should be "Google"

  Scenario: Verify Google Current URL

    Given User launches Google website
    When User gets the current URL
    Then URL should contain "google.com"

  Scenario: Verify Google Page Source

    Given User launches Google website
    When User gets the page source
    Then Page source should be available