Feature: To perform lead actions

Background: 
Given Open the chrome browser
And Load the application url  'http://leaftaps.com/opentaps/'

 
Scenario Outline: TC004_To Merge Lead
Given Enter the username as <username>
And Enter the password as <password>
When Click on the login button
When Click on 'CRM' link
Then Navigate to 'CRM' page
When Click on 'Leads' link
When Click on 'Merge Leads' link
When Click on Lookup icon 
Given Enter the first name in Lead as <firstName>
When Click on Find Leads link in the lead
Then Get the first LeadID 
Then Switch to windowhandle0
When Click on Lookup icon in lead
Given Enter the first name in Lead as <firstName>
When Click on 'Find Leads' link
When Click on  first LeadId 
When Click on 'Merge' link
When Click on 'Find Leads' link
Given Enter the LeadID as 'LeadID'
When Click on 'Find Leads' link
Then Get the record and validate
Examples:
 |username|password|firstName|
 |'DemoSalesManager'|'crmsfa'|'Sathya'|
  

Scenario Outline:TC001_login with positive credential
Given Enter the username as <username>
And Enter the password as <password>
When Click on the login button
Then Homepage should be displayed
Examples:
 |username|password|
 |'DemoSalesManager'|'crmsfa'|
  
  
Scenario Outline: TC002_to create lead
Given Enter the username as <username>
And Enter the password as <password>
When Click on the login button
When Click on 'CRM' link
Then Navigate to 'CRM' page
When Click on 'Leads' link
Then Navigate to 'Leads' page
When Click on 'Create Lead' link
Then Navigate to 'Create Lead' page
Given Enter the company name as <companyName>
And Enter the first name as <firstName>
And Enter the last name as <lastName>
Given Enter the phone number as <phoneNumber>
When Click on Submit button
Examples:
 |username|password|companyName|firstName|lastName|phoneNumber|
 |'DemoSalesManager'|'crmsfa'| 'testleaf'|'sathya'|'r'|'99'|
 
Scenario Outline: TC003_To edit lead
Given Enter the username as <username>
And Enter the password as <password>
When Click on the login button
When Click on 'CRM' link
Then Navigate to 'CRM' page
When Click on 'Leads' link
When Click on 'Find Leads' link
Given Enter the first name as <editFirstName> in edit
When Click on Find Leads link in the lead
Then Get the first name 'firstname'
When Click on 'Edit' link
When Clear the company name in the updated form
Given Enter the new company name as <newCompanyName>
When Click on update form
Then Get the 'companyname' updated and validate
Examples:
 |username|password|editFirstName|newCompanyName|
 |'DemoSalesManager'|'crmsfa'|'sathya'|'newtestleaf'|

Scenario Outline: TC005_To Delete Lead
Given Enter the username as <username>
And Enter the password as <password>
When Click on the login button
When Click on 'CRM' link
Then Navigate to 'CRM' page
When Click on 'Leads' link
When Click on 'Find Leads' link
When Click on Phone tab
Given Enter the delete phone number as <deletephoneNumber>
When Click on Find Leads link in the lead
Then Get the first Lead ID
When Click on 'Delete' link
When Click on 'Find Leads' link
Given Enter the LeadID as 'LeadID'
When Click on Find Leads link in the lead
Then Get the record and validate
Examples:
 |username|password|deletephoneNumber|
 |'DemoSalesManager'|'crmsfa'|'99'|
 Scenario Outline: TC006_To Duplicate Lead
Given Enter the username as <username>
And Enter the password as <password>
When Click on the login button
When Click on 'CRM' link
Then Navigate to 'CRM' page
When Click on 'Leads' link
When Click on 'Find Leads' link
When Click on Email
Given Enter the Emailaddress as <emailAddres>
When Click on Find Leads link in the lead
Then Get the first Lead ID in duplicate
When Click on 'Duplicate Lead' link
Then Get the record and validate duplicate
Examples:
 |username|password|emailAddres|
 |'DemoSalesManager'|'crmsfa'|'testleaf@gmail.com'|
 
  