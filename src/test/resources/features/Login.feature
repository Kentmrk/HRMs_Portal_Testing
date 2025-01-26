Feature: Login functionality for HRMS Portal

  @login
  Scenario: Login with valid credentials
    When user enters admin username "Admin" and password "Hum@nhrm123"
    And user clicks on login button
    Then user is able to see dashboard page

  @login @datadriven
  Scenario Outline: Username validation
    When user enters admin "<UserName>" and "<Password>"
    And user clicks on login button
    Then system shows "<Error>" error message
    When user enters admin username "Admin" and password "Hum@nhrm123"
    And user clicks on login button
    Then user is able to see dashboard page
    Examples:
      | UserName   | Password    | Error                    |
      |            | Hum@nhrm123 | Username cannot be empty |
      | Admin      |             | Password is Empty        |
      | WrongAdmin | Hum@nhrm123 | Invalid credentials      |
      | Admin      | WrongPass   | Invalid credentials      |