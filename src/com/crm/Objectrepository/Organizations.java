package com.crm.Objectrepository;

import java.io.IOException;//

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import com.crm.genericlib.FileUtils;

public class Organizations {
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Organizations']")
	private WebElement organizations;
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement lookup;
	@FindBy(name="accountname")
	private WebElement orgName;
	@FindBy(xpath="//tr[1]/td/div/input[@class='crmbutton small save']")
	private WebElement save;
	@FindBy(name="selected_id")
	private WebElement box;
	@FindBy(xpath="//table[@class='small']/tbody/ tr/td/input[@class='crmbutton small delete']")
	private WebElement delete;
	
	public void navigateToOrganizationPage() {
		organizations.click();
	}
	public void navigateToLookupImage() {
		lookup.click();
	}
	public void navigateToSave() {
		save.click();
	}
	public void Organizations(String Organizationname1) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		orgName.sendKeys(Organizationname1);
}
	public void navigateToBox() {
		box.click();
	}
	public void navigateToDelete() {
		delete.click();
	}
}
