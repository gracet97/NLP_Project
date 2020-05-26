package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//Tests for each section of website
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

	    //Tests running
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

	//Method to test Header section is labelled as expected
	public static void headerSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement headerSection = driver.findElement(By.id("header"));
	}
	
	//Method to test Hero section is labelled as expected
	public static void heroSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement heroSection = driver.findElement(By.id("hero"));
	}
	
	//Method to test Services section is labelled as expected
	public static void servicesSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement servicesSection = driver.findElement(By.id("services"));
	}

	//Method to test Sentiment Analysis section is labelled as expected
	public static void sentimentAnalysisSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement sentimentAnalysisSection = driver.findElement(By.id("sentiment-analysis"));
	}
	
	//Method to test Entity Analysis section is labelled as expected
	public static void entityAnalysisSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement entityAnalysisSection = driver.findElement(By.id("entity-analysis"));
	}
	
	//Method to test Personality Analysis section is labelled as expected
	public static void personalityAnalysisSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement personalityAnalysisSection = driver.findElement(By.id("personality-analysis"));
	}
	
	//Method to test About section is labelled as expected
	public static void aboutSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement aboutSection = driver.findElement(By.id("about"));
	}
	
	//Method to test Testimonials section is labelled as expected
	public static void testimonialsSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement testimonialsSection = driver.findElement(By.id("testimonials"));
	}
	
	//Method to test About Queen's section is labelled as expected
	public static void aboutQueensSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement aboutQueensSection = driver.findElement(By.id("why-us"));
	}
	
	//Method to test Team section is labelled as expected
	public static void teamSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement teamSection = driver.findElement(By.id("team"));
	}

	//Method to test FAQ section is labelled as expected
	public static void faqSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement faqSection = driver.findElement(By.id("faq"));
	}
	
	//Method to test Footer section is labelled as expected
	public static void footerSection(WebDriver driver) 
	{
	    //Initialising web element of section
	    WebElement footerSection = driver.findElement(By.id("footer"));
	}
}
