Feature: OpRegistrationW
  @testcase4
  Scenario: OP Registration With Insurance
    Given user login into nmc Application
    When user enters the login details
    Then user validates the homepage
    And user Click In OP Registration Option
    And user Navigate To OP Registration Screen
    Then user open the OP registration screen and validates OP Registration header
    Then user validates all salutations from Op Registration
    And user enters all the Basic Information details
    And User enters all the Additional Patient Information
    And user enters insurance details
    And  User enters Visit Information
    And User OP Registration Successful





