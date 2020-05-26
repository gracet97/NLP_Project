package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//Tests for Team section of website
public class team {
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
	    graceLinkedInLink(driver);
	    //qubTwitterLink(driver);
	    //qubFacebookLink(driver); 
	    //kainosTwitterLink(driver); 
	    //kainosFacebookLink(driver);
	}


	//Method to test link to my LinkedIn works as expected
	//by opening the web address in a new tab
	public static void graceLinkedInLink(WebDriver driver) 
	{
		//Create an action using the driver
		Actions action = new Actions(driver);

		//Initialising web element of team members
		WebElement teamMember = driver.findElement(By.id("team1"));

		//The actions moves to the team member item, then finds and clicks on a social media link item
		action.moveToElement(teamMember).moveToElement(driver.findElement(By.id("graceLinkedIn"))).click().build().perform();
	}
	

	//Method to test link to QUB Twitter works as expected
	//by opening the web address in a new tab
	public static void qubTwitterLink(WebDriver driver) 
	{
	    //Initialising web element of link
	    WebElement qubTwitterLink = driver.findElement(By.id("qubTwitter"));

	    //Clicking the link
	    qubTwitterLink.click();
	}

	//Method to test link to QUB Facebook works as expected
	//by opening the web address in a new tab
	public static void qubFacebookLink(WebDriver driver) 
	{
	    //Initialising web element of link
	    WebElement qubFacebookLink = driver.findElement(By.id("qubFacebook"));

	    //Clicking the link
	    qubFacebookLink.click();
	}
	
	//Method to test link to Kainos Twitter works as expected
	//by opening the web address in a new tab
	public static void kainosTwitterLink(WebDriver driver) 
	{
	    //Initialising web element of link
	    WebElement kainosTwitterLink = driver.findElement(By.id("kainosTwitter"));

	    //Clicking the link
	    kainosTwitterLink.click();
	}

	//Method to test link to Kainos Facebook works as expected
	//by opening the web address in a new tab
	public static void kainosFacebookLink(WebDriver driver) 
	{
	    //Initialising web element of link
	    WebElement kainosFacebookLink = driver.findElement(By.id("kainosFacebook"));
		 
	    //Clicking the link
	    kainosFacebookLink.click();
	}
}
