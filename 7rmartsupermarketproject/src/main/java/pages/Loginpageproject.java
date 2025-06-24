package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpageproject {
	public WebDriver driver;

	public Loginpageproject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement login;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;

	public Loginpageproject enterUsernameAndPassword(String usernamefield, String passwordfield) {
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;
	}

	public Homepage clickSignIn() {
		login.click();
		return new Homepage(driver);
	}

	public boolean isDashBoardLoaded() {
		return dashboard.isDisplayed();
	}
}
