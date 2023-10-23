@WebOrange
Feature: Automation Assessment

  Scenario: User successfully login and logout
    #Login
    Given User is on the login page
    When User input username as "Admin"
    And User input password as "admin123"
    And User click button login
    Then User successfully login
    #Logout
    When User click button profile icon
    And User click button "logout" from user dropdown
    Then User successfully logout

  Scenario: User successfully Apply leave and cancel leave
    #Apply leave
    Given User is on the login page
    And User input username as "Admin"
    And User input password as "admin123"
    And User click button login
    When User click "leave" menu
    And User click "apply" menu in leave page
    And User select leave type as "CAN - Vacation"
    And User select leave date "2023-11-03"
    And User input comment as "test"
    And User click apply button
    Then User successfully apply leave
    #Cancel leave
    When User click "My Leave" menu in leave page
    And User click cancel leave one of leave list
    Then User successfully cancel leave

  Scenario: User successfully update personal details
    Given User is on the login page
    And User input username as "Admin"
    And User input password as "admin123"
    And User click button login
    When User click "my info" menu
    And User input firstname as "Burak"
    And User input middlename as "test"
    And User input lastname as "Yazıcı"
    And User input nickname as "Burak"
    And User click save button in personal details page
    Then User successfully update personal details

  Scenario: User successfully update contact details
    Given User is on the login page
    And User input username as "Admin"
    And User input password as "admin123"
    And User click button login
    When User click "my info" menu
    And User click "contact details" submenu from my info page
    And User input street 1 as "jl bambu"
    And User input city as "jakarta"
    And User input mobile phone as "087889379566"
    And User click save button in contact details page
    Then User successfully update contact details



