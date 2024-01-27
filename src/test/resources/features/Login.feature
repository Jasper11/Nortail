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
    Then User observe popUp with message "<errorText>"
    Examples:
      | credentials | errorText            |
      | invalid_1   | Invalid  Credentials |
      | invalid_2   | Invalid  Credentials |

  @MissingUsername/Password
  Scenario Outline: Login with blank username/password
    When User perform login with "<credentials>"
    Then User observe popUp with message "<errorText>"

    Examples:
      | credentials | errorText                         |
      | empty_1     | Please enter Username or password |
      | empty_2     | Please enter Username or password |

