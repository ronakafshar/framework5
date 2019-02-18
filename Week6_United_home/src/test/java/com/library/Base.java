package com.library;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	final static Logger logger = Logger.getLogger(Base.class);
	
	public static WebDriver driver;
	public static GlobalSeleniumLibrary myLibrary;
	private static JavaPropertiesManager readProperty;
	private static String browser;
	private static String demoType;
	
	@BeforeClass
	public void beforeAllTestStart(){
		readProperty = new JavaPropertiesManager("src/test/resources/config.properties");
		browser = readProperty.readProperty("browserType");
		demoType = readProperty.readProperty("demoMode");
		
		myLibrary = new GlobalSeleniumLibrary(driver);		

		if( demoType.contains("true")){
			myLibrary.setDemo(true);			
			logger.info("Test is running in Demo mode ON...");
		}else{
			logger.info("Test is running in Demo mode OFF...");
		}
	}
	
	@AfterClass
	public void afterAllTestCompleted(){
		
	}
	
	@BeforeMethod
	public void beforeEachTestStart() {
		driver = myLibrary.startLocalBrowser(browser);			
	}

	@AfterMethod
	public void afterEachTestEnd(ITestResult result) {
		try {
			if(ITestResult.FAILURE == result.getStatus())
			{
				myLibrary.captureScreenshot(result.getName(), "target/screenshots/");
			}
			Thread.sleep(2 * 1000);

			driver.close(); // close the browser
			driver.quit(); // kills/deletes the driver object

		} catch (Exception e) {			
			logger.error("Error: ", e);			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
