package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class contact {
	public static void main(String[] args) {
		//Creating a driver object referencing WebDriver interface
	    WebDriver driver;
	         
	    //Setting webdriver.gecko.driver property
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Grace\\Documents\\geckodriver.exe");
	         
	    //Instantiating driver object
	    driver = new FirefoxDriver();
	    
	    //Opening my web page
	    driver.get("http://127.0.0.1:5000/");
	    
	    //Email link
	    //emailLink(driver); //PASSED
	    
	    //Social links
	    //qubTwitterLink2(driver); //PASSED
	    //qubFacebookLink2(driver); //PASSED
	    //qubInstagramLink(driver); //PASSED
	    //myLinkedInLink(driver); //PASSED
	}
	
	public static void emailLink(WebDriver driver) 
	{
		//Initialising web element of about button
	    WebElement emailLink = driver.findElement(By.id("emailLink"));
	    
	    //Clicking the button
	    emailLink.click();
	}

	public static void qubTwitterLink2(WebDriver driver) 
	{
	    //Initialising web element of the link 
	    WebElement qubTwitterLink2 = driver.findElement(By.id("qubTwitter2"));
		 
	    //Clicking the link
	    qubTwitterLink2.click();
	}
	
	public static void qubFacebookLink2(WebDriver driver) 
	{
	    //Initialising web element of the link 
	    WebElement qubFacebookLink2 = driver.findElement(By.id("qubFacebook2"));
		 
	    //Clicking the link
	    qubFacebookLink2.click();
	}
	
	public static void qubInstagramLink(WebDriver driver) 
	{
	    //Initialising web element of the link
	    WebElement qubInstagramLink = driver.findElement(By.id("qubInstagram"));
		 
	    //Clicking the link
	    qubInstagramLink.click();
	}
	
	public static void myLinkedInLink(WebDriver driver) 
	{
	    //Initialising web element of the link
	    WebElement myLinkedInLink = driver.findElement(By.id("myLinkedIn"));
		 
	    //Clicking the link
	    myLinkedInLink.click();
	}	
}
