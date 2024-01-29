Feature: Picker

  Background:
    Given User is on Wheel Picker view

  Scenario: Test Picker
    When I select picker item with "green" text
    Then I see message with " Current Color: green " text
