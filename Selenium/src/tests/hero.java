package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class hero {
	public static void main(String[] args) {
		//Creating a driver object referencing WebDriver interface
	    WebDriver driver;
	         
	    //Setting webdriver.gecko.driver property
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Grace\\Documents\\geckodriver.exe");
	         
	    //Instantiating driver object
	    driver = new FirefoxDriver();
	    
	    //Opening my web page
	    driver.get("http://127.0.0.1:5000/");

	    //getStartedButton(driver); //PASSED
	}
	
	public static void getStartedButton(WebDriver driver) 
	{
	    //Initialising web element of button
	    WebElement getStartedButton = driver.findElement(By.id("get-started"));
	 
	    //Clicking the button
	    getStartedButton.click();
	}
}
