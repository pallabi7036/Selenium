package assignment7;

import java.io.IOException;
//import java.util.Iterator;
//import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.crm.Objectrepository.Organizations;
import com.crm.genericlib.FileUtils;
import com.crm.genericlib1.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;

@Listeners(com.crm.genericlib1.Listener.class)//fully qualified class name
public class Campaigns extends BaseClass {
	
	FileUtils flib=new FileUtils();
	@Test
	public void createcampaignsTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	
	String Campaignname=flib.getExcelData("Sheet1", 2, 1);
		String expTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actTitle=driver.getTitle();
	    Assert.assertEquals(actTitle, expTitle);
	    com.crm.Objectrepository.Campaigns camp=PageFactory.initElements(driver, com.crm.Objectrepository.Campaigns.class);
	    camp.navigateToMore();
	    camp.navigateToCampaigns();
	    camp.navigateToLookup();
	    camp.navigateToCampaignName(Campaignname);
	    camp.navigateToSave();
	   
	}  
}