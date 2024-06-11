package demowebshop_GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import demowebshop_GenericUtility.BaseClass_Demoshop;
import demowebshop_GenericUtility.JavaUtilityDemoshop;
import demowebshop_GenericUtility.PropertyUtilityDemoshop;
import demowebshop_GenericUtility.WebUtilityDemoshop;

public class ListenersImplementationDemoshop implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"---Started---",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"---Success---",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"---Failed---",true);
		WebUtilityDemoshop webutil=new WebUtilityDemoshop();
		JavaUtilityDemoshop jutil=new JavaUtilityDemoshop();
		String screenshotname = methodname+" "+jutil.toGenerateSystemTimeDate();
		try {
			webutil.toTakeScreenshot(BaseClass_Demoshop.sdriver, screenshotname);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"---Skipped---",true);
	}

	@Override
	public void onStart(ITestContext context) {
		
		Reporter.log("---Suite Execution Start---",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		Reporter.log("---Suite ExecutionFinished---",true);
	}
	

}
