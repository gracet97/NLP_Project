package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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
	    
	    //Social links
	    graceLinkedInLink(driver);
	    //qubTwitterLink(driver);
	    //qubFacebookLink(driver); 
	    //kainosTwitterLink(driver); 
	    //kainosFacebookLink(driver);
	}
	
	public static void navigateToTeam(WebDriver driver) 
	{	
		Actions action = new Actions(driver);
		
		WebElement aboutQueens = driver.findElement(By.xpath("//a[@href='#why-us']"));
		
		action.moveToElement(aboutQueens).moveToElement(driver.findElement(By.xpath("//a[@href='#team']"))).click().build().perform();
	}
	
	//
	
	public static void graceLinkedInLink(WebDriver driver) 
	{
		//navigateToTeam(driver);
		
		Actions action = new Actions(driver);
		
		WebElement teamMember = driver.findElement(By.id("team1"));
		
		action.moveToElement(teamMember).moveToElement(driver.findElement(By.id("graceLinkedIn"))).click().build().perform();
	}
	
	//
	
	public static void qubTwitterLink(WebDriver driver) 
	{
	    //Initialising web element of link
	    WebElement qubTwitterLink = driver.findElement(By.id("qubTwitter"));

	    //Clicking the link
	    qubTwitterLink.click();
	}
	
	public static void qubFacebookLink(WebDriver driver) 
	{
	    //Initialising web element of link
	    WebElement qubFacebookLink = driver.findElement(By.id("qubFacebook"));

	    //Clicking the link
	    qubFacebookLink.click();
	}
	
	//
	
	public static void kainosTwitterLink(WebDriver driver) 
	{
	    //Initialising web element of link
	    WebElement kainosTwitterLink = driver.findElement(By.id("kainosTwitter"));

	    //Clicking the link
	    kainosTwitterLink.click();
	}
	
	public static void kainosFacebookLink(WebDriver driver) 
	{
	    //Initialising web element of link
	    WebElement kainosFacebookLink = driver.findElement(By.id("kainosFacebook"));
		 
	    //Clicking the link
	    kainosFacebookLink.click();
	}
}
