package TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;
import TestBase.BaseClass;

public class   extends  BaseClass{
	
	@Test
	public void TC_001_AccountRegistraionTest()
	{
		
		l.info("*******starting TC_001_AccountRegistraionTest********");
		HomePage hp=new HomePage(driver);
		l.info("clicking my account");
		hp.clkacc();
		hp.clkreg();
		AccountRegistrationPage rp=new AccountRegistrationPage(driver);
		l.info("registration details");
		rp.setfn(randomeString().toUpperCase());
		rp.setln(randomeString().toUpperCase());
		rp.setem(randomeString()+"@gmail.com");
		rp.settp(randomeNumber());
		String p=alphanumeric();
		rp.setpwd(p);
		rp.setcfm(p);
		l.info("Check policy");
		rp.policy();
		l.info("click button");
		rp.btnclk();
		l.info("Check confirmation message");
		String cm=rp.cfmmsg();
		Assert.assertEquals(cm, "Your Account Has Been Created!");
		l.info("*******finish TC_001_AccountRegistraionTest********");
	}


}
