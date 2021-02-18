/**
 * 
 */
package com.google.Testcases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.Pages.googleSearchPage;

import helper.BrowserObj;

/**
 * @author Susmitha
 *This	test	enters	a	searchkey	and	verifies	the	results	title	and	results	on	the	page.
 */
public class VerifyGoogleSearch {
SoftAssert softAssert = new SoftAssert();
	
	WebDriver driver= BrowserObj.startBrowser("Chrome", "https://www.google.com/");
	googleSearchPage ObjgoogleSearchPage;
	
	@Test(dataProvider="SearchData")
	public	void	verifytheSearchResults(String	SearchKey) throws InterruptedException
	{
		ObjgoogleSearchPage=new	googleSearchPage(driver);	
		ObjgoogleSearchPage.enterSearchKey(SearchKey);
		softAssert.assertTrue(driver.getTitle().contains(SearchKey));
		Reporter.log("search	results	page	title	is:"+driver.getTitle());
		/*	Collect	the	links	on	results	page	and	verify	if	each	contains	searchkey*/
		List<WebElement> links = driver.findElements(By.className("yuRUbf"));
		System.out.print(links.size());
		int i = 0;
		while	(i<links.size())
		{
			String	searchUrls=links.get(i).getText();
			searchUrls=searchUrls.toLowerCase();
			/*System.out.print(searchUrls);
			System.out.println();*/
				if	(!searchUrls.isBlank())
				{
				softAssert.assertTrue(searchUrls.contains(SearchKey), "Search	not	related	to"+SearchKey+"	"+searchUrls+"is	displayed	instead");
				Reporter.log(searchUrls+"	link	is	dsiplayed	in	search	results");
				}
			i=i+1;
		};
		softAssert.assertAll();
		
	}
	
@AfterTest
public	void	closeBrowser()
{
driver.quit();	
}
/*defines	Parametrized	testdata*/
	 @DataProvider(name="SearchData")
	    public Object[][] getDataFromDataprovider(){
	        
	        return new Object[][] {
	        	{"duck"},
	        	{"hen"}
	        };}
	
}
