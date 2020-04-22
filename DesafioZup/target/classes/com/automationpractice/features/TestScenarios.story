Scenario: User should be able to search for a product based on category and subcategory
Given I navigate to Home page
When I navigate to Category Livros and Sub Category Economia
Then I should find product Livro - Casais inteligentes enriquecem juntos


Scenario: User should receive a message when searching for an invalid product
Given I navigate to Home page
When I search for a product 1111111111111111
Then the search should display message Sua busca por 1111111111111111 nao encontrou resultado algum :(


Scenario: User should be able to include a product in the shopping cart
Given I navigate to Home page
When I search for product and add it to the shopping cart Garmin Forerunner 235 010-03717-49
Then product Garmin Forerunner 235 010-03717-49 with price 1.999,00 should be displayed in the shopping cart