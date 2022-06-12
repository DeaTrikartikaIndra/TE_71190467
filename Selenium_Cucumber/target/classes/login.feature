Feature: feature to test login functionality
  Scenario Outline: Check login with valid credentials
    Given browser opened
    And user in register page
    And user in login page
    When user insert <email> and <password>
    And login button clicked
    Then user redirect to main screen
    Examples:
      |email              |password         |
      |                   |                 |
      |dea@gmail.com      |                 |
      |                   |deacantik        |
      |dea@gmail.com      |deacantik        |
      |dea@gmail.com      |dea              |
      |dea@gmail.com      |deacantiksekali  |
      |dea@gmail.com      |dea_cantik!      |