Feature: DuckDuckGo Search

  @test @3284905
  Scenario: Verify Valid Search
    Given I'm at duckduckgo homepage
    When I enter cucumber in search bar
    Then Search results should be displayed

  @test @3284906
  Scenario: Verify text on page
    Given I'm at duckduckgo homepage
    Then W don’t store your personal information. Ever. text should be displayed
    And Our privacy policy is simple: we don’t collect or share any of your personal information. text should be displayed