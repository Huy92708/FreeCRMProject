package com.crm.qa.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase{
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyShowingAllTasksLabel() {			
		return driver.findElement(By.xpath("//em[contains(text(),'Showing all tasks')]")).isDisplayed();	
	}
	
//	public void checkBrokenLinksAndImages() throws MalformedURLException, IOException {
//		//links -- //a href
//		//images -- //img href
//
//		//1. Get the list of all the links and images
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		linksList.addAll(driver.findElements(By.tagName("img")));
//
//		System.out.println("Total links and images: " +linksList.size());
//
//		List<WebElement> activeLinks = new ArrayList<WebElement>();
//
//		//2. Iterate linksList, exclude all the links/images does NOT have href Attribute
//		for (int i=0; i<linksList.size(); i++) 
//		{
//			if (linksList.get(i).getAttribute("href") != null && (! linksList.get(i).getAttribute("href").contains("javascript"))){
//				activeLinks.add(linksList.get(i));
//			}
//		}
//		System.out.println("Total active links and images: " +activeLinks.size());
//
//		//3. Check the href url, with HttpURLConnection URL
//		//404 -- Not found
//		//400 -- bad request
//		//500 -- internal error
//		//200 -- OK
//
//		for (int j=0; j<activeLinks.size(); j++)
//		{
//			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
//			
//			connection.connect();
//			String response = connection.getResponseMessage();
//			connection.disconnect();
//			if (!response.equalsIgnoreCase("OK"))
//				System.out.println(activeLinks.get(j).getAttribute("href")+"----> "+response);
//		}
//	}
	
}
