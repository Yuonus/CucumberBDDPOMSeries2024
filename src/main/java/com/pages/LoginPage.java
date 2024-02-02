package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
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
	
	// 1. By Locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By login = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	
	// 2. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 3. Page Actions/methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}	
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(login).click();
	}
	
	public AccountsPage doLogin (String un, String pwd) {
		System.out.println("Login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		return new AccountsPage(driver);
	}
	
	/*	Any page that lands you to another page is responsible to give you the object of the landed page.
	 *  This principle is called zig zag pattern
	 * 
	 */
	
	
	

}
