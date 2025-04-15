Feature:  Deichmann - Start search

  @main
  Scenario: Validate Successful Search - Unique Data
    Given I access the homepage
    When I click the search bar
    And I enter a search term
    And I select a category
    And I click on the first suggestion
    Then I should be presented with the search result page

  Scenario: Validate Successful Search - Specific Data
    Given I access the homepage
    When I click the search bar
    And I enter a specific search term "Adilette"
    And I select a specific category women
    And I click on the first suggestion
    Then I should be presented with the search result page

    Scenario: Validate Successful Search - Redirect To Brand Page
      Given I access the homepage
      When I click the search bar
      And I enter a specific search term "Adidas"
      And I submit the search
      Then I should be presented with the brand page of "Adidas"