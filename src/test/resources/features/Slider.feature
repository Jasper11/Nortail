Feature: Slider

  Background:
    Given User is on Slider view

  Scenario: Test Slider
    When I set slider value with 0.5 percentage
    Then Slider is set with "64.0" value
