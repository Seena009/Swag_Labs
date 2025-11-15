Feature: Checking Swag Labs Login functionality

  Background:
  
   Given User navigates to "https://www.saucedemo.com/"

  @ValidLogin
  Scenario Outline: Verify user login with valid credentials
    When User enters username "standard_user"
    And User enters password "secret_sauce"
    And User clicks on login button
    Then User should be navigated to the Products page
    Given User enters the products and select the price "<product_sort_container>"
    Then user clicks on Twitter Facebook LinkedIn and user switch to fb and creates an account and switch back to parent tab
    Then user clicks on "Sauce Labs Fleece Jacket" and add to cart
    Then user verifies "Sauce Labs Fleece Jacket" product which has price "$49.99"
    Then user clicks on checkout and fill address "<FirstName>", "<LastName>", "<Zip/postal-code>"
    Then user clicks on finish and return back to homepage    
    Then user clicks on open menu and then About
    Then user clicks on product
     
  Examples:
  | product_sort_container | FirstName | LastName | Zip/postal-code |
  | Name (A to Z)          |  GoD X     | LeGit    | 56008452      |
 # | Name (Z to A)          | 
 # | Price (low to high)    | 
 # | Price (high to low)    | 

 
     

  @InvalidLogin
  Scenario Outline: Verify login with invalid credentials
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks on login button
    Then User should see error message "<error>"

    Examples:
      | username       | password     | error                                      |
      | wrong_user     | secret_sauce | Epic sadface: Username and password do not match |
      | standard_user  | wrong_pass   | Epic sadface: Username and password do not match |
      |                | secret_sauce | Epic sadface: Username is required         |
      | standard_user  |              | Epic sadface: Password is required         |

 

    
      
