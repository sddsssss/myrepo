package Utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.*;
import TestBase.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportUtility implements ITestListener {
	
	
	public ExtentSparkReporter sp;
	public ExtentReports er;
	public ExtentTest et;
	String repname;
	  
	public void onStart(ITestContext c)
	{
		String timestmp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname="Test-Report" +"timestmp" +".html";
		
		sp=new ExtentSparkReporter("file:///C:/Users/Jawwad/Desktop/javaeclip/mavenp/src/main/java/day41/report.html");
		sp.config().setReportName("functional report");
		sp.config().setDocumentTitle("Auomtion report");
		sp.config().setTheme(Theme.DARK);
	er=new ExtentReports();

	er.attachReporter(sp);
	er.setSystemInfo("computer name", "mypc");
	er.setSystemInfo("Environment", "QA");
	er.setSystemInfo("OS", "window8");
	er.setSystemInfo("Tester name", "sds");
	er.setSystemInfo("Browser", "chrome,edge,firefox");
	}



	public void onTestSucess(ITestResult r)
	{
		et=er.createTest(r.getName());
		et.log(Status.FAIL, "test fail is"+r.getName());
		et.log(Status.FAIL, "test fail cause is"+r.getThrowable());
	}

	public void onTestFailure1(ITestResult r)
	{
		et=er.createTest(r.getName());
		et.log(Status.FAIL, "test fail is"+r.getName());
try
{
	String imgp=new BaseClass().captureScreen(r.getName());
	et.addScreenCaptureFromPath(imgp);
}
catch(Exception e)
{
	e.printStackTrace();
}
	}
	public void onFinish(ITestResult r)
	{
		er.flush();
	}
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	}


