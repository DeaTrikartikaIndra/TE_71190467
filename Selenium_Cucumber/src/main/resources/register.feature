Feature: feature to test register functionality
  Scenario Outline: Check register with valid credentials
    Given buka browser
    And user berada di halaman register
    When user memasukkan <email> dan <password>
    And klik tombol register
    Then user mengarahkan ke halamn utama
    Examples:
    |email              |password         |
    |dea@gmail.com      |dea123456        |
    |dea@gmail.com      |dea              |
    |dea@gmail.com      |deacantiksekali  |
    |dea@gmail.com      |dea_cantik!      |
    |dea@gmail.com      |                 |
    |                   |                 |
    |                   |deacantik        |
