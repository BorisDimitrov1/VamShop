Feature: Vam Shop - Contacts

  @socials @contacts @regression
  Scenario: Verify contacts and socials networks
    When I navigate to the e-shop
    Then Verify the phone in the header is "+1-800-123-45-67"
    And Verify the Twitter link in the header leads to "http://twitter.com/your-account"
    And Verify the Facebook link in the header leads to "http://facebook.com/your-account"
    And Verify the Contact us link in the header leads to "/page/contact-us.html"


  @categories @regression
  Scenario: Verify Categories presented
    When I navigate to the e-shop
    And Click on the categories dropdown
    Then Verify there are 4 categories presented in the Categories Dropdown
    And Verify the Categories presented are "Smart Watches,Notebooks,Smartphones,Tablets"

  @search @regression
  Scenario: Search for specific item
    When I navigate to the e-shop
    And Populate search field with "Samsung Galaxy s4"
    And Click the search button
    Then Verify 1 result is presented in the results page
    And Verify the title of the presented result is "Samsung GALAXY S4"

  @payment @regression
  Scenario: Verify available payment methods
    When I navigate to the e-shop
    And Populate search field with "Samsung Galaxy s4"
    And Click the search button
    And Click on Buy button for the first presented result
    And CLick Checkout button
    Then Verify there are 6 payment methods presented
    Then Verify the Payment Methods presented are "In-store Pickup,Money Order Check,Paypal,Credit Card,Authorize.Net,Google Checkout"

  @sale @regression
  Scenario: Buy a single item
    When I navigate to the e-shop
    And Populate search field with "Samsung Galaxy s4"
    And Click the search button
    And Click on Buy button for the first presented result
    Then Verify "1" item is added to the cart in the header
    And CLick Checkout button
    And Populate name field in checkout page with "Boris"
    And Populate email field in checkout page with "b.dimitrov1@abv.bg"
    And Populate phone field in checkout page with "0884045188"
    And Select In-store pickup from the payment methods in checkout page
    And Click on Continue button in checkout page
    And Verify the total amount is "$ 399"
    And Click confirm order button
    Then Verify thank you label have text "Thank You"

  @admin @regression
  Scenario: Login as admin
    When I navigate to the e-shop admin login
    And Populate the username field with correct username
    And Populate the password field with correct password
    And Click login button
    Then Verify user is redirected to "/admin/admin_top/"

  @admin @sale @regression
  Scenario: Make a sale and verify the admin panel
    When I navigate to the e-shop
    And Populate search field with "Samsung Galaxy s4"
    And Click the search button
    And Click on Buy button for the first presented result
    Then Verify "1" item is added to the cart in the header
    And CLick Checkout button
    And Populate name field in checkout page with "Boris"
    And Populate email field in checkout page with "b.dimitrov1@abv.bg"
    And Populate phone field in checkout page with "0884045188"
    And Select In-store pickup from the payment methods in checkout page
    And Click on Continue button in checkout page
    And Verify the total amount is "$ 399"
    And Click confirm order button
    Then Verify thank you label have text "Thank You"
    When I navigate to the e-shop admin login
    And Populate the username field with correct username
    And Populate the password field with correct password
    And Click login button
    Then Verify user is redirected to "/admin/admin_top/"
    And Verify order with customer name "Boris" is presented

    @contactUs @regression
    Scenario: Send contacts us form and verify it in the admin panel
      When I navigate to the e-shop
      And Click Contact us
      And Populate name field in contact us page with "Boris"
      And Populate email field in contact us page with "b.dimitrov1@abv.bg"
      And Populate message field in contacts us page with "Some message"
      And Click send button in contact us page
      When I navigate to the e-shop admin login
      And Populate the username field with correct username
      And Populate the password field with correct password
      And Click login button
      Then Verify user is redirected to "/admin/admin_top/"
      And Click contact us tab in admin panel
      And Verify message with customer name "Boris" is presented

