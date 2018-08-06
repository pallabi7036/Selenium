package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product {
@FindBy(xpath="//a[text()='Products']")
private WebElement prod;
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement crprod;
@FindBy(name="productname")
private WebElement prname;
@FindBy(xpath="//tr[1]/td/div/input[@class='crmbutton small save']")
private WebElement save;

public void navigateToProduct() {
prod.click();
}
public void navigateToLookup() {
	crprod.click();
}
public void navigateToProductname(String Productname1) {
	prname.sendKeys(Productname1);
}
public void navigateToSave() {
	save.click();
}
}
