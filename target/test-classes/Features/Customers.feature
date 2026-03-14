Feature: Customers

Scenario: Add a new Customer
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    When Click on Login
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
