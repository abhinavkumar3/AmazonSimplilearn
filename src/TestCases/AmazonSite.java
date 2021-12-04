package TestCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;

public class AmazonSite {

	static WebDriver driver;
	static WebElement element;
	
	//Test data and Url
	static String url = "https://www.amazon.in/";
	static String searchItem = "Iphone";
	static String pageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	
	//Page Object
	static HomePage homePageObj = new HomePage();

	// Driver and navigation method
	public static void driverSetting(String url) throws Throwable{
		String projPath = System.getProperty("user.dir");
		String chromedriverPath = projPath + "/drivers/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromedriverPath);

		driver = new ChromeDriver();

		// Navigating and maximizing the window
		driver.get(url);
		driver.manage().window().maximize();		
	}

	public static void main(String[] args) throws Throwable{

		// Opening browser and navigating to Amazon site
		driverSetting(url);

		// Checking the Amazon page title is same or not
		if (driver.getTitle().equals(pageTitle))
			System.out.println("Page Titles are same");
		else
			System.out.println("Page Titles are not same");
		
		//Clearing the search box and entering the value
		element = driver.findElement(homePageObj.xpath_SearchBox);
		element.clear();
		element.sendKeys(searchItem);
		
		//Commenting enter one so we can use search button
		//element.sendKeys(searchItem + Keys.ENTER);
						
		//Clicking the Search Icon
		element = driver.findElement(homePageObj.xpath_SearchButton);
		element.click();

		driver.quit();
	}

}
