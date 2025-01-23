Feature: Add Employee functionality in HRMS

  Background:
    Given user is logged in with admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @addEmployee
  Scenario: Add employee without employee ID
    When user enters first name "John" and last name "Smith"
    And user clicks on save button
    Then system generates employee ID automatically
    And employee is successfully added

  @addEmployee
  Scenario: Add employee with middle name
    When user enters first name "Jane" and middle name "Marie" and last name "Doe"
    And user clicks on save button
    Then employee is successfully added

  @addEmployee
  Scenario: Add employee with custom ID
    When user enters first name "Michael" and last name "Johnson"
    And user enters employee ID "EMP2024001"
    And user clicks on save button
    Then employee is successfully added with ID "EMP2024001"

  @addEmployee @datadriven
  Scenario Outline: Add multiple employees with data
    When user enters employee data "<firstName>" and "<middleName>" and "<lastName>"
    And user enters employee ID "<employeeId>"
    And user clicks on save button
    Then system shows "<status>" message

    Examples:
      | firstName | middleName | lastName | employeeId  | status                     |
      | Mark      | John       | Wilson   | EMP001      | Employee added successfully|
      | Sarah     | Elizabeth  | Taylor   |             | Employee added successfully|
      | Robert    | James      | Brown    | Invalid#ID  | Invalid ID format         |