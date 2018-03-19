package amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.qa.base.TestBase;
import amazon.qa.pages.ContactsPage;
import amazon.qa.pages.HomePage;
import amazon.qa.pages.LoginPage;
import amazon.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	public HomePageTest(){
	super();
}
@BeforeMethod
public void setUp(){
	initialization();
	testUtil=new TestUtil();
	loginPage= new LoginPage();
	homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}
@Test(priority=1)
public void verifyHomePageTitleTest(){
	String title=homePage.verifyHomePageTitle();
	Assert.assertEquals(title, "CRMPRO","Home Page title not matched");
}
@Test(priority=2)
public void verifyUsernameTest(){
	testUtil.switchToFrame();
	Assert.assertTrue(homePage.verifyUsername());
}
@Test(priority=3)
public void verifyContactsLinkTest(){
	testUtil.switchToFrame();
	contactsPage=homePage.clickonContacts();
}
@AfterMethod
public void TearDown(){
	driver.quit();
}
}
