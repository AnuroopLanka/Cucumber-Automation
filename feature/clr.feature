Feature: Cleartrip Flight Search 
  

  Scenario: Enter details to book flight
    Given user is on "https://www.cleartrip.com/" website
    When user enter details departure "del" and arrival "maa" and clicks on search button
    Then goes to next page to view search results
    
    Scenario: Book a flight
    Given user is on search results page
    When user clicks on book button
    Then navigates to next page to view flight details
    
    Scenario: Capture journey details
    Given user is on flight iternary page
    When user captures flight details
    Then prints and quits