Feature: compute tax

  Scenario: compute product exempt from tax
    Given a list of product
      | familyProduct | label             | priceBeforeTax | isImported |
      | BOOK          | livre             | 12.49          | false      |
      | OTHER         | CD musical        | 14.99          | false      |
      | FOOD          | barre de chocolat | 0.85           | false      |
    When print bill
    Then return products with price include tax
      | familyProduct | label             | priceIncludeTax |
      | BOOK          | livre             | 12.49           |
      | OTHER         | CD musical        | 16.49           |
      | FOOD          | barre de chocolat | 0.85            |
    And total price is 29.83 and tax amount is 1.50


  Scenario: compute product imported tax
    Given a list of product
      | familyProduct | label                       | priceBeforeTax | isImported |
      | FOOD          | boîte de chocolats importée | 10.00          | true       |
      | OTHER         | flacon de parfum importé    | 47.50          | true       |
    When print bill
    Then return products with price include tax
      | familyProduct | label                       | priceIncludeTax |
      | FOOD          | boîte de chocolats importée | 10.50           |
      | OTHER         | flacon de parfum importé    | 54.65           |
    And total price is 65.15 and tax amount is 7.65

  Scenario: compute product imported and product exempt from tax
    Given a list of product
      | familyProduct | label                               | priceBeforeTax | isImported |
      | OTHER         | flacon de parfum importé            | 27.99          | true       |
      | OTHER         | flacon de parfum                    | 18.99          | false      |
      | MEDICINE      | boîte de pilules contre la migraine | 9.75           | false      |
      | FOOD          | boîte de chocolats importée         | 11.25          | true       |
    When print bill
    Then return products with price include tax
      | familyProduct | label                               | priceIncludeTax | isImported |
      | OTHER         | flacon de parfum importé            | 32.19          | true       |
      | OTHER         | flacon de parfum                    | 20.89          | false      |
      | MEDICINE      | boîte de pilules contre la migraine | 9.75           | false      |
      | FOOD          | boîte de chocolats importée         | 11.85          | true       |
    And total price is 74.68 and tax amount is 6.70