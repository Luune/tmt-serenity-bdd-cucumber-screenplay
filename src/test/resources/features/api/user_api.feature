Feature: User API Tests

  Scenario: Get user by ID
    Given the API endpoint is "https://reqres.in/api/users"
    When I send a GET request with ID "2"
    Then the response status code should be 200
    And the response should contain user "Janet"