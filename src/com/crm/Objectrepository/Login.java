package com.crm.Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	@FindBy(name="user_password")
	private WebElement UserpwdEdt;
	@FindBy(id="submitButton")
	private WebElement Userlogin;
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}
	public WebElement getUserpwdEdt() {
		return UserpwdEdt;
	}
	public WebElement getUserlogin() {
		return Userlogin;
	}
	public void login(String username, String userpassword)
	{
		UsernameEdt.sendKeys(username);
		UserpwdEdt.sendKeys(userpassword);
		Userlogin.click();
	}
	
	
	

}
