package assignment7;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Objectrepository.Contact;
import com.crm.Objectrepository.Lead;
//import com.crm.Objectrepository.Home;
import com.crm.Objectrepository.Organizations;
import com.crm.genericlib.FileUtils;
import com.crm.genericlib1.BaseClass;

@Listeners
public class EndToEnd extends BaseClass {
	FileUtils flib=new FileUtils();
	@Test
			public void createQuote() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
			{
				Random randomNum = new Random();
				int rString = randomNum.nextInt(100);
				String Organizationname=flib.getExcelData("sheet1", 3, 1);
				String Organizationname1= (Organizationname+rString);
				
				//create product
				
				String Productname=flib.getExcelData("Sheet1", 1, 1);
				String expTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
				String actTitle=driver.getTitle();
				Assert.assertEquals(actTitle, expTitle);
				
			    com.crm.Objectrepository.Product pro=PageFactory.initElements(driver, com.crm.Objectrepository.Product.class);
				pro.navigateToProduct();
				pro.navigateToLookup();
				pro.navigateToProductname(Productname);
				pro.navigateToSave();
				
				//creating organization
				String newOrganizationname=flib.getExcelData("sheet1", 3, 1);
			    Organizations org=PageFactory.initElements(driver, Organizations.class);
			    org.navigateToOrganizationPage();
			    org.navigateToLookupImage();
			    org.Organizations(newOrganizationname);
			    org.navigateToSave();
			     Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			org.navigateToBox();
			org.navigateToDelete();
			//for pop-up handle
			Alert alt=driver.switchTo().alert();
			alt.accept();
				
				
				//creating campaign
			String Campaignname=flib.getExcelData("Sheet1", 2, 1);
			com.crm.Objectrepository.Campaigns camp=PageFactory.initElements(driver, com.crm.Objectrepository.Campaigns.class);
		    camp.navigateToMore();
		    camp.navigateToCampaigns();
		    camp.navigateToLookup();
		    camp.navigateToCampaignName(Campaignname);
		    camp.navigateToSave();				
				
				//creating contacts
				String Fname=flib.getExcelData("Sheet1", 5, 1);
				String Lname=flib.getExcelData("Sheet1",6, 1);
				Contact con=PageFactory.initElements(driver, Contact.class);
				con.navigateToContacts();
				con.navgateToLookup();
				con.navigateToSalutation();
				con.navigateToFname(Fname);
				con.navigateToLname(Lname);
				con.navigateToSave();
				con.navigateToConorg();
				con.navigateToOrgname();
				con.navigateToSave();
				//con.createContacts(contact,Organizationname1);
				
				
				//create leads
				String Fname1=flib.getExcelData("sheet1", 5, 1);
				String Lname1=flib.getExcelData("sheet1", 6, 1);
				Lead ld=PageFactory.initElements(driver, Lead.class);
				ld.navigateToLeads();
				ld.navgateToLookup();
				ld.navigateToFname(Fname1);
				ld.navigateToLname(Lname1);
				ld.navigateToSave();
			
				//creating opportunity
			String Opportunityname=flib.getExcelData("Sheet1", 9, 1);
			
			/*home.navigateToOpportunitiesPage();
			CreateOpportunities opp=PageFactory.initElements(driver, CreateOpportunities.class);
			opp.createOpportunities(oppName,contact);
			
			//create Quotes
			/*home.goToMoreLink();
			home.navigateToQuotesPage();
			String quoteName=flib.getExcelData("sheet1", 7, 2);
			String billAddress=flib.getExcelData("sheet1", 7, 3);
			String shippingAddress=flib.getExcelData("sheet1", 7, 4);
			CreateQuotes quote=PageFactory.initElements(driver, CreateQuotes.class);
			quote.createQuotes(quoteName,proName,billAddress,shippingAddress);
			
			//create sales order
			home.goToMoreLink();
			home.navigateToSalesOrderPage();
			String ordereName=flib.getExcelData("sheet1", 8, 2);
			SalesOrder SO=PageFactory.initElements(driver, SalesOrder.class);
			SO.createSalesOrder(ordereName,newOrgName,billAddress,shippingAddress,proName);
			
			//create invoice
			home.goToMoreLink();
			home.navigateToInvoicePage();
			CreateInvoice crInvoice=PageFactory.initElements(driver, CreateInvoice.class);
			String invoiceName=flib.getExcelData("sheet1", 9, 2);
			crInvoice.createInvoice(invoiceName,newOrgName,proName,billAddress,shippingAddress);*/
			}	
}
