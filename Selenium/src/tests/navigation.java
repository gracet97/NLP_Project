package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navigation {
	public static void main(String[] args) {
		//Creating a driver object referencing WebDriver interface
	    WebDriver driver;
	         
	    //Setting webdriver.gecko.driver property
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Grace\\Documents\\geckodriver.exe");
	         
	    //Instantiating driver object
	    driver = new FirefoxDriver();
	    
	    //Opening my web page
	    driver.get("http://127.0.0.1:5000/");
	    
	    //navigateToHome(driver); //PASSED
	    //navigateToServices(driver); //PASSED
	    //navigateToSentimentAnalysis(driver); //PASSED
	    //navigateToEntityAnalysis(driver); //PASSED
	    //navigateToPersonalityAnalysis(driver); //PASSED
	    //navigateToAboutTheProduct(driver); //PASSED
	    //navigateToAboutThisProject(driver); //PASSED
		//navigateToTestimonials(driver); //PASSED
	    //navigateToAboutUs(driver); //PASSED
		//navigateToAboutQueens(driver); //PASSED
		//navigateToTeam(driver); //PASSED
		//navigateToFaq(driver); //PASSED
		//navigateToContact(driver); //PASSED
	}
	
	public static void navigateToHome(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement home = driver.findElement(By.xpath("//a[@href='/']"));
	 
	    //Clicking the button
	    home.click();
	}
	
	public static void navigateToServices(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement services = driver.findElement(By.xpath("//a[@href='#services']"));
	 
	    //Clicking the button
	    services.click();
	}
	
	public static void navigateToSentimentAnalysis(WebDriver driver) 
	{	
		Actions action = new Actions(driver);
		
		WebElement services = driver.findElement(By.xpath("//a[@href='#services']"));
		
		action.moveToElement(services).moveToElement(driver.findElement(By.xpath("//a[@href='#sentiment-analysis']"))).click().build().perform();
	}
	
	public static void navigateToEntityAnalysis(WebDriver driver) 
	{	
		Actions action = new Actions(driver);
		
		WebElement services = driver.findElement(By.xpath("//a[@href='#services']"));
		
		action.moveToElement(services).moveToElement(driver.findElement(By.xpath("//a[@href='#entity-analysis']"))).click().build().perform();
	}
	
	public static void navigateToPersonalityAnalysis(WebDriver driver) 
	{	
		Actions action = new Actions(driver);
		
		WebElement services = driver.findElement(By.xpath("//a[@href='#services']"));
		
		action.moveToElement(services).moveToElement(driver.findElement(By.xpath("//a[@href='#personality-analysis']"))).click().build().perform();
	}
	
	public static void navigateToAboutTheProduct(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement about = driver.findElement(By.xpath("//a[@href='#about']"));
	 
	    //Clicking the button
	    about.click();
	}
	
	public static void navigateToAboutThisProject(WebDriver driver) 
	{	
		Actions action = new Actions(driver);
		
		WebElement about = driver.findElement(By.xpath("//a[@href='#about']"));
		
		action.moveToElement(about).moveToElement(driver.findElement(By.id("about-this-project"))).click().build().perform();
	}
	
	public static void navigateToTestimonials(WebDriver driver) 
	{	
		Actions action = new Actions(driver);
		
		WebElement about = driver.findElement(By.xpath("//a[@href='#about']"));
		
		action.moveToElement(about).moveToElement(driver.findElement(By.xpath("//a[@href='#testimonials']"))).click().build().perform();
	}
	
	public static void navigateToAboutUs(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement aboutQueens = driver.findElement(By.xpath("//a[@href='#why-us']"));
	 
	    //Clicking the button
	    aboutQueens.click();
	}
	
	public static void navigateToAboutQueens(WebDriver driver) 
	{	
		Actions action = new Actions(driver);
		
		WebElement aboutQueens = driver.findElement(By.xpath("//a[@href='#why-us']"));
		
		action.moveToElement(aboutQueens).moveToElement(driver.findElement(By.id("about-qub"))).click().build().perform();
	}
	
	public static void navigateToTeam(WebDriver driver) 
	{	
		Actions action = new Actions(driver);
		
		WebElement aboutQueens = driver.findElement(By.xpath("//a[@href='#why-us']"));
		
		action.moveToElement(aboutQueens).moveToElement(driver.findElement(By.xpath("//a[@href='#team']"))).click().build().perform();
	}
	
	public static void navigateToFaq(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement faq = driver.findElement(By.xpath("//a[@href='#faq']"));
	 
	    //Clicking the button
	    faq.click();
	}
	
	public static void navigateToContact(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement contact = driver.findElement(By.xpath("//a[@href='#footer']"));
	 
	    //Clicking the button
	    contact.click();
	}
}
