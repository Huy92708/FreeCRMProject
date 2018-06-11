package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class DealsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Deals')]")
	WebElement dealsLabel;
	
	@FindBy(xpath="//td//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//td//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//td//input[@name='contact_lookup']")
	WebElement primaryContact;
	
	@FindBy(xpath="//td//input[@id='commission']")
	WebElement commission;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//td//img[@id='f_trigger_c_actual_close_date']")
	WebElement actualDateBtn;
	
	// Initializing the Page Objects:
		public DealsPage() {
			PageFactory.initElements(driver, this);
		}

	public boolean verifyDealsLabel() {
		return dealsLabel.isDisplayed();
	}
	
	public void enterPredictedAndActualDate(String predicted, String actual) {
		//driver.findElement(By.id("f_trigger_c_actual_close_date")).click();
		WebElement predictedDate = driver.findElement(By.id("fieldId_close_date"));
		WebElement actualDate = driver.findElement(By.id("fieldId_actual_close_date"));			
		TestUtil.selectDateByJS(driver, predictedDate, predicted);
		TestUtil.selectDateByJS(driver, actualDate, actual);
	}
	
	
	public void createNewDeal(String ttl, String co, String pc, String com, String src, String pd, String ad) {
		Select select = new Select(driver.findElement(By.name("source")));
		select.selectByVisibleText(src);
		
		title.sendKeys(ttl);
		company.sendKeys(co);
		primaryContact.sendKeys(pc);
		commission.sendKeys(com);
		
		enterPredictedAndActualDate(pd, ad);
		saveBtn.click();
	}
}
