package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.genericlib1.BaseClass;

public class Campaigns {
	@FindBy(xpath="//a[text()='More']")
	private WebElement more;
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaigns;
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement lookup;
	@FindBy(name="campaignname")
	private WebElement campaigname;
	@FindBy(xpath="//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmButton small save']")
	private WebElement save;
	 
	public void navigateToMore() {
	more.click();
	Actions act=new Actions(BaseClass.driver);
	act.moveToElement(campaigns);
	act.perform();	
	}
	public void navigateToCampaigns() {
		campaigns.click();
	}
	public void navigateToLookup() {
		lookup.click();
	}
	public void navigateToCampaignName(String Campaignname1) {
		campaigname.sendKeys(Campaignname1);
	}
	public void navigateToSave() {
		save.click();
	}
	

}
