Feature: Add Employee functionality in HRMS

  Background:
    When user enters admin username "Admin" and password "Hum@nhrm123"
    And user clicks on login button
    Then user is able to see dashboard page
    And navigate to PIM Add Emploee

  @addEmployee @autoID
  Scenario: Add employee with auto-generated ID
    When user enters employee first name "John"
    And user enters employee last name "Smith"
    And clicks save button
    Then system generates unique ID
    And employee is successfully added

  @addEmployee @manualID
  Scenario: Add employee with manual ID
    When user enters employee first name "Jane"
    And user enters employee last name "Doe"
    And enters employee ID "EMP2024001"
    And clicks save button
    Then employee is added with ID "EMP2024001"

  @addEmployee @validation
  Scenario Outline: Validate required fields
    When user enters "<FirstName>" "<LastName>"
    And clicks save button
    Then system shows "<Error>" for "<Field>"

    Examples:
      | FirstName | LastName | Error           | Field     |
      |           | Smith    | Required field  | firstName |
      | John      |          | Required field  | lastName  |