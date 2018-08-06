package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.genericlib1.BaseClass;

public class Invoice {
	@FindBy(xpath="//a[text()='More']")
	private WebElement more;
	@FindBy(xpath="//a[text()='Invoice']")
	private WebElement invoice;
	@FindBy(xpath="//img[@title='Create Invoice...']")
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
	act.moveToElement(invoice);
	act.perform();	
	}
	public void navigateToInvoice() {
		invoice.click();
	}
	public void navigateToLookup() {
		lookup.click();
	}
	public void navigateToCampaignName(String Invoice) {
		subject.sendKeys(Invoice);
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

