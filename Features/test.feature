Feature: Reset functionality on login page of Application
 
Scenario: Verification of validation message username
Given Open Webapp
Given If page title is "Please sign in"
Given click on submit
Given check validation message for username


Given enter username "assdsd"
Given click on submit
Given check validation message for password
Given close browser