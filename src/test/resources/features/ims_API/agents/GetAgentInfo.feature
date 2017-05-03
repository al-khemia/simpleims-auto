Feature:
As an Agent
I want to get agent info
So that I get the currently logged agent

Scenario: Get currently logged in agent
Given I login agent
  When I GET agent info
  Then Response has a 200 status
