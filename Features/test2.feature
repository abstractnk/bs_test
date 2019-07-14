Feature: Positive testcases on login page of Application
 
Scenario Outline: Verification using valid credentials
Given User open Webapp
Given If page title is "Please sign in"
And user enters username "<username>"
And user enters password "<password>"
And user clicks on submit
Then check for login validation message
Then user closes the browser

Examples:

|username    |password      |		
|nanda       |qwerty        |		
|jibin       |qwerty        |		
|kishore     |qwerty        |