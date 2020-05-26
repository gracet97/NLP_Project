package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Tests for Navigation section of website
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

	    //Tests running
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
	
	//Method to test link to Home works as expected
	//by taking the user to Home
	public static void navigateToHome(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement home = driver.findElement(By.xpath("//a[@href='/']"));
	 
	    //Clicking the button
	    home.click();
	}

	//Method to test link to Services works as expected
	//by taking the user to Services
	public static void navigateToServices(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement services = driver.findElement(By.xpath("//a[@href='#services']"));
	 
	    //Clicking the button
	    services.click();
	}

	//Method to test link to Sentiment Analysis works as expected
	//by taking the user to Sentiment Analysis
	public static void navigateToSentimentAnalysis(WebDriver driver) 
	{	
		//Create an action using the driver
		Actions action = new Actions(driver);
		
		//Initialising web element of button in navigation bar
		WebElement services = driver.findElement(By.xpath("//a[@href='#services']"));
		
		//The actions moves to the menu item, then finds and clicks on a sub menu item
		action.moveToElement(services).moveToElement(driver.findElement(By.xpath("//a[@href='#sentiment-analysis']"))).click().build().perform();
	}

	//Method to test link to Entity Analysis works as expected
	//by taking the user to Entity Analysis
	public static void navigateToEntityAnalysis(WebDriver driver) 
	{	
		//Create an action using the driver
		Actions action = new Actions(driver);

		//Initialising web element of button in navigation bar
		WebElement services = driver.findElement(By.xpath("//a[@href='#services']"));

		//The actions moves to the menu item, then finds and clicks on a sub menu item
		action.moveToElement(services).moveToElement(driver.findElement(By.xpath("//a[@href='#entity-analysis']"))).click().build().perform();
	}

	//Method to test link to Personality Analysis works as expected
	//by taking the user to Personality Analysis
	public static void navigateToPersonalityAnalysis(WebDriver driver) 
	{	
		//Create an action using the driver
		Actions action = new Actions(driver);

		//Initialising web element of button in navigation bar
		WebElement services = driver.findElement(By.xpath("//a[@href='#services']"));

		//The actions moves to the menu item, then finds and clicks on a sub menu item
		action.moveToElement(services).moveToElement(driver.findElement(By.xpath("//a[@href='#personality-analysis']"))).click().build().perform();
	}

	//Method to test link to About the Product works as expected
	//by taking the user to About this Project
	public static void navigateToAboutTheProduct(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement about = driver.findElement(By.xpath("//a[@href='#about']"));
	 
	    //Clicking the button
	    about.click();
	}

	//Method to test link to About this Project works as expected
	//by taking the user to About this Project
	public static void navigateToAboutThisProject(WebDriver driver) 
	{	
		//Create an action using the driver
		Actions action = new Actions(driver);

		//Initialising web element of button in navigation bar
		WebElement about = driver.findElement(By.xpath("//a[@href='#about']"));

		//The actions moves to the menu item, then finds and clicks on a sub menu item
		action.moveToElement(about).moveToElement(driver.findElement(By.id("about-this-project"))).click().build().perform();
	}

	//Method to test link to Testimonials works as expected
	//by taking the user to Testimonials
	public static void navigateToTestimonials(WebDriver driver) 
	{	
		//Create an action using the driver
		Actions action = new Actions(driver);

		//Initialising web element of button in navigation bar
		WebElement about = driver.findElement(By.xpath("//a[@href='#about']"));

		//The actions moves to the menu item, then finds and clicks on a sub menu item
		action.moveToElement(about).moveToElement(driver.findElement(By.xpath("//a[@href='#testimonials']"))).click().build().perform();
	}

	//Method to test link to About Us works as expected
	//by taking the user to Why Us/About Queen's
	public static void navigateToAboutUs(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement aboutQueens = driver.findElement(By.xpath("//a[@href='#why-us']"));
	 
	    //Clicking the button
	    aboutQueens.click();
	}

	//Method to test link to About Queen's works as expected
	//by taking the user to Why Us/About Queen's
	public static void navigateToAboutQueens(WebDriver driver) 
	{	
		//Create an action using the driver
		Actions action = new Actions(driver);

		//Initialising web element of button in navigation bar
		WebElement aboutQueens = driver.findElement(By.xpath("//a[@href='#why-us']"));

		//The actions moves to the menu item, then finds and clicks on a sub menu item
		action.moveToElement(aboutQueens).moveToElement(driver.findElement(By.id("about-qub"))).click().build().perform();
	}

	//Method to test link to Team works as expected
	//by taking the user to Team
	public static void navigateToTeam(WebDriver driver) 
	{	
		//Create an action using the driver
		Actions action = new Actions(driver);

		//Initialising web element of button in navigation bar
		WebElement aboutQueens = driver.findElement(By.xpath("//a[@href='#why-us']"));

		//The actions moves to the menu item, then finds and clicks on a sub menu item
		action.moveToElement(aboutQueens).moveToElement(driver.findElement(By.xpath("//a[@href='#team']"))).click().build().perform();
	}

	//Method to test link to FAQ works as expected
	//by taking the user to FAQ
	public static void navigateToFaq(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement faq = driver.findElement(By.xpath("//a[@href='#faq']"));
	 
	    //Clicking the button
	    faq.click();
	}

	//Method to test link to Contact works as expected
	//by taking the user to Contact
	public static void navigateToContact(WebDriver driver) 
	{	
		//Initialising web element of button in navigation bar
	    WebElement contact = driver.findElement(By.xpath("//a[@href='#footer']"));
	 
	    //Clicking the button
	    contact.click();
	}
}
