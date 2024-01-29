Feature: Swipe Left/Right

  Background:
    Given User is on Carousel view

  Scenario: Test Swipe Left/Right
    When I swipe left
    Then I see text "2" on Square
    When I swipe right
    Then I see text "1" on Square
