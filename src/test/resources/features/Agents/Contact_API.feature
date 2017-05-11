Feature: Contacts API
  In order to manage contacts info
  As an Agent
  I want to manage contacts info

Scenario: Get information for an specific contact
  Given I have a contact ID
  When Agent sends a POST
  Then Response has status code 200


