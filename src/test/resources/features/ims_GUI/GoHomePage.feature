Feature: Go to Home Page
  In order to have access to ims
  As an Agent
  I want to go to Home Page

Scenario: Go to Home page
Given the user is on the ims home page
When the user looks up the definition of the word 'pear'
Then they should see the definition 'An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.'
