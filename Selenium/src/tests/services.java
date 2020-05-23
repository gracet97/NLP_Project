package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class services {
	public static void main(String[] args) {
		//Creating a driver object referencing WebDriver interface
	    WebDriver driver;
	         
	    //Setting webdriver.gecko.driver property
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Grace\\Documents\\geckodriver.exe");
	         
	    //Instantiating driver object
	    driver = new FirefoxDriver();
	    
	    //Opening my web page
	    driver.get("http://127.0.0.1:5000/");
	    
	    //Text areas
	    //sentimentTextArea(driver); //PASSED
	    //entityTextArea(driver); //PASSED
	    //personalityTextArea(driver); //PASSED
	    
	    //Click button with blank text area
	    //sentimentButtonBlank(driver); //PASSED
	    //entityButtonBlank(driver); //PASSED
	    //personalityButtonBlank(driver); //PASSED
	    
	    //Click button with spaces in text area
	    //sentimentTextAreaSpaces(driver); //PASSED 
	    //entityTextAreaSpaces(driver); //PASSED
	    //personalityTextAreaSpaces(driver); //PASSED
	    
	    //Click button with tabs in text area
	    //sentimentTextAreaTab(driver); //PASSED
	    //entityTextAreaTab(driver); //PASSED
	    //personalityTextAreaTab(driver); //PASSED
	    
	    //Click button with numbers in text area
	    //sentimentTextAreaNumbers(driver); //PASSED
	    //entityTextAreaNumbers(driver); //PASSED
	    //personalityTextAreaNumbers(driver); //PASSED
	    
	    //Click button with symbols in text area
	    //sentimentTextAreaSymbols(driver); //PASSED
	    //entityTextAreaSymbols(driver); //PASSED
	    //personalityTextAreaSymbols(driver); //PASSED
	    
	    //Click button with spaces & tabs & numbers & symbols in text area
	    //sentimentTextAreaSpacesTabsNumbersSymbols(driver); //PASSED
	    //entityTextAreaSpacesTabsNumbersSymbols(driver); //PASSED
	    //personalityTextAreaSpacesTabsNumbersSymbols(driver); //PASSED
	    
	    //Click button with valid text area
	    //sentimentTextAreaValid(driver); //PASSED
	    //entityTextAreaValid(driver); //PASSED
	    //personalityTextAreaValid(driver); //PASSED
	}
	
	//Text areas
	
	public static void sentimentTextArea(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement sentimentTextArea = driver.findElement(By.id("sentiment-input"));
	 
	    //Writing text in text area
	    sentimentTextArea.sendKeys("Testing via selenium");
	}
	
	public static void entityTextArea(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement entityTextArea = driver.findElement(By.id("entity-input"));
	 
	    //Writing text in text area
	    entityTextArea.sendKeys("Testing via selenium");
	}
	
	public static void personalityTextArea(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement personalityTextArea = driver.findElement(By.id("personality-input"));
	 
	    //Writing text in text area
	    personalityTextArea.sendKeys("Testing via selenium");
	}
	
	//Buttons
	
	public static void sentimentButtonBlank(WebDriver driver) 
	{
	    //Initialising web element of button 
	    WebElement sentimentButton = driver.findElement(By.id("analyse-sentiment"));
	 
	    //Clicking the button
	    sentimentButton.click();
	}
	
	public static void entityButtonBlank(WebDriver driver) 
	{
	    //Initialising web element of button 
	    WebElement entityButton = driver.findElement(By.id("analyse-entity"));
	 
	    //Clicking the button
	    entityButton.click();
	}
	
	public static void personalityButtonBlank(WebDriver driver) 
	{
	    //Initialising web element of button 
	    WebElement personalityButton = driver.findElement(By.id("analyse-personality"));
	 
	    //Clicking the button
	    personalityButton.click();
	}
	
	//Click button with spaces in text area
	
	public static void sentimentTextAreaSpaces(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement sentimentTextArea = driver.findElement(By.id("sentiment-input"));
	 
	    //Writing text in text area
	    sentimentTextArea.sendKeys("   ");
	    
	    //Initialising web element of button 
	    WebElement sentimentButton = driver.findElement(By.id("analyse-sentiment"));
	 
	    //Clicking the button
	    sentimentButton.click();
	}
	
	public static void entityTextAreaSpaces(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement entityTextArea = driver.findElement(By.id("entity-input"));
	 
	    //Writing text in text area
	    entityTextArea.sendKeys("   ");
	    
	    //Initialising web element of button 
	    WebElement entityButton = driver.findElement(By.id("analyse-entity"));
	 
	    //Clicking the button
	    entityButton.click();
	}
	
	public static void personalityTextAreaSpaces(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement personalityTextArea = driver.findElement(By.id("personality-input"));
	 
	    //Writing text in text area
	    personalityTextArea.sendKeys("   ");
	    
	    //Initialising web element of button 
	    WebElement personalityButton = driver.findElement(By.id("analyse-personality"));
	 
	    //Clicking the button
	    personalityButton.click();
	}
    
    //Click button with tabs in text area
	
	public static void sentimentTextAreaTab(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement sentimentTextArea = driver.findElement(By.id("sentiment-input"));
	 
	    //Writing text in text area
	    sentimentTextArea.sendKeys("	");
	    
	    //Initialising web element of button 
	    WebElement sentimentButton = driver.findElement(By.id("analyse-sentiment"));
	 
	    //Clicking the button
	    sentimentButton.click();
	}
	
	public static void entityTextAreaTab(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement entityTextArea = driver.findElement(By.id("entity-input"));
	 
	    //Writing text in text area
	    entityTextArea.sendKeys("	");
	    
	    //Initialising web element of button 
	    WebElement entityButton = driver.findElement(By.id("analyse-entity"));
	 
	    //Clicking the button
	    entityButton.click();
	}
	
	public static void personalityTextAreaTab(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement personalityTextArea = driver.findElement(By.id("personality-input"));
	 
	    //Writing text in text area
	    personalityTextArea.sendKeys("	");
	    
	    //Initialising web element of button 
	    WebElement personalityButton = driver.findElement(By.id("analyse-personality"));
	 
	    //Clicking the button
	    personalityButton.click();
	}
    
    //Click button with numbers in text area
	
	public static void sentimentTextAreaNumbers(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement sentimentTextArea = driver.findElement(By.id("sentiment-input"));
	 
	    //Writing text in text area
	    sentimentTextArea.sendKeys("123");
	    
	    //Initialising web element of button 
	    WebElement sentimentButton = driver.findElement(By.id("analyse-sentiment"));
	 
	    //Clicking the button
	    sentimentButton.click();
	}
	
	public static void entityTextAreaNumbers(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement entityTextArea = driver.findElement(By.id("entity-input"));
	 
	    //Writing text in text area
	    entityTextArea.sendKeys("123");
	    
	    //Initialising web element of button 
	    WebElement entityButton = driver.findElement(By.id("analyse-entity"));
	 
	    //Clicking the button
	    entityButton.click();
	}
	
	public static void personalityTextAreaNumbers(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement personalityTextArea = driver.findElement(By.id("personality-input"));
	 
	    //Writing text in text area
	    personalityTextArea.sendKeys("123");
	    
	    //Initialising web element of button 
	    WebElement personalityButton = driver.findElement(By.id("analyse-personality"));
	 
	    //Clicking the button
	    personalityButton.click();
	}
    
    //Click button with symbols in text area
	
	public static void sentimentTextAreaSymbols(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement sentimentTextArea = driver.findElement(By.id("sentiment-input"));
	 
	    //Writing text in text area
	    sentimentTextArea.sendKeys("!&");
	    
	    //Initialising web element of button 
	    WebElement sentimentButton = driver.findElement(By.id("analyse-sentiment"));
	 
	    //Clicking the button
	    sentimentButton.click();
	}
	
	public static void entityTextAreaSymbols(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement entityTextArea = driver.findElement(By.id("entity-input"));
	 
	    //Writing text in text area
	    entityTextArea.sendKeys("!&");
	    
	    //Initialising web element of button 
	    WebElement entityButton = driver.findElement(By.id("analyse-entity"));
	 
	    //Clicking the button
	    entityButton.click();
	}
	
	public static void personalityTextAreaSymbols(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement personalityTextArea = driver.findElement(By.id("personality-input"));
	 
	    //Writing text in text area
	    personalityTextArea.sendKeys("!&");
	    
	    //Initialising web element of button 
	    WebElement personalityButton = driver.findElement(By.id("analyse-personality"));
	 
	    //Clicking the button
	    personalityButton.click();
	}
    
    //Click button with spaces & tabs & numbers & symbols in text area
	
	public static void sentimentTextAreaSpacesTabsNumbersSymbols(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement sentimentTextArea = driver.findElement(By.id("sentiment-input"));
	 
	    //Writing text in text area
	    sentimentTextArea.sendKeys("   	123!&");
	    
	    //Initialising web element of button 
	    WebElement sentimentButton = driver.findElement(By.id("analyse-sentiment"));
	 
	    //Clicking the button
	    sentimentButton.click();
	}
	
	public static void entityTextAreaSpacesTabsNumbersSymbols(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement entityTextArea = driver.findElement(By.id("entity-input"));
	 
	    //Writing text in text area
	    entityTextArea.sendKeys("   	123!&");
	    
	    //Initialising web element of button 
	    WebElement entityButton = driver.findElement(By.id("analyse-entity"));
	 
	    //Clicking the button
	    entityButton.click();
	}
	
	public static void personalityTextAreaSpacesTabsNumbersSymbols(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement personalityTextArea = driver.findElement(By.id("personality-input"));
	 
	    //Writing text in text area
	    personalityTextArea.sendKeys("   	123!&");
	    
	    //Initialising web element of button 
	    WebElement personalityButton = driver.findElement(By.id("analyse-personality"));
	 
	    //Clicking the button
	    personalityButton.click();
	}
    
    //Click button with valid text area
	
	public static void sentimentTextAreaValid(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement sentimentTextArea = driver.findElement(By.id("sentiment-input"));
	 
	    //Writing text in text area
	    sentimentTextArea.sendKeys("I am happy");
	    
	    //Initialising web element of button 
	    WebElement sentimentButton = driver.findElement(By.id("analyse-sentiment"));
	 
	    //Clicking the button
	    sentimentButton.click();
	}
	
	public static void entityTextAreaValid(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement entityTextArea = driver.findElement(By.id("entity-input"));
	 
	    //Writing text in text area
	    entityTextArea.sendKeys("My name is Grace and I am from Belfast");
	    
	    //Initialising web element of button 
	    WebElement entityButton = driver.findElement(By.id("analyse-entity"));
	 
	    //Clicking the button
	    entityButton.click();
	}
	
	public static void personalityTextValid(WebDriver driver) 
	{
	    //Initialising web element of text area
	    WebElement personalityTextArea = driver.findElement(By.id("personality-input"));
	 
	    //Writing text in text area
	    personalityTextArea.sendKeys("this is text to be analysed for its personality");
	    
	    //Initialising web element of button 
	    WebElement personalityButton = driver.findElement(By.id("analyse-personality"));
	 
	    //Clicking the button
	    personalityButton.click();
	}
}
