package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//Tests for About Queen's section of website
public class aboutQub {
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
	    qubLink(driver); //PASSED
	}
		
	//Method to test link to the Queen's website works as expected
	//by opening the web address in a new tab
	public static void qubLink(WebDriver driver) 
	{
		//Initialising web element of the link to the qub website
		WebElement qubLink = driver.findElement(By.xpath("//a[@href='https://www.qub.ac.uk/Study/Why-Study-at-Queens/rankings-and-reputation/']"));
		 
	    //Clicking the link
	    qubLink.click();
	}
}
