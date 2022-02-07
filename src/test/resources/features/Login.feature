Feature: Login Page Test Case

  Scenario Outline: Login with valid credential
    Given user is vms login page
    Then user enter username "<username>"
    Then user enter password "<password>"
    And click on sign in button
    Then verify user is successfully login
    Then user click on logout btn
    Then user is vms login page

    Examples:
      | username           | password   |
      | kualitatem.farhan1 | Lahore@123 |

