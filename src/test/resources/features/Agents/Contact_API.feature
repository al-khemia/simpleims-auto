Feature: Contacts API
  In order to manage contacts info
  As an Agent
  I want to manage contacts info

Scenario: Update an existing contact
  When Agent sends a POST to update contact
  Then Response has status code 303

  Scenario: Delete an existing contact
    When Agent sends a DELETE to delete contact
    Then Response has status code 303


#https://www.udemy.com/rest-api-testing-with-rest-assuredpostman-part1/learn/v4/t/lecture/6659756?start=0