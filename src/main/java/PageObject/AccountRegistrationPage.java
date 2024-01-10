package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
		@FindBy(name="firstname")
		WebElement fn;
		@FindBy(name="lastname")
		WebElement ln;
		@FindBy(name="email")
		WebElement email;
		@FindBy(name="telephone")
		WebElement tel;
		@FindBy(name="password")
		WebElement pwd;
		@FindBy(name="confirm")
		WebElement cfm;
		@FindBy(name="agree")
		WebElement chkpolicy;
		@FindBy(xpath="//input[@value='Continue']")
		WebElement btnc;
		
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement cmsg;
		 
		
		public void setfn(String fname)
		{
		fn.sendKeys(fname);
		}
		public void setln(String lname)
		{
		ln.sendKeys(lname);
		}
		public void setem(String em)
		{
		email.sendKeys(em);
		}
		public void settp(String tp)
		{
		tel.sendKeys(tp);
		}
		public void setpwd(String pw)
		{
		pwd.sendKeys(pw);
		}
		public void setcfm(String cfn)
		{
		cfm.sendKeys(cfn);
		}
		public void policy()
		{
		chkpolicy.click();
		}
		public void btnclk()
		{
		btnc.click();
		}
		public String cfmmsg()
		{
			try
			{
			return (cmsg.getText());
		}
			catch(Exception e)
			{
				return (e.getMessage());
			}
			}
}
