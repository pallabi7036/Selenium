package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Opportunities {
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement opportunity;
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement lookup;
	@FindBy(name="potentialname")
	private WebElement opportunityname;
	@FindBy(xpath="//tr[1]/td/div/input[@class='crmbutton small save']")
	private WebElement save;
	
	public void navigateToLeads()
	{
		opportunity.click();
	}
	public void navgateToLookup() {
		lookup.click();
	}
	public void navigateToSalutation() {
		
		opportunityname.click();
	}
	public void navigateToSave() {
		save.click();
	}
	}
