package amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.qa.base.TestBase;
import amazon.qa.pages.HomePage;
import amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
	}
	@Test(priority=1)
	public void LoginPage_TitleTest(){
		String Actual_title=loginPage.validateLoginPageTitle();
		Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", Actual_title);
	}
	@Test(priority=2)
	public void crmLogo_ImageTest(){
		boolean isExist=loginPage.validateCRMImage();
		Assert.assertTrue(isExist);
	}
	@Test(priority=3)
	public void loginTest(){
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
