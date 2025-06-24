package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adminusers {
	public WebDriver driver;

	public Adminusers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	WebElement selectbutton;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement savebutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public Searchadminuserinformations searchButton() {
		searchbutton.click();
		return new Searchadminuserinformations(driver);
	}

	public Adminusers clickOnNewButton() {
		newbutton.click();
		// wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.elementToBeClickable(newbutton));
		return this;
	}

	public Adminusers addUsernamePassword(String usernamefield, String passwordfield) {
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;
	}

	public Adminusers selectValue() {
		Select select = new Select(selectbutton);
		select.selectByIndex(3);
		return this;
	}

	public Adminusers save() {
		savebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
