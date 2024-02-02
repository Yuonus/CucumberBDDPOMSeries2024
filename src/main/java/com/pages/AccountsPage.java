package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	/*	NOTE	NOTE 	NOTE
	 * Inside the page classes we will have to do these three following things
	 * 		1: We have to maintain the By Locators.  Object Repositories
	 * 		2: We have to maintain one Constructor
	 * 		3: We have to create the page actions/methods 
	 * The encapsulation concept will be used here, as the Locators will be private, and the page actions will be public.
	 * 
	 * Every class will have its own private driver
	 */
	
	private WebDriver driver;
	
	// By locators: --> Object Repository; locators Repository
	private By accuntSections = By.cssSelector("div#content h2");

	// Page Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page actions
	public String getAccountsPageTitle(){
		return driver.getTitle();
	} 
	
	public int getAccountsSectionCount() {
		return driver.findElements(accuntSections).size();
	}
	
	public List<String> getAccountsSectionsList() {
		
		List<String> accountsList = new ArrayList<>(); // empty arraylist to store the accounts header list in it. like: Newsletter, My Affiliates ...
		List<WebElement> accountsHeaderList = driver.findElements(accuntSections);
		
		for (WebElement e : accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		
		return accountsList;
	}

}
