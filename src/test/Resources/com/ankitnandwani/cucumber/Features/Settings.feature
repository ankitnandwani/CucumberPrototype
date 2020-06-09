Feature: Verify Settings Page

  Verify functionality of DuckDuckGo Settings page


  Scenario: Verify Safe Search Dropdown
    Given I'm at duckduckgo settings page
    When I toggle safe search dropdown and click save
    Then dropdown should be changed successfully