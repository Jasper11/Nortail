Feature: Test Views

  Background:
    Given User is on sample list screen

  Scenario: Test DoubleTap
    When User navigates to "Double Tap" view
    And Perform double tap on button
    Then User observe popUp with message "Double tap successful!"

  Scenario: Test LongPress
    When User navigates to "Long Press" view
    And Perform long press on button
    Then User observe popUp with message "you pressed me hard :P"

  Scenario: Test Drag&Drop
    When User navigates to "Drag & Drop" view
    And drag n drop circle
    Then User observe drag & drop success message

  Scenario: Test Swipe Left/Right
    When User navigates to "Carousel" view
    And User swipe left
    Then User observe text "2" on Square
    When User swipe right
    Then User observe text "1" on Square

  Scenario: Test Picker
    When User navigates to "Wheel Picker" view
    And Select in picker item with "green" text
    Then User sees message with " Current Color: green " text

  Scenario: Test Slider
    When User navigates to "Slider" view
    And Set slider value with 0.5 percentage
    Then Slider is set with "64.0" value

  Scenario: Test Native View
    When User navigates to "Native View" view
    Then Text "Hello World, I'm View one " is present
    And Text "Hello World, I'm View two " is present
    And Text "Hello World, I'm View three " is present

  Scenario: Test Vertical swipe View
    When User navigates to "Vertical swiping" view
    Then Observes " Javascript" text on vertical swipe view
    And Observes " Appium" text on vertical swipe view
