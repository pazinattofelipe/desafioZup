package com.automationpractice.steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automationpractice.pages.CategoriesPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ProductPage;
import com.automationpractice.pages.SearchResultPage;
import com.automationpractice.pages.ShoppingCartPage;
import com.automationpractice.utilities.WebUtilitiesMethods;

public class WebStepsClass extends Steps {

	private static WebDriver driver;

	@BeforeScenario()
	public void beforeScenario() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver","test/java/chromedriver.exe");		
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	}
	
	@Given("I navigate to Home page")
	public void navigateToHome() {
		driver.get("https://www.magazineluiza.com.br");
	}
	
	@When("I navigate to Category $categoryChosen and Sub Category $subcategory")
	public void navigateToCategory(@Named("categoryChosen") String categoryChosen,
									@Named("subcategory") String subcategory) {
		HomePage homePage = new HomePage(driver);
		homePage.clickLeftMenu();
		
		CategoriesPage categoriesPage = new CategoriesPage(driver, categoryChosen, subcategory);
		categoriesPage.clickCategory();
		categoriesPage.clickSubCategory();
	}
	
	@Then("I should find product $productName")
	public void searchForProductPages(@Named("productName") String productName) {
		CategoriesPage categoriesPage = new CategoriesPage(driver);
		Boolean isProductFound = categoriesPage.searchForProduct(productName);
		assertTrue("Product has not been found", isProductFound);
	}
	
	@When("I search for product and add it to the shopping cart $productName")
	public void searchForProductAndAddCart(@Named("productName") String productName) {
		HomePage homePage = new HomePage(driver);
		homePage.searchProductByName(productName);
		
		SearchResultPage searchResultPage = new SearchResultPage(driver, productName);
		searchResultPage.clickChosenProduct();
		
		ProductPage productPage = new ProductPage(driver);
		productPage.clickAddToShoppingCartButton();
	}
	
	@When("I search for a product $productName")
	public void searchForProductName(@Named("productName") String productName) {
		HomePage homePage = new HomePage(driver);
		homePage.searchProductByName(productName);
	}
	
	@Then("product $productName with price $productPrice should be displayed in the shopping cart")
	public void validateProductShoppingCart(@Named("productName") String productName,
										@Named("productPrice") String productPrice) {
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver, productName, productPrice);
		assertTrue("Product name not displayed in the shopping cart. Expected: " + productName,
							shoppingCartPage.returnProductNameDisplayingInShoppingCart());
		assertTrue("Product price not displayed in the shopping cart. Expected: " + productPrice,
				shoppingCartPage.returnProductPriceDisplayinginShoppingCart());
	}
	
	@Then("the search should display message $searchResultMessage")
	public void validateSearchResultMessage(@Named("searchResultMessage") String searchResultMessage) {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		
		assertTrue((WebUtilitiesMethods.compareStringAccent(
							searchResultPage.returnSearchResultMessage(),
							searchResultMessage)
							)==0);
	}
	
	@AfterStory
	public void afterStory() {
		driver.quit();
	}

}
