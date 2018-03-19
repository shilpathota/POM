package amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement UsernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public boolean verifyUsername(){
		return UsernameLabel.isDisplayed();
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	public ContactsPage clickonContacts(){
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickonDeals(){
		DealsLink.click();
		return new DealsPage();
	}
	public ContactsPage clickNewContactsLink(){
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink);
		newContactLink.click();
		return new ContactsPage();
	}
	public TasksPage clickonTasks(){
		TasksLink.click();
		return new TasksPage();
	}
}
