Feature: User
  As an admin
  I want to see list of user
  So that I can create new user

  Scenario: GET - As admin I have be able to get detail user
    Given I set GET api endpoints
    When I send GET HTTP request
    Then I receive valid HTTP response code 200
    And I receive valid data for detail user

#  Scenario: GET - As admin I have be disable to get detail user
#    Given I set invalid GET api endpoints
#    When I send invalid GET HTTP request
#    Then I don't receive valid HTTP response code 404
#    And I don't receive valid data for detail user