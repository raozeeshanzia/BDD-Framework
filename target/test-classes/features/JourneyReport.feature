Feature: Journey Report Page test cases

  Scenario Outline: Verify result is successfully display on grid view
    Given user is vms login page
    Then user enter username "<username>"
    Then user enter password "<password>"
    And click on sign in button
    Then verify user is successfully login
    Then user click on journey report link
    Then select SQA officer name "<nameOfOfficer>"
    Then enter start start date "<startDate>"
    Then enter end date "<endDate>"
    Then click on view in grid button
    Then verify user "<nameOfOfficer>" is display in a grid view
    Then user click on logout btn
    Then user is vms login page

    Examples:
      | username           | password   | nameOfOfficer    | startDate | endDate  |
      | kualitatem.farhan1 | Lahore@123 | kualitatem.rabab | 01042022  | 01052022 |


  Scenario Outline: Verify journey report is successfully download
    Given user is vms login page
    Then user enter username "<username>"
    Then user enter password "<password>"
    And click on sign in button
    Then verify user is successfully login
    Then user click on journey report link
    Then select SQA officer name "<nameOfOfficer>"
    Then enter start start date "<startDate>"
    Then enter end date "<endDate>"
    Then click on download excel button
    Then verify "<fileName>" file is successfully download on system
    Then user click on logout btn
    Then user is vms login page

    Examples:
      | username           | password   | nameOfOfficer    | startDate | endDate  | fileName      |
      | kualitatem.farhan1 | Lahore@123 | kualitatem.rabab | 01042022  | 01052022 | SummaryReport |