package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//Tests for About this Project section of website
public class about {
	public static void main(String[] args) {
		//Creating a driver object referencing WebDriver interface
	    WebDriver driver;
	         
	    //Setting webdriver.gecko.driver property
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Grace\\Documents\\geckodriver.exe");
	         
	    //Instantiating driver object
	    driver = new FirefoxDriver();
	    
	    //Opening my web page
	    driver.get("http://127.0.0.1:5000/");
	    
	    //Tests running
	    big5Link(driver); //PASSED
	}
	
	//Method to test link to the Big 5 quiz works as expected
	//by opening the web address in a new tab
	public static void big5Link(WebDriver driver) 
	{
		//Initialising web element of the link to the Big 5 quiz
	    WebElement big5Link = driver.findElement(By.xpath("//a[@href='https://www.truity.com/test/big-five-personality-test']"));
	 
	    //Clicking the link
	    big5Link.click();
	}
}
