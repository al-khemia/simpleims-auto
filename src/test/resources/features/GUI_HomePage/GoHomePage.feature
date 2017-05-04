Feature: Go to Home Page
  In order to manage agents info
  As a Company
  I want to get online status

Scenario: Go to Home page
Given the user is on the ims home page
When the user looks up the definition of the word 'pear'
Then they should see the definition 'An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.'
