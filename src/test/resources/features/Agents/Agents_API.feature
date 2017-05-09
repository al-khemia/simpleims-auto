Feature: Agents API
  In order to manage agents info
  As a Company
  I want to get online status


Scenario: Login agent
  Given Agent set an authentication request
  When Agent sends a POST login request
  Then Response has status code 303

Scenario: Get currently logged in agent
  When I GET agent info
  Then Response has status code 200
  And Agent info is accurate

Scenario: Get complete list of active agents
  When I GET agents list
  Then Response has status code 200
  And username should be <username>
      | benj     |
      | jwilliams|
      | sgoresh  |
      | linfante |
#      | jacksmith|


#Scenario: Get information for specific agent
#  When I GET "linfante" agent info
#  Then Response has status code 200
#  And username should be "linfante"
#  And fullname should be "Lina Infante"
#  And Email should be "lina.infante@endava.com"
#  And Active should be "true"

#Scenario: Get incidents associated with agent
#Scenario: Logout agent