package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managenews {
	public WebDriver driver;

	public Managenews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public Managenews clickNewButton() {
		newbutton.click();
		return this;
	}

	public Managenews sendDataOnNewsField(String newsfieldmessage) {
		newsfield.sendKeys(newsfieldmessage);
		return this;
	}

	public Managenews clickSaveButton() {
		savebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
