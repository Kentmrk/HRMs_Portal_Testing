Feature: Login functionality for HRMS Portal

  @login
  Scenario: Login with valid credentials
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard page

  @login @error
  Scenario: Empty username validation
    When user leaves username empty
    And enters valid password "Hum@nhrm123"
    And user clicks on login button
    Then user gets "Username cannot be empty" error message

  @login @error
  Scenario: Empty password validation
    When user enters valid username "Admin"
    And leaves password empty
    And user clicks on login button
    Then user gets "Password cannot be empty" error message

  @login @error
  Scenario: Invalid credentials validation
    When user enters invalid username "WrongAdmin" and password "WrongPass123"
    And user clicks on login button
    Then user gets "Invalid credentials" error message