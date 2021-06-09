package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	final String USERNAME= "AdminTest";
	final String PASSWORD= "test123";
	//sign in locators
	By registerLinkocator = By.linkText("REGISTER");
	By registerpageLocator= By.xpath("//img[ @src='images/mast_register.gif']");
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPaswordLocator = By.cssSelector("input[name='confirmPassword']");
	By submitBtnLocator = By.name("submit");

	//login locators
	By loginUserLocator = By.name("userName");
	By loginPasswordLocator = By.name("password");
	By loginSubmitLocator = By.name("submit");
	

	
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	//Test crear usuario
	@Test
	public void regiterUser() throws InterruptedException {
		
		
		driver.findElement(registerLinkocator).click();
		Thread.sleep(2000); // tiempo espera carga pagina registro
		if (driver.findElement(registerpageLocator).isDisplayed()) {
			
			
				driver.findElement(usernameLocator).sendKeys(USERNAME);
				driver.findElement(passwordLocator).sendKeys(PASSWORD);
				driver.findElement(confirmPaswordLocator).sendKeys(PASSWORD);
				driver.findElement(submitBtnLocator).click();
						
		}else {
			System.out.println("Register page was not found");
			
		}
		Thread.sleep(2000);
		
		List<WebElement>fontElements= driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is AdminTest.", fontElements.get(5).getText());
		
	}
	
	@Test
	public void signIn () throws InterruptedException {
		if (driver.findElement(loginUserLocator).isDisplayed()){
		driver.findElement(loginUserLocator).sendKeys(USERNAME);
		driver.findElement(loginPasswordLocator).sendKeys(PASSWORD);
		driver.findElement(loginSubmitLocator).click();
		Thread.sleep(2000); //tiempo de carga
		List<WebElement>fontElements= driver.findElements(By.tagName("font"));
		assertEquals("Thank you for Loggin.", fontElements.get(3).getText());
		
	}else {
		System.out.println("username box not found");
		
	}
	}

}
