package com.crm.qa.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.Data;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TasksPage tasksPage;
	static Data data;

	public TasksPageTest() {
		super();
	}
	
	public static String[] credentialsInfo(String user) {
		data = new Data();
		String admin = data.getLoginCredentials().get(user);
		String adminInfo[] = admin.split("_");
		return adminInfo;
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		testUtil = new TestUtil();
		data = new Data();
		loginPage = new LoginPage();
		homePage = new HomePage();
		tasksPage = new TasksPage();
		
		//Getting Credentials form HashMap
		String admin[] = credentialsInfo("admin");
		String un = admin[0];
		String pwd = admin[1];		
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(un, pwd);	
		testUtil.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();			
	}
	
	@Test(priority=1)
	public void verifyTasksPageLabel(){
		Assert.assertTrue(tasksPage.verifyShowingAllTasksLabel(), "contacts label is missing on the page");
	}

	@Test(priority=2)
	public void checkBrokenLinksImagesTest() throws IOException {	
		driver.navigate().refresh();
		testUtil.switchToFrame();
		testUtil.checkBrokenLinksAndImages();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
