Feature: DoubleTap

  Background:
    Given User is on DoubleTap view

  Scenario: Test DoubleTap
    When I perform double tap on button
    Then I see popUp with message "Double tap successful!" on DoubleTap screen
