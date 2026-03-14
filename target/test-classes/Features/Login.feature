Feature: Login

Scenario: Successful Login with Valid Credentials

  Given User Launch Chrome browser
  When User opens URL "https://admin-demo.nopcommerce.com/login?returnUrl=%2Fadmin%2F"
  And User enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then Page Title should be "Dashboard / nopCommerce administration"
  When User click on Log out link
  Then Page Title must be "nopCommerce demo store. Login"
  And close browser
  