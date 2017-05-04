Feature: Login Agent
  In order to access to ims
  As an Agent
  I want to login

Scenario: Login into Simple IMS
Given agent is on the ims login page
When agent enter credentials
Then agent should see the incidents page
