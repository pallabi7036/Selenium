package com.crm.genericlib1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeSuite;

import com.crm.Objectrepository.Common;
import com.crm.Objectrepository.Login;
import com.relevantcodes.extentreports.ExtentReports;

public class BaseClass {
	public static WebDriver driver;
	protected static ExtentReports extent;
	@BeforeSuite
	public void bs()
	{
		extent=new ExtentReports("‪C:\\Users\\Pallabi\\Desktop\\abc.html");
		extent.loadConfig(new File("./extent-config.xml"));
	}
	@BeforeClass(groups= {"smokeTest","regressionTest"})
//	@Parameters("browser")
	public void configBC() 
	//(String bName)
{
//		if(bName.equals("firefox"))
      driver=new FirefoxDriver();
//		else if(bName.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
//			driver=new ChromeDriver();
//		}
        System.out.println("===Launch Browser===");
	}
	@BeforeMethod(groups= {"smokeTest","regressiontest"})
		public void configBM() throws IOException
	{
		FileInputStream fis=new FileInputStream("G:\\eclipse\\Selenium\\commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String url=pobj.getProperty("URL");
		String user=pobj.getProperty("username");
		String psw=pobj.getProperty("userpassword");
		System.out.println(url);
		System.out.println(user);
		System.out.println(psw);
		System.out.println("login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Login lp=PageFactory.initElements(driver, Login.class);
		lp.login(user, psw);
		/*driver.findElement(By.name("user_name")).sendKeys(user);
		driver.findElement(By.name("user_password")).sendKeys(psw);
		driver.findElement(By.id("submitButton")).click();*/
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM()
	{
		System.out.println("logout");
		WebElement wb1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb1);
		act.perform();
		Common cm=PageFactory.initElements(driver, Common.class);
		cm.logout();
		//driver.findElement(By.linkText("Sign Out")).click();
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("===Close Browser===");
		driver.close();
	}
	@AfterSuite
	public void configAS()
	{
		extent.flush();
		extent.close();
	}

}
