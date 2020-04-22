package com.automationpractice.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class CategoriesPage {
	private WebDriver driver;
	private String categoryChosen;
	private String subCategoryChosen;
	
	public CategoriesPage(WebDriver driver, String categoryChosen, String subCategoryChosen) {
		this.driver = driver;
		this.categoryChosen = categoryChosen;
		this.subCategoryChosen = subCategoryChosen;
	}
	
	public CategoriesPage(WebDriver driver) {
		this.driver = driver;
	}

	By lastPage = By.xpath("//*[@id='showcase']/ul[2]/li[9]/a");
	By nextPageButton = By.xpath("//*[@id='showcase']/ul[2]/li[10]");	
	
	public void clickCategory() {
		By categoriaPrincipal = By.xpath("//li/a[contains(text(),'" + categoryChosen + "')]");
		WebUtilitiesMethods.clickOnElement(driver, categoriaPrincipal);
	}
	
	public void clickSubCategory() {
		By subCategoriaPrincipal = By.xpath("//li/a[contains(text(),'" + subCategoryChosen + "')]");
		WebUtilitiesMethods.clickOnElement(driver, subCategoriaPrincipal);
	}

	public Boolean searchForProduct(String productName) {
		Boolean isProductFound = false;
		
		int numberOfPages = Integer.parseInt(WebUtilitiesMethods.returnTextElement(driver, lastPage));
		
		for (int i = 0; i < numberOfPages - 1; i++) {
			List<WebElement> listOfElementsFound =
					WebUtilitiesMethods.returnListElements(driver, By.xpath("//div/h3[contains(text(),'" + productName + "')]"));
			
			if(!listOfElementsFound.isEmpty()) {
				isProductFound = true;
				break;
			}
			
			clickNextButtonPage();
			
		}
		
		return isProductFound;
		
	}
	
	private void clickNextButtonPage() {
		WebUtilitiesMethods.clickOnElement(driver, nextPageButton);
	}
}
