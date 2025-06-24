package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtilities;

public class Managecategory {
	public WebDriver driver;
	FileUploadUtility file = new FileUploadUtility();
	PageUtilities page = new PageUtilities();

	public Managecategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categorycolumn;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectgroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public Managecategorysearch clickSearchButton() {
		searchbutton.click();
		return new Managecategorysearch(driver);
	}

	public Managecategory clickNewButton() {
		newbutton.click();
		return this;
	}

	public Managecategory enterTheCategory(String categorycolumnfield) {
		categorycolumn.sendKeys(categorycolumnfield);
		return this;
	}

	public Managecategory clickOnSelectGroup() {
		selectgroup.click();
		return this;
	}

	public Managecategory scrollWindow() {
		// page.scrolldown();
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0,1000)");
		return this;
	}

	public Managecategory clickOnChooseFile() {
		// choosefile.click();
		// choosefile.sendKeys("C:\\Users\\GADHA
		// VM\\Downloads\\orange_crush_514795.jpg");
		file.sendKeysForFileUpload(choosefile, Constants.IMGPATH);
		return this;
	}
	/*
	 * public Managecategory robotClassForFiles()throws AWTException {
	 * choosefile.click(); StringSelection string=new
	 * StringSelection("C:\\Users\\GADHA VM\\Downloads\\orange_crush_514795.jpg");
	 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string,null);
	 * Robot robot=new Robot(); robot.delay(1000);
	 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
	 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyRelease(KeyEvent.VK_V);
	 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	 * return this;
	 * 
	 * }
	 */

	public Managecategory clickOnSaveButton() {
		// page.scrolldown();
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", submitbutton);
		// submitbutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
