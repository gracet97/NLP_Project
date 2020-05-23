package launchingBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
	public static void main(String[] args) {
		//Creating a driver object referencing WebDriver interface
	    WebDriver driver;
	         
	    //Setting webdriver.gecko.driver property
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Grace\\Documents\\geckodriver.exe");
	         
	    //Instantiating driver object and launching browser
	    driver = new FirefoxDriver();
	    
	    //Using get() method to open google web page
	    driver.get("https://www.google.com");
	         
	    //Closing the browser
	    driver.quit();
	    } 
	}