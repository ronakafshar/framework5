package com.Week9.tests.CountLinksAndBroken;

	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class CountLinks {
	    public static void main(String[] args) {
	    	System.setProperty("webdriver.chrome.driver", "src/test/resources/browser_drivers/chromedriver.exe");
	        // TODO Auto-generated method stub
	          WebDriver driver = new ChromeDriver();
	          driver.get("https://google.com");
	          
	          List<WebElement> links = driver.findElements(By.xpath("//a"));    //Identify the number of Link on webpage and assign into Webelement List 
	          
	          int linkCount = links.size();     // Count the total Link list on Web Page
	          
	          System.out.println("Total Number of link count on webpage = "  + linkCount);    //Print the total count of links on webpage
	          
	          List<WebElement> allElements = driver.findElements(By.xpath("//*"));      //Identify all the elements on web page
	          
	          int elementsCount = allElements.size();     //Count the total all element on web page
	          
	          System.out.println("Total Number of All Element on webpage = "  + elementsCount);         //Print the total count of all element on webpage
	          
	      	try {
				Thread.sleep(10 * 1000);

				driver.close(); // close the browser
				driver.quit(); // kills/deletes the driver object

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	 



