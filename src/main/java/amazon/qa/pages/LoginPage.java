package amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.qa.base.TestBase;

public class LoginPage extends TestBase{

	//page factory -OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath= "//button[text()='Sign Up']")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmlogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean validateCRMImage(){
		return crmlogo.isDisplayed();
	}
	public HomePage login(String un,String pwd){
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
}
