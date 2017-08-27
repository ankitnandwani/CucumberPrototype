Feature: DuckDuckGo Search

  Scenario: Verify Valid Search
    Given I'm at duckduckgo homepage
    When I enter cucumber in search bar
    Then Search results should be displayed


  Scenario: Verify text on page
    Given I'm at duckduckgo homepage
    Then We don’t store your personal information. Ever. text should be displayed
    And Our privacy policy is simple: we don’t collect or share any of your personal information. text should be displayed
    And We don’t follow you around with ads. text should be displayed
    And We don’t store your search history. We therefore have nothing to sell to advertisers that track you across the internet. text should be displayed
    And We don’t track you in or out of private browsing mode. text should be displayed
    And Other search engines track your searches even when you’re in private browsing mode. We don’t track you — period. text should be displayed
    And Switch to DuckDuckGo and take back your privacy! text should be displayed
    And No tracking, no ad targeting, just searching. text should be displayed