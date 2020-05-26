package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//Tests for FAQ section of website
public class faq {
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
	    //faqQ1(driver); //PASSED
	    //faqQ2(driver); //PASSED
	    //faqQ3(driver); //PASSED
	    //faqQ4(driver); //PASSED
	    //faqQ5(driver); //PASSED
	    //faqQ6(driver); //PASSED
	    //faqQ7(driver); //PASSED
	}

	//Method to test link to FAQ works as expected
	//by opening the relevant answer
	public static void faqQ1(WebDriver driver) 
	{
		//Initialising web element of faq
	    WebElement faqQ1 = driver.findElement(By.id("faqQ1"));
	    
	    //Clicking the faq
	    faqQ1.click();
	}

	//Method to test link to FAQ works as expected
	//by opening the relevant answer
	public static void faqQ2(WebDriver driver) 
	{
		//Initialising web element of faq
	    WebElement faqQ2 = driver.findElement(By.id("faqQ2"));
	    
	    //Clicking the faq
	    faqQ2.click();
	}

	//Method to test link to FAQ works as expected
	//by opening the relevant answer
	public static void faqQ3(WebDriver driver) 
	{
		//Initialising web element of faq
	    WebElement faqQ3 = driver.findElement(By.id("faqQ3"));
	    
	    //Clicking the faq
	    faqQ3.click();
	}

	//Method to test link to FAQ works as expected
	//by opening the relevant answer
	public static void faqQ4(WebDriver driver) 
	{
		//Initialising web element of faq
	    WebElement faqQ4 = driver.findElement(By.id("faqQ4"));
	    
	    //Clicking the faq
	    faqQ4.click();
	}

	//Method to test link to FAQ works as expected
	//by opening the relevant answer
	public static void faqQ5(WebDriver driver) 
	{
		//Initialising web element of faq
	    WebElement faqQ5 = driver.findElement(By.id("faqQ5"));
	    
	    //Clicking the faq
	    faqQ5.click();
	}

	//Method to test link to FAQ works as expected
	//by opening the relevant answer
	public static void faqQ6(WebDriver driver) 
	{
		//Initialising web element of faq
	    WebElement faqQ6 = driver.findElement(By.id("faqQ6"));
	    
	    //Clicking the faq
	    faqQ6.click();
	}

	//Method to test link to FAQ works as expected
	//by opening the relevant answer
	public static void faqQ7(WebDriver driver) 
	{
		//Initialising web element of faq
	    WebElement faqQ7 = driver.findElement(By.id("faqQ7"));
	    
	    //Clicking the faq
	    faqQ7.click();
	}
}
