Feature: Search Portable Charger on Amazon

  Scenario: Search Portable Charger on Amazon
    Given User navigate to Amazon home page
    When User enter "Portable Charger" into the search bar
    And They enter the minimum price to $20 and the maximum price to $50
    And They clicks on the Go button
    And They select "Apple iPhone" device compatibility checkbox
    Then User see at list one product that has a price of $20 to $50

