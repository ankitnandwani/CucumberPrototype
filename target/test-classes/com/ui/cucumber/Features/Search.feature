Feature: DuckDuckGo Search

  @3318423 @sanity @regression
  Scenario: Verify Valid Search
    Given I'm at duckduckgo homepage
    When I enter cucumber in search bar
    Then Search results should be displayed

  @3318424 @regression
  Scenario: Verify text on page
    Given I'm at duckduckgo homepage
    Then We don’t store your personal information. Ever. text should be displayed
    And Our privacy policy is simple: we don’t collect or share any of your personal information. text should be displayed

  @3318425 @sanity @regression
  Scenario: Verify text on page 2
    Given I'm at duckduckgo homepage
    Then We don’t store your personal information. Ever. text should be displayed
    And Our privacy policy is simple: we don’t collect or share any of your personal information. text should be displayed