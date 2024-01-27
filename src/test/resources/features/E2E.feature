Feature: Login

  Background:
    Given User is on login screen

  @ValidCredentials
  Scenario Outline: Login with valid credentials
    When User perform login with "<credentials>"
    Then User is logged successfully and Sample List screen is opened
    Examples:
      | credentials |
      | valid       |

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    When User perform login with "<credentials>"
    Then User sees message as "<errorText>"
    Examples:
      | credentials | errorText            |
      | invalid_1   | Invalid  Credentials |
      | invalid_2   | Invalid  Credentials |

  @MissingUsername/Password
  Scenario Outline: Login with blank username/password
    When User perform login with "<credentials>"
    Then User sees message as "<errorText>"

    Examples:
      | credentials | errorText                         |
      | empty_1     | Please enter Username or password |
      | empty_2     | Please enter Username or password |

Feature: Test Views

  Background:
    Given User is on sample list screen

  Scenario: Test DoubleTap
    When User navigates to "Double Tap" view
    And User make double tap on button
    Then User sees message as "Double tap successful!"

  Scenario: Test LongPress
    When User navigates to "Long Press" view
    And User make long press on button
    Then User sees message as "you pressed me hard :P"

  Scenario: Test Drag&Drop
    When User navigates to "Drag & Drop" view
    And User drag n drop circle
    Then User sees success message

  Scenario: Test Swipe Left/Right
    When User navigates to "Carousel" view
    And User swipe left
    Then User sees text "2"
    When User swipe right
    Then User sees text "1"

  Scenario: Test Picker
    When User navigates to "Wheel Picker" view
    And User selects in picker item with "green" text
    Then User sees message with "Current Color: green" text

  Scenario: Test Slider
    When User navigates to "Slider" view
    And User sets slider value with 0.5 percentage
    Then slider is set with "64.0" value

  Scenario: Test Native View
    When User navigates to "Native View" view
    Then User sees text "Hello World, I'm View one " on native view
    And User sees text "Hello World, I'm View two " on native view
    And User sees text "Hello World, I'm View three " on native view

  Scenario: Test Vertical swipe View
    When User navigates to "Vertical swiping" view
    Then User sees " Javascript" text on vertical swipe view
    And User sees " Appium" text on vertical swipe view
