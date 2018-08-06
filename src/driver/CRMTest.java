package driver;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.crm.genericlib.FileUtils;
import com.crm.genericlib1.BaseClass;

public class CRMTest extends BaseClass 
{
	FileUtils flib=new FileUtils();
	/*@Test
	public void CreateProduct() throws EncryptedDocumentException, InvalidFormatException, IOException {
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String Productname=flib.getExcelData("Sheet1",1, 1);
		driver.findElement(By.name("productname")).sendKeys(Productname);
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
	}
	*/

@Test
public void CreateCampaign() throws EncryptedDocumentException, InvalidFormatException, IOException
{
WebElement wb=driver.findElement(By.xpath("//a[text()='More']"));
Actions act=new Actions(driver);
act.moveToElement(wb);
act.perform();
WebElement wb1=driver.findElement(By.xpath("//a[text()='Campaigns']"));
act.moveToElement(wb1);
act.perform();
wb1.click();
WebElement wb2=driver.findElement(By.xpath("//img[@title='Create Campaign...']"));
wb2.click();
WebElement wb3=driver.findElement(By.xpath("//table[@class='small']/tbody/tr[5]/td[4]/img[@src='themes/softed/images/select.gif']"));
wb3.click();
Set<String>set=driver.getWindowHandles();
Iterator<String>itr=set.iterator();
String parentID=itr.next();
String childID=itr.next();
driver.switchTo().window(childID);
driver.findElement(By.xpath("//a[@id='1']")).click();
driver.switchTo().window(parentID);
String Campaignname=flib.getExcelData("Sheet1", 2, 1);
driver.findElement(By.name("campaignname")).sendKeys(Campaignname);
driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmButton small save']")).click();
}
@Test
public void CreateOrganization() throws EncryptedDocumentException, InvalidFormatException, IOException
{
driver.findElement(By.xpath("//a[text()='Organizations']")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
String Organizationname=flib.getExcelData("Sheet1", 3, 1);
driver.findElement(By.name("accountname")).sendKeys(Organizationname);
driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
}
@Test
public void DeleteOrganization() throws EncryptedDocumentException, InvalidFormatException, IOException
{
driver.findElement(By.xpath("//a[text()='Organizations']")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
String Organizationname=flib.getExcelData("Sheet1", 3, 1);
driver.findElement(By.name("accountname")).sendKeys(Organizationname);
driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
driver.findElement(By.name("Delete")).click();
}
@Test
public void EndToEnd() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
{
	driver.findElement(By.xpath("//a[text()='Products']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	FileUtils flib=new FileUtils();
	String Productname=flib.getExcelData("sheet1", 1, 1);
	driver.findElement(By.name("productname")).sendKeys(Productname);
	driver.findElement(By.xpath("//tr[1]/td/div/input[@class='crmbutton small save']")).click();
	Actions act=new Actions(driver);
	WebElement web=driver.findElement(By.xpath("//a[text()='More']"));
	act.moveToElement(web).perform();
	driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	String Campaignname=flib.getExcelData("sheet1", 2, 1);
	driver.findElement(By.name("campaignname")).sendKeys(Campaignname);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	Set <String> set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	String pID=it.next();
	String cID=it.next();
	driver.switchTo().window(cID);
	Thread.sleep(2000);
	driver.findElement(By.linkText(Productname)).click();
	Thread.sleep(2000);
	driver.switchTo().window(pID);
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	String Organizationname=flib.getExcelData("sheet1", 3, 1);
	driver.findElement(By.name("accountname")).sendKeys(Organizationname);
	driver.findElement(By.xpath("//tr[1]/td/div/input[@class='crmbutton small save']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//tr/td[8]/a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	String ContactPerson=flib.getExcelData("sheet1", 4, 1);
	driver.findElement(By.name("lastname")).sendKeys(ContactPerson);
	driver.findElement(By.xpath("//img[@tabindex='']")).click();
	Set<String> st = driver.getWindowHandles();
	Iterator<String> i = st.iterator();
	String PID2 = i.next();
	String CID2=i.next();
	driver.switchTo().window(CID2);
	driver.findElement(By.linkText(Organizationname)).click();
	driver.switchTo().window(PID2);
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Leads']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	String Leadname=flib.getExcelData("sheet1", 5, 1);
	driver.findElement(By.name("firstname")).sendKeys(Leadname);
	String Companyname=flib.getExcelData("sheet1", 6, 1);
	driver.findElement(By.name("company")).sendKeys(Companyname);
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	String Opportunityname=flib.getExcelData("sheet1", 7,1);
	driver.findElement(By.name("potentialname")).sendKeys(Opportunityname);
	
	/*WebElement wb1=driver.findElement(By.id("related_to_type"));
	Select sel=new Select(wb1);
	sel.selectByVisibleText("Contacts");
	driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
	Set<String> st1 = driver.getWindowHandles();
	Iterator<String> i2 = st1.iterator();
	String PID= i2.next();
	String CID=i2.next();
	driver.switchTo().window(CID);
	driver.findElement(By.linkText(contact)).click();
	driver.switchTo().window(PID);
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	*/
	WebElement wb3=driver.findElement(By.xpath("//a[text()='More']"));
	act.moveToElement(wb3).perform();
	driver.findElement(By.xpath("//a[text()='Quotes' and @id='more']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	String Quotename=flib.getExcelData("sheet1", 8, 1);
	driver.findElement(By.name("subject")).sendKeys(Quotename);
	driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
	Set<String> set3=driver.getWindowHandles();
	Iterator<String> i3= set3.iterator();
	String pID4=i3.next();
	String cID4=i3.next();
	driver.switchTo().window(cID4);
	driver.findElement(By.linkText(Organizationname)).click();
	Alert alt=driver.switchTo().alert();
	alt.accept();
	driver.switchTo().window(pID4);
	String billAddress=flib.getExcelData("sheet1", 9, 1);
	String shippingAddress=flib.getExcelData("sheet1", 10, 1);
	driver.findElement(By.name("bill_street")).sendKeys(billAddress);
	driver.findElement(By.name("ship_street")).sendKeys(shippingAddress);
	driver.findElement(By.id("searchIcon1")).click();
	Set<String> set4=driver.getWindowHandles();
	Iterator<String> i5=set4.iterator();
	String pid5=i5.next();
	String cid5=i5.next();
	driver.switchTo().window(cid5);
	driver.findElement(By.linkText(Productname)).click();
	driver.switchTo().window(pid5);
	driver.findElement(By.id("qty1")).sendKeys("4");
	driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
	WebElement web4= driver.findElement(By.xpath("//a[text()='More']"));
	act.moveToElement(web4).perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Sales Order' and @id='more']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	String Salesorder=flib.getExcelData("sheet1", 11, 1);
	driver.findElement(By.name("subject")).sendKeys(Salesorder);
	driver.findElement(By.xpath("//td[@class='dvtCellInfo']/input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
	Set<String> set6=driver.getWindowHandles();
	Iterator<String> i6= set6.iterator();
	String pID6=i6.next();
	String cID6=i6.next();
	driver.switchTo().window(cID6);
	driver.findElement(By.linkText(Organizationname)).click();
	Alert alt1=driver.switchTo().alert();
	alt1.accept();
	driver.switchTo().window(pID6);
	driver.findElement(By.name("bill_street")).sendKeys(billAddress);
	driver.findElement(By.name("ship_street")).sendKeys(shippingAddress);
	driver.findElement(By.id("searchIcon1")).click();
	Set<String> set7=driver.getWindowHandles();
	Iterator<String> i7=set7.iterator();
	String pid7=i7.next();
	String cid7=i7.next();
	driver.switchTo().window(cid7);
	driver.findElement(By.linkText(Productname)).click();
	driver.switchTo().window(pid7);
	driver.findElement(By.id("qty1")).sendKeys("4");
	driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
	WebElement wb4=driver.findElement(By.xpath("//a[text()='More']"));
	act.moveToElement(wb4).perform();
	driver.findElement(By.xpath("//a[text()='Invoice' and @id='more']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Invoice...']")).click();
	String Invoice=flib.getExcelData("sheet1", 12, 1);
	driver.findElement(By.name("subject")).sendKeys(Invoice);
	driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
	Set<String> set8=driver.getWindowHandles();
	Iterator<String> i8= set8.iterator();
	String pID8=i8.next();
	String cID8=i8.next();
	driver.switchTo().window(cID8);
	driver.findElement(By.linkText(Organizationname)).click();
	Alert alt2=driver.switchTo().alert();
	alt2.accept();
	driver.switchTo().window(pID8);
	Set<String> set9=driver.getWindowHandles();
	Iterator<String> i9=set9.iterator();
	String pid9=i9.next();
	String cid9=i9.next();
	driver.switchTo().window(cid9);
	driver.findElement(By.linkText(Productname)).click();
	driver.switchTo().window(pid9);
	String quantity=flib.getExcelData("sheet1", 13, 1);
	driver.findElement(By.id("qty1")).sendKeys(quantity);
	driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
}
}

