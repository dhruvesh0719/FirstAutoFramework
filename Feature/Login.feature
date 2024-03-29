Feature : Login

  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User entre email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / noCommerce administration"
    When User click on log out link
    Then Page title should be "Your store. Login"
    And close browser
