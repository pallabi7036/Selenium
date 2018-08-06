package assignment7;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericlib.FileUtils;
import com.crm.genericlib1.BaseClass;
@Test
@Listeners
public class Product extends BaseClass{
	FileUtils flib=new FileUtils();
	public void createProductTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String Productname=flib.getExcelData("Sheet1", 1, 1);
		String expTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		
	    com.crm.Objectrepository.Product pro=PageFactory.initElements(driver, com.crm.Objectrepository.Product.class);
		pro.navigateToProduct();
		pro.navigateToLookup();
		pro.navigateToProductname(Productname);
		pro.navigateToSave();
		

	}

}
