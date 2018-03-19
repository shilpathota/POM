package amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import amazon.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement CompanyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement Savebtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	public void selectContacts(String name){
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
	}
	public void createNewContact(String title,String ftname, String ltname,String compName){
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftname);
		LastName.sendKeys(ltname);
		CompanyName.sendKeys(compName);
		Savebtn.click();
	}


}
