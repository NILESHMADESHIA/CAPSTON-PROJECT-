Feature: Google Search

  Scenario: Validate google search functionality
    Given I Open google
    When I enter valid text in search box
    And Ihit enter
    Then A valid search result should display
