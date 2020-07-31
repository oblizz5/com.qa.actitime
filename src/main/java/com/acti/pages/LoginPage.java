package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
 * Tester Name: Obed
 * Date Created:07/29/2020
 * Approved By:Shantosh
 */

public class LoginPage extends DriverScript {
	@FindBy(id="username")WebElement usernameTextbox;
	@FindBy(name="pwd")WebElement passwordTextbox;
	@FindBy(id="loginButton")WebElement loginButton;
	@FindBy(xpath="//div[@class='atLogoImg']")WebElement actiLogo;
	
 //...........................................................................................//
	
	public LoginPage() 
	{
       PageFactory.initElements(driver, this);
       
	}

//.............................................................................................//
	
	public void validateLoginFunction(String username, String password)
	{
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		loginButton.clear();
		
	}
	
	  public boolean verifyactiLogo()
	{
		return actiLogo.isDisplayed();
	}
      public String verifyLoginPageTitle()
      {
    	  return driver.getTitle();
      }

}

