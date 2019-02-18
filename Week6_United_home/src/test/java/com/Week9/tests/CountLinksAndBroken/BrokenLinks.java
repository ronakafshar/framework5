package com.Week9.tests.CountLinksAndBroken;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.library.Base;

public class BrokenLinks extends Base {
	final static Logger logger = Logger.getLogger(BrokenLinks.class);

	public static int invalidLink;
	String currentLink;
	String temp;

	@Test(enabled = true)
	public void testinglinksingoogle() {
		driver.get("http:www.google.com");
		// Get all the links
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		int linkCount = ele.size();     // Count the total Link list on Web Page
		System.out.println("size:" + ele.size());
		boolean isValid = false;
		for (int i = 0; i < ele.size(); i++) {
			String nextHref = ele.get(i).getAttribute("href");
			isValid = getResponseCode(nextHref);
			if (isValid) {
				// System.out.println("Valid Link:" + nextHref);

			} else {
				System.out.println("INVALID Link:" + nextHref);

			}
		}
	}

	public static boolean getResponseCode(String urlString) {

		boolean isValid = false;
		try {
			URL u = new URL(urlString);
			HttpURLConnection h = (HttpURLConnection) u.openConnection();
			h.setRequestMethod("GET");
			h.connect();
			// System.out.println(h.getResponseCode());
			if (h.getResponseCode() != 404) {
				isValid = true;
			}
		} catch (Exception e) {

		}

		return isValid;

	}

}
