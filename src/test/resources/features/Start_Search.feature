Feature:  Deichmann - Start search

  @main
  Scenario: Validate Successful Search - Unique Data
    Given I access the homepage
    When I click the search bar
    And I enter a search term
    And I select a category
    And I click on the first suggestion
    Then I should be presented with the search result page