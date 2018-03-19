package amazon.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.qa.base.TestBase;
import amazon.qa.pages.ContactsPage;
import amazon.qa.pages.HomePage;
import amazon.qa.pages.LoginPage;
import amazon.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
public ContactsPageTest(){
	super();
}
@BeforeMethod
public void setUp(){
	initialization();
	testUtil=new TestUtil();
	loginPage= new LoginPage();
	homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtil.switchToFrame();
	contactsPage=homePage.clickonContacts();
}
@Test(priority=1)
public void verifyContactsPageLabelTest(){
	Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts Label is not visible");
}
@Test(priority=2)
public void selectContactsTest(){
	contactsPage.selectContacts("Aamy");
}
@Test(priority=3)
public void selectMultipleContactsTest(){
	contactsPage.selectContacts("Aamy");
	contactsPage.selectContacts("abc");
}
@Test(priority=4)
public void validateCreateNewContact(){
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		contactsPage=homePage.clickNewContactsLink();
		contactsPage.createNewContact("Mr.", "tommy", "Jerry", "Google");
}
@AfterMethod
public void TearDown(){
	driver.quit();
}
}
