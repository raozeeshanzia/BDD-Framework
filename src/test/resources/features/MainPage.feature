Feature: Main Page Test Cases

  Scenario: Get Data Of Game Through API And Verify
    Given User is on main page
    Then click on slide Bar button
    Then get the most top game with increasing rank in hotest tab
    And hit the api store result
    Then click on most top game with increasing rank in hotest tab
    Then verify the api language dependency poll from web

