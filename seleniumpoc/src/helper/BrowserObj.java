/**
 * 
 */
package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Susmitha
 *
 */
public class BrowserObj {
	
	static	WebDriver	driver;

	public	static	WebDriver	startBrowser(String	BrowserName,String	url)
	{
		if(BrowserName.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new	ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		else	if(BrowserName.equals("IE"))
		{
		driver=new	EdgeDriver();	
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return	driver;
	}
	
	

}
