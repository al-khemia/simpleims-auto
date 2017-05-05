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
  And Email should be "jack@bigsoftware.com"
  And Active should be "true"

  Scenario: Get complete list of active agents
#    Given the following users exists:
#      | name   | email              | twitter         |
#      | Jack  | aslak@cucumber.io  | @aslak_hellesoy |
#      | Ben | julien@cucumber.io | @jbpros         |
#      | Jil   | matt@cucumber.io   | @mattwynne      |
##      | Saron   | matt@cucumber.io   | @mattwynne      |
#  When I GET agents list
#  Then Then Response has status code 200
#  And


#Scenario: Get information for specific agent
#Scenario: Get incidents associated with agent
#Scenario: Logout agent