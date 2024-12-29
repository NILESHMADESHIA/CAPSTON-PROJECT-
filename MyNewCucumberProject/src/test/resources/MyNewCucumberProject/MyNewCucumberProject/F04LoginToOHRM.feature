Feature: Login to OHRM

  Background: 
    Given Open OHRM

  Scenario: Login to OHRM using valid data
    When Enter valid userName as "admin" and password as "admin123"
    And I click on Login button
    Then Dashboard page should display

  Scenario: Login to OHRM using invalid data
    When Enter invalid username as "nilesh" and password as "nilesh123"
    And Click on Login button
    Then Error massage should  be display
