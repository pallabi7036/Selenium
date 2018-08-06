package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.genericlib1.BaseClass;

public class SalesOrder {
	@FindBy(xpath="//a[text()='More']")
	private WebElement more;
	@FindBy(xpath="//a[text()='Sales Order']")
	private WebElement salesorder;
	@FindBy(xpath="//img[@title='Create Sales Order...']")
	private WebElement lookup;
	@FindBy(name="subject")
	private WebElement subject;
	@FindBy(name="bill_street")
	private WebElement billingaddress;
	@FindBy(name="ship_street")
	private WebElement shippingaddress;
	@FindBy(id="productName1")
	private WebElement tools;
	@FindBy(xpath="//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmButton small save']")
	private WebElement save;
	 
	public void navigateToMore() {
	more.click();
	Actions act=new Actions(BaseClass.driver);
	act.moveToElement(salesorder);
	act.perform();	
	}
	public void navigateToSalesOrder() {
		salesorder.click();
	}
	public void navigateToLookup() {
		lookup.click();
	}
	public void navigateToCampaignName(String salesorder) {
		subject.sendKeys(salesorder);
	}
	public void navigateToBillingAddress(String billAddress) {
		billingaddress.sendKeys(billAddress);
	}
	public void navigateToShippingaddress(String shippingAddress) {
		shippingaddress.sendKeys(shippingAddress);
	}
	public void navigateToTools(String Tools) {
		tools.sendKeys(Tools);
	}
	public void navigateToSave() {
		save.click();
	}
	

}

