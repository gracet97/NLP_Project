package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class sections {
	public static void main(String[] args) {
		//Creating a driver object referencing WebDriver interface
	    WebDriver driver;
	         
	    //Setting webdriver.gecko.driver property
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Grace\\Documents\\geckodriver.exe");
	         
	    //Instantiating driver object
	    driver = new FirefoxDriver();
	    
	    //Opening my web page
	    driver.get("http://127.0.0.1:5000/");
	    
	    //headerSection(driver); //PASSED
	    //heroSection(driver); //PASSED
	    //servicesSection(driver); //PASSED
	    //sentimentAnalysisSection(driver); //PASSED
	    //entityAnalysisSection(driver); //PASSED
	    //personalityAnalysisSection(driver); //PASSED
	    //aboutSection(driver); //PASSED
	    //testimonialsSection(driver); //PASSED
	    //whyUsSection(driver); //PASSED
	    //teamSection(driver); //PASSED
	    //faqSection(driver); //PASSED
	    //footerSection(driver); //PASSED
	}
	
	public static void headerSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement headerSection = driver.findElement(By.id("header"));
	}
	
	public static void heroSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement heroSection = driver.findElement(By.id("hero"));
	}
	
	public static void servicesSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement servicesSection = driver.findElement(By.id("services"));
	}

	
	public static void sentimentAnalysisSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement sentimentAnalysisSection = driver.findElement(By.id("sentiment-analysis"));
	}
	
	public static void entityAnalysisSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement entityAnalysisSection = driver.findElement(By.id("entity-analysis"));
	}
	
	public static void personalityAnalysisSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement personalityAnalysisSection = driver.findElement(By.id("personality-analysis"));
	}
	
	public static void aboutSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement aboutSection = driver.findElement(By.id("about"));
	}
	
	public static void testimonialsSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement testimonialsSection = driver.findElement(By.id("testimonials"));
	}
	
	public static void aboutQueensSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement aboutQueensSection = driver.findElement(By.id("why-us"));
	}
	
	public static void teamSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement teamSection = driver.findElement(By.id("team"));
	}

	public static void faqSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement faqSection = driver.findElement(By.id("faq"));
	}
	
	public static void footerSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement footerSection = driver.findElement(By.id("footer"));
	}
}
