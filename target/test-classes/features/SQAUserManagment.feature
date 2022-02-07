Feature: SQA User Management Test cases

  Scenario Outline: Successfully change the status of user to INACTIVE
    Given user is vms login page
    Then user enter username "<username>"
    Then user enter password "<password>"
    And click on sign in button
    Then verify user is successfully login
    Then User click on SQA User Management link
    Then user click on edit button
    Then user select user status "<status>"
    Then click on update button
    Then verify status is successfully update to "<status>"
    Then user click on logout btn
    Then user is vms login page

    Examples:
      | username           | password   | status  |
      | kualitatem.farhan1 | Lahore@123 | Inactive |

  Scenario Outline: Successfully change the status of user to ACTIVE
    Given user is vms login page
    Then user enter username "<username>"
    Then user enter password "<password>"
    And click on sign in button
    Then verify user is successfully login
    Then User click on SQA User Management link
    Then user click on edit button
    Then user select user status "<status>"
    Then click on update button
    Then verify status is successfully update to "<status>"
    Then user click on logout btn
    Then user is vms login page

    Examples:
      | username           | password   | status |
      | kualitatem.farhan1 | Lahore@123 | Active |
