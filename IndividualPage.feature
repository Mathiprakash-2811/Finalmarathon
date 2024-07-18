Feature: SalesForce Application Testing

Scenario: Create Individual Testing

Given Enter the username as gokul.sekar@testleaf.com
And Enter the password as Leaf$123
When Click on Login Button
And Click on AppLauncher
And Click on ViewAll
And Click on Individuals
And Click New Button
And Enter the LastName
And Click Save
Then Verify The Name

Scenario: Edit Individual Testing
Given Enter the username as gokul.sekar@testleaf.com
And Enter the password as Leaf$123
When Click on Login Button
And Click on AppLauncher
And Click on ViewAll
And Click on Individuals
And Enter LastNAme in SearchBox
And Click on role button
And Click Edit Icon
And click on selectoption
And click on Mr
And click on firstname
And click on save
Then Verify