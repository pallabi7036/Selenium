package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.genericlib1.BaseClass;

public class Common {
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement element;
	@FindBy(linkText="Sign Out")
	private WebElement logout;
	public void logout() {
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(element);
		act.perform();
		logout.click();
	}

}
