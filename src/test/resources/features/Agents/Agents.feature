Feature:
  In order to manage agents info
  As a Company
  I want to get online status

Scenario: Get currently logged in agent
Given I login agent
  When I GET agent info
  Then Response has a 200 status
