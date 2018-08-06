package com.crm.genericlib1;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String failedtestName=result.getMethod().getMethodName();
		System.out.println("test fail==>"+failedtestName);
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.driver);
		File sfile=edriver.getScreenshotAs(OutputType.FILE);
		File dfile=new File("./screenshot/"+failedtestName+".png");
		try {
			org.apache.commons.io.FileUtils.copyFile(sfile, dfile);
		}
		catch(IOException e)
		{
			
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}