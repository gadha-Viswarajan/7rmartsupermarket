package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Searchadminuserinformations {
	public WebDriver driver;

	public Searchadminuserinformations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement username;
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	WebElement usertype;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement finalsearch;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement result;

	public Searchadminuserinformations enterUsername(String usernamefield) {
		username.sendKeys(usernamefield);
		return this;
	}

	public Searchadminuserinformations selectUserType() {
		Select select = new Select(usertype);
		select.selectByValue("staff");
		return this;
	}

	public Searchadminuserinformations search() {
		finalsearch.click();
		return this;
	}

	public boolean isResultDisplayed() {
		return result.isDisplayed();
	}
}
