Feature: HealthCare

  @nmcHealthCare @smoke
  Scenario: User trying to Validate Home Screen.
    Given user login into nmc Application
    When user enters the login details
    Then user validates the homepage
    And user Click In OP Registration Option
    And user Navigate To OP Registration Screen

  @testcase2
  Scenario: OP Registration
    Given user login into nmc Application
    When user enters the login details
    Then user validates the homepage
    And user Click In OP Registration Option
    And user Navigate To OP Registration Screen
    Then user open the OP registration screen and validates OP Registration header
    Then user validates all salutations from Op Registration
    And user enters all the Basic Information details
    And User enters all the Additional Patient Information
    And  User enters Visit Information and with multiple teleconsultatrion "<Consultation>"
    And User OP Registration Successful

  @testcase3
  Scenario Outline: : OP Registration
    Given user login into nmc Application
    When user enters the login details
    Then user validates the homepage
    And user Click In OP Registration Option
    And user Navigate To OP Registration Screen
    Then user open the OP registration screen and validates OP Registration header
    Then user validates all salutations from Op Registration
    And user enters all the Basic Information details
    And  User enters Visit Information
    And User enters all the Additional Patient Information and city name as "<Name>"
    And User OP Registration Successful
    Examples:
      | Name                                                    |
      | MAMZER - DUBAI - United Arab Emirates                   |
      | Al BATEEN - ABU DHABI - United Arab Emirates            |
      | AL QUSAIS INDUSTRIAL - 2 - DUBAI - United Arab Emirates |
      | Motor City - DUBAI - United Arab Emirates               |
      | MUHAISANAH - 4 - DUBAI - United Arab Emirates           |


















