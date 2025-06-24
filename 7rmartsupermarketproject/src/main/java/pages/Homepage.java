package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	public WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	WebElement adminuserbutton;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[1]")
	WebElement managenewsbutton;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")
	WebElement managecategorybutton;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")
	WebElement managecontact;

	public ManageContact clickManagecontact() {
		managecontact.click();
		return new ManageContact(driver);

	}

	public Managecategory clickOnManageCategoryButton() {
		managecategorybutton.click();
		return new Managecategory(driver);
	}

	public Managenews clickMangeNewsButton() {
		managenewsbutton.click();
		return new Managenews(driver);
	}

	public Adminusers clickOnAdminuser() {
		adminuserbutton.click();
		return new Adminusers(driver);
	}

	public Homepage clickAdminAndLogoutButton() {

		adminbutton.click();
		logout.click();
		return this;
	}

}
