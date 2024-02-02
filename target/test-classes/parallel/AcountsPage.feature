Feature: Account Page Feature

  Background: 
    Given user has already logged into application
      | username         |  | password      |
      | samsam@gmail.com |  | Automation123 |

  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My Account"

  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      | My Account           |
      | My Orders            |
      | My Affiliate Account |
      | Newsletter            |
    And accounts section count should be 4
