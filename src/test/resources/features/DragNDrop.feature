Feature: Drag&Drop

  Background:
    Given User is on Drag & Drop view

  Scenario: Test Drag&Drop
    When I drag n drop circle
    Then I see drag & drop success message
