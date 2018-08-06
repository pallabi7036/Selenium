package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lead {
	@FindBy(xpath="//a[text()='Leads']")
	private WebElement lead;
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement lookup;
	@FindBy(name="salutationtype")
	private WebElement salutation;
	@FindBy(name="firstname")
	private WebElement fname;
	@FindBy(name="lastname")
	private WebElement lname;
	@FindBy(xpath="//tr[1]/td/div/input[@class='crmbutton small save']")
	private WebElement save;
	
	public void navigateToLeads()
	{
		lead.click();
	}
	public void navgateToLookup() {
		lookup.click();
	}
	public void navigateToSalutation() {
		salutation.click();
	}
	public void navigateToFname(String Fname) {
		fname.sendKeys(Fname);
	}
	public void navigateToLname(String Lname) {
		lname.sendKeys(Lname);
	}
	public void navigateToSave() {
		save.click();
	}
	}


