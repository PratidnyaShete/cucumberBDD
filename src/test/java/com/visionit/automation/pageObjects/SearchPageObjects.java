package com.visionit.automation.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class SearchPageObjects {

	private static final Logger logger = LogManager.getLogger(CmnPageObjects.class);
	WebDriver driver;
	Scenario scn;
	
	//Constructor
	public SearchPageObjects(WebDriver driver, Scenario scn) {
		this.driver = driver;
		this.scn = scn;
	}
		
	//Locators
	//private By searchBoxElement = By.id("twotabsearchtextbox");
	private By listOfProductElement = By.xpath("//div[@class='sg-col-inner']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span");
	
	//Search Page Methods
	public void validateSearchPageTitle() {
		// Wait for title
		WebDriverWait webDriverWait1 = new WebDriverWait(driver, 20);
		webDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));

		// Assertion for Page Title
		Assert.assertEquals("Page Title validation", "Amazon.in : Laptop", driver.getTitle());
		scn.log("Page title validation successfull: " + driver.getTitle());
	}
	
	public void clickOnFirstProduct() {
		 List<WebElement> listOfProducts = driver.findElements(listOfProductElement);
	     scn.log("Number of products searched: " + listOfProducts.size());

	     //But as this step asks click on any link, we can choose to click on Index 0 of the list
	     listOfProducts.get(0).click();
	     scn.log("Click on the first Link in the List. Link Text: " + listOfProducts.get(0).getText());
	}
	
}
