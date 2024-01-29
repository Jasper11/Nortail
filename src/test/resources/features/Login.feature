Feature: Login

  Background:
    Given User is on login screen

  @ValidCredentials
  Scenario Outline: Login with valid credentials
    When I perform login with "<loginTestDataSet>"
    Then I get logged in
    Examples:
      | loginTestDataSet |
      | valid       |

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    When I perform login with "<loginTestDataSet>"
    Then I see popUp with message from "<loginTestDataSet>" on Login screen
    Examples:
      | loginTestDataSet |
      | invalid_1   |
      | invalid_2   |

  @MissingUsername/Password
  Scenario Outline: Login with blank username/password
    When I perform login with "<loginTestDataSet>"
    Then I see popUp with message from "<loginTestDataSet>" on Login screen

    Examples:
      | loginTestDataSet |
      | empty_1     |
      | empty_2     |

