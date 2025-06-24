package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContact {
	public WebDriver driver;

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement actionbutton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	WebElement deliverytime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliverychargelimit;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement update;

	public ManageContact clickOnactionButton() {
		actionbutton.click();
		return this;
	}

	public ManageContact enterPhonenumber(String phonefield) {
		phone.sendKeys(phonefield);
		return this;
	}

	public ManageContact enterEmailAddress(String emailfield) {
		email.sendKeys(emailfield);
		;
		return this;
	}

	public ManageContact enterAddress(String addressfield) {
		address.sendKeys(addressfield);
		return this;
	}

	public ManageContact enterDeliverytime(String Value) {
		deliverytime.sendKeys(Value);
		return this;
	}

	public ManageContact enterDeliveryChargeLimit(String deliverychargelimitfield) {
		deliverychargelimit.sendKeys(deliverychargelimitfield);
		return this;
	}

	public ManageContact clickOnUpdateButton() {
		update.click();
		return this;
	}
}
