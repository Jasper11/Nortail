Feature: LongPress

  Background:
    Given User is on Long Press view

  Scenario: Test LongPress
    When I perform long press on button
    Then I see popUp with message "you pressed me hard :P" on LongPress screen
