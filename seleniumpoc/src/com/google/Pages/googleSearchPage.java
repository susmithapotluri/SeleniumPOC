/**
 * 
 */
package com.google.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Susmitha
 *
 */
public class googleSearchPage {
	WebDriver	driver;
	
	public	googleSearchPage(WebDriver	driverParam)
	{
		this.driver=driverParam;
		PageFactory.initElements(driverParam, this);
	}
	
	
	@FindBy(how=How.NAME,using="q")
	WebElement	googleSearchInput;
	
	@FindBy(how=How.XPATH,using="//body/div[1]/div[3]/form[1]/div[2]/div[1]/div[3]/center[1]/input[1]")
	WebElement	googleSearchButton;
	
	public	void	enterSearchKey(String	SearchKey)
	{
		googleSearchInput.clear();
		googleSearchInput.sendKeys(SearchKey);
		googleSearchInput.sendKeys(Keys.ENTER);
	}
	public	void	clickSearchButton()
	{
		googleSearchButton.click();
	}
}
