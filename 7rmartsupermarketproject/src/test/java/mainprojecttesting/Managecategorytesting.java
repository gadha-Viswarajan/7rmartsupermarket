package mainprojecttesting;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Homepage;
import pages.Loginpageproject;
import pages.Managecategory;
import utilities.ExcelUtility;

public class Managecategorytesting extends Base {
	Homepage home;
	Managecategory category;

	@Test

	public void validateWhetherUserCanClickManageCategoryButton() throws AWTException, IOException {
		Loginpageproject loginpageproject = new Loginpageproject(driver);
		String username = ExcelUtility.getStringdata(1, 0, "Loginpagetest");
		String password = ExcelUtility.getStringdata(1, 1, "Loginpagetest");
		loginpageproject.enterUsernameAndPassword(username, password);
		String categorycolumn = ExcelUtility.getStringdata(1, 0, "Managecategory");
		home = loginpageproject.clickSignIn();
		category = home.clickOnManageCategoryButton();
		category.clickNewButton().enterTheCategory(categorycolumn).clickOnSelectGroup().clickOnChooseFile()
				.scrollWindow().clickOnSaveButton();
		boolean isAlert = category.isAlertDisplayed();
		Assert.assertTrue(isAlert, Constants.ISALERT);
	}
}
