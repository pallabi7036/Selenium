package com.crm.Objectrepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.crm.genericlib1.BaseClass;

public class Contact {
//@FindBy(xpath="//a[text()='Contacts']")
	@FindBy(linkText="Contacts")
private WebElement cont;
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement lookup;
@FindBy(name="salutationtype")
private WebElement salutation;
@FindBy(name="firstname")
private WebElement fname;
@FindBy(name="lastname")
private WebElement lname;
@FindBy(name="account_name")
private WebElement conOrg;
@FindBy(id="1")
private WebElement orgname;
@FindBy(xpath="//tr[1]/td/div/input[@class='crmbutton small save']")
private WebElement save;

public void navigateToContacts()
{
	cont.click();
}
public void navgateToLookup() {
	lookup.click();
}
public void navigateToSalutation() {
	Select sel=new Select(salutation);
	sel.selectByVisibleText("Mr.");
	salutation.click();
}
public void navigateToFname(String FirstName) {
	fname.sendKeys(FirstName);
}
public void navigateToLname(String LastName) {
	lname.sendKeys(LastName);
}
public void navigateToConorg() {
	Set<String> set=BaseClass.driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	String Cid=it.next();
	BaseClass.driver.switchTo().window(Cid);
	conOrg.click();
}
public void navigateToOrgname() {
	orgname.click();
	Set<String> set=BaseClass.driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	String Pid=it.next();
	BaseClass.driver.switchTo().window(Pid);
}
public void navigateToSave() {
	save.click();
}
}
