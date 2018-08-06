package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
@FindBy(linkText="Calendar")
private WebElement calender;
@FindBy(linkText="Leads")
private WebElement leads;
@FindBy(linkText="Organizations")
private WebElement organizations;
@FindBy(linkText="Contacts")
private WebElement contacts;
@FindBy(linkText="Opportunities")
private WebElement opporunities;
@FindBy(linkText="Products")
private WebElement products;
@FindBy(linkText="Documents")
private WebElement documents;
@FindBy(linkText="Email")
private WebElement email;
@FindBy(linkText="Trouble Tickets")
private WebElement TT;
@FindBy(linkText="Dashboard")
private WebElement dashboard;
@FindBy(xpath="//a[text()='More']")
private WebElement more;

public void navigateToCalender()
{
	calender.click();
}
public void navigateToLeads() {
	leads.click();
}
public void navigateToOrganizations() {
	organizations.click();
}
public void navigateToContacts() {
	contacts.click();
}
public void navigateToOpportunity() {
	opporunities.click();
}
public void navigateToProducts() {
	products.click();
}
public void navigateToDocuments() {
	documents.click();
}
public void navigateToEmail() {
	leads.click();
}
public void navigateToTT() {
	TT.click();
}
public void navigateToDashboard() {
	dashboard.click();
}
public void navigateToMore() {
	more.click();
}
}
