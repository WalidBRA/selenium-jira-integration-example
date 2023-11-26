package com.codelabs.examples.selenium.tests;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codelabs.examples.annotations.ScriptMetaData;

public class TC_WikipediaSearchTest {
	private WebDriver driver;
	private String baseUrl;

	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		
		FirefoxOptions options = new FirefoxOptions();
	    driver = new FirefoxDriver(options);
		
		   
		baseUrl = "https://www.wikipedia.org/";
		
	}

	@ScriptMetaData(productionReady=true)
	@Test
	public void testCase() throws Exception {
		driver.get(baseUrl);

		String searchText = "Selenium";

		driver.findElement(By.id("searchInput")).clear();
		System.out.println("--------------------------------------------------step 1-------------------------------------------------------- ");
		driver.findElement(By.id("searchInput")).sendKeys(searchText);
		System.out.println("--------------------------------------------------step 2-------------------------------------------------------- ");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='" + searchText + "'])[6]/following::i[1]"))
				.click();

		// Injecting a failure here to start the Jira issue creation. 
		assertEquals(driver.findElement(By.id("firstHeading")).getText(), "HP ALM");
		
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}


	
}
