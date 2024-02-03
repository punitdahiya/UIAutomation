Feature: Login

  @login @SmokeTest
  Scenario: Verify user is able to login to web page
    Given User is on login page
    When Enter username 'standard_user'
    When Enter password 'secret_sauce'
    When Click on login button
    Then Ensure user land on dashboard page

  @login @SmokeTest
  Scenario Outline: Verify user is not able to login to web page
    Given User is on login page
    When Enter username '<username>'
    When Enter password '<password>'
    When Click on login button
    Then Ensure user gets error message - '<ErrorMessage>'
    Then User is on login page

    Examples:
    | username                | password         | ErrorMessage                                                              |
    | locked_out_user         | secret_sauce     | Epic sadface: Sorry, this user has been locked out.                       |
    | invalid_username        | secret_sauce     | Epic sadface: Username and password do not match any user in this service |
    | standard_user           | invalid_password | Epic sadface: Username and password do not match any user in this service |
    | invalid_username        | invalid_password | Epic sadface: Username and password do not match any user in this service |