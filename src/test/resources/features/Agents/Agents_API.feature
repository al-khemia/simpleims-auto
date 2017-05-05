Feature:
  In order to manage agents info
  As a Company
  I want to get online status


Scenario: Login agent
  Given Agent set an authentication request
  When Agent sends a POST login request
  Then Response has status code 303

Scenario: Get currently logged in agent
  Given Agent set an authentication request
  When Agent sends a POST login request
  Then Response has status code 303
  When I GET agent info
  Then Response has status code 200
  And Email should be "jack@bigsoftware.com"

#
#Scenario: Get complete list of active agents
#Scenario: Get information for specific agent
#Scenario: Get incidents associated with agent
#Scenario: Logout agent