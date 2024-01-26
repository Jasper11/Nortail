#Feature: Login
#
#  Background:
#    Given User is on login screen
#
#  @ValidCredentials
#  Scenario Outline: Login with valid credentials
#    When User enters "<credentials>"
#    Then User is logged successfully and Sample List screen is opened
#    Examples:
#      | credentials   |
#      | valid   |
#
#  @InvalidCredentials
#  Scenario Outline: Login with invalid credentials
#
#    When User enters "<credentials>"
#    Then User sees message as "<errorText>"
#
#    Examples:
#      | credentials   | errorText |
#      | invalid_1   |      Invalid  Credentials       |
#      | invalid_2   |      Invalid  Credentials       |
#
#
#  @MissingUsername/Password
#  Scenario Outline: Login with blank username/password
#
#    When User enters "<credentials>"
#    Then User sees message as "<errorText>"
#
#    Examples:
#      | credentials   | errorText |
#      | empty_1   |      Please enter Username or password       |
#      | empty_2   |      Please enter Username or password       |

Feature: Test Views
  Background:
    Given User is on sample list screen

  Scenario: Test DoubleTap
    When User navigates to "Double Tap" view
    And User make double tap on button
    Then User sees message as "Double tap successful!"
