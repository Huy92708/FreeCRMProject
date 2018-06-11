package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	
	String sheetName = "deals";
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		dealsPage = new DealsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=1)
	public void verifyDealsLabelTest() {
		Assert.assertTrue(dealsPage.verifyDealsLabel(), "Deals label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getDealsTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getDealsTestData")
	public void createNewDealTest(String Title, String Company, String PContact, String Commission, String Source, String Predicted, String Actual) {
		homePage.clickOnNewDealLink();
		//dealsPage.clickOnActualCloseDateCalendar();		
		dealsPage.createNewDeal(Title, Company, PContact, Commission, Source, Predicted, Actual);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
