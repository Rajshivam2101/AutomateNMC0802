Feature: ip Registration

  @testcase6
  Scenario: ip registration with insurance

    Given user login into nmc Application
    When user enters the login details
#    Then user validates the homepage
    When user clicks on the ip registration link.
    Then user is in ip registration screen.
