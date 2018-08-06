package assignment7;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Objectrepository.Organizations;
import com.crm.genericlib.FileUtils;
import com.crm.genericlib1.BaseClass;
@Listeners
public class Organization extends BaseClass {
	FileUtils flib=new FileUtils();
	@Test
	public void createorganizationTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		
		String Organizationname=flib.getExcelData("sheet1", 3, 1);
        String expTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actTitle=driver.getTitle();
		//System.out.println(actTitle);
	    Assert.assertEquals(actTitle, expTitle);
	    Organizations org=PageFactory.initElements(driver, Organizations.class);
	    org.navigateToOrganizationPage();
	    org.navigateToLookupImage();
	    org.Organizations(Organizationname);
	    org.navigateToSave();
	     Thread.sleep(2000);
	driver.navigate().back();
	driver.navigate().back();
	org.navigateToBox();
	org.navigateToDelete();
	//for pop-up handle
	Alert alt=driver.switchTo().alert();
	alt.accept();
}
}