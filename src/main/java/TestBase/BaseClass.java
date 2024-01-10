package TestBase;

import java.time.Duration;
import java.util.ResourceBundle;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	private static final String OutputType = null;
	public WebDriver driver;
	public ResourceBundle rb;
	public Logger l;
	@BeforeClass
	public void setup()
	{
		rb= ResourceBundle.getBundle("config");
	
		l=LogManager.getLogger(this.getClass());
		
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumAll\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//url
			driver.get(rb.getString("appURL"));
			driver.manage().window().maximize(); 
	}
	@AfterClass
	public void td()
	{
		driver.close();
	}
	
	public String randomeString()
	
	{
		

		String genstr=RandomStringUtils.randomAlphabetic(5);
		return genstr;
		
	}
	public String randomeNumber()
	{
		String genNum=RandomStringUtils.randomNumeric(10);
		return genNum;
	}
	public String alphanumeric()
	{
		String genstr=RandomStringUtils.randomAlphabetic(5);
		String genNum=RandomStringUtils.randomNumeric(10);
		return (genstr+genNum);
}
public String CaptureScreen(String tname)throws IOException
{
	String timestmp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
TakesScreenshot tsh=(TakesScreenshot)driver;
Object outputType;
File src=tsh.getScreenshotAs(OutputType.FILE);
String ds=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestmp+".png";
try
{
	FileUtils.copyFile(src,new File( ds));
}
catch (Exception e)
{
	e.getMessage();
}
return ds;
}
public String captureScreen(String name) {
	// TODO Auto-generated method stub
	return null;
}
}
