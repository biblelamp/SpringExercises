Feature: User Profile API

  Scenario: Successfully create a new user
    Given Create UserDTO
      | firstName | John   |
      | lastName  | Smith  |
    When Sent post request to create User
    Then Response code is 200
