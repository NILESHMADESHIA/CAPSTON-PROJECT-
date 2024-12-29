Feature: Test google title

  Scenario: To validate title of Google
    Given Open google
    When Read the title
    Then Title should be Google
