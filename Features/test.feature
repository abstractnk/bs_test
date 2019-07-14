Feature: Negative Testcases on login page of Application
 
Scenario: Verification of validation message username
Given User open Webapp
Given If page title is "Please sign in"
When user clicks on submit
Then check for validation message for username

Scenario: Verification of validation message password
When user enters username "nandas"
When user clicks on submit
Then check for validation message for password

Scenario: Verifiation of validation message usrname - 02
When user clears username field
And user enters password "qwaszx"
And user clicks on submit
Then check for validation message for username

Scenario: Verifiation of Bad credential message 
When user clears password field
And user enters username "nandas"
And user enters password "qwaszx"
And user clicks on submit
Then check for bad credentials message
Then user closes the browser