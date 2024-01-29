Feature: Login

  Background:
    Given User is on login screen

  @ValidCredentials
  Scenario Outline: Login with valid credentials
    When I perform login with "<credentials>"
    Then I get logged in
    Examples:
      | credentials |
      | valid       |

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    When I perform login with "<credentials>"
    Then I see popUp with message "<errorText>" on Login screen
    Examples:
      | credentials | errorText            |
      | invalid_1   | Invalid  Credentials |
      | invalid_2   | Invalid  Credentials |

  @MissingUsername/Password
  Scenario Outline: Login with blank username/password
    When I perform login with "<credentials>"
    Then I see popUp with message "<errorText>" on Login screen

    Examples:
      | credentials | errorText                         |
      | empty_1     | Please enter Username or password |
      | empty_2     | Please enter Username or password |

