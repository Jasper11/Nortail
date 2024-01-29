Feature: Native View

  Background:
    Given User is on Native View view

  Scenario: Test Native View
    Then I see text "Hello World, I'm View one " displayed
    And I see text "Hello World, I'm View two " displayed
    And I see text "Hello World, I'm View three " displayed
