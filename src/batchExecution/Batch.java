package batchExecution;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.genericlib.FileUtils;
import com.crm.genericlib1.BaseClass;

public class Batch extends BaseClass {
	FileUtils flib=new FileUtils();
@Test(groups= {"smokeTest"})
	public void CreateProduct() throws EncryptedDocumentException, InvalidFormatException, IOException
{
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String Productname=flib.getExcelData("Sheet1",1, 1);
		driver.findElement(By.name("productname")).sendKeys(Productname);
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
	}

}
