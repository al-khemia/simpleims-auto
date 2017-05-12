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
      | jacksmith|
      | benj     |
      | jwilliams|
      | sgoresh  |
      | linfante |

Scenario: Get information for specific agent
  When I GET specific agent info
  Then Response has status code 200
  And Specific agent info is accurate

Scenario: Get incidents associated with agent
  When I GET incidents associated with agent
  Then Response has status code 200
  And Number of incidents is correct

Scenario: Logout agent
  When I GET logout from simpleims
  Then Response has status code 303

  #Validate redirection
  #GET, POST, *PUT, *PATCH DELETE,
  #Ministry of testing


