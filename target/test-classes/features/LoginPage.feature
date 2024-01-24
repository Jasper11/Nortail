Feature: Login

  Background:
    Given User is on login screen

  @ValidCredentials
  Scenario: Login with valid credentials
    When User enters username as "admin" and password as "admin"
    Then User is logged successfully and Sample List screen is opened

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials

    When User enters username as "<username>" and password as "<password>"
    Then User sees error message as "<errorText>"

    Examples:
      | username   | password  | errorText                      |
      | Admin        | admin12$$ | Invalid  Credentials               |
      | admin$$    | admin123  | Invalid  Credentials               |
      | abc123       | xyz$$     | Invalid  Credentials                    |


  @MissingUsername/Password
  Scenario Outline: Login with blank username/password

    When User enters username as "<username>" and password as "<password>"
    Then User sees error message as "<errorText>"

    Examples:
      | username   | password  | errorText                      |
      || admin | Please enter Username or password               |
      | admin    |   | Please enter Username or password               |

