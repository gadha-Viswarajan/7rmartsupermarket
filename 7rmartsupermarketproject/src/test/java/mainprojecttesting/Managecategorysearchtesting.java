package mainprojecttesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Homepage;
import pages.Loginpageproject;
import pages.Managecategory;
import pages.Managecategorysearch;
import utilities.ExcelUtility;

public class Managecategorysearchtesting extends Base {
	Homepage home;
	Managecategory category;
	Managecategorysearch search;

	@Test
	public void verifyUserCanClickSearchButton() throws IOException {
		Loginpageproject loginpageproject = new Loginpageproject(driver);
		String username = ExcelUtility.getStringdata(1, 0, "Loginpagetest");
		String password = ExcelUtility.getStringdata(1, 1, "Loginpagetest");
		loginpageproject.enterUsernameAndPassword(username, password);
		String categoryfield = ExcelUtility.getStringdata(1, 0, "Managecategorysearch");
		home = loginpageproject.clickSignIn();
		category = home.clickOnManageCategoryButton();
		search = category.clickSearchButton();
		search.inputCategoryField(categoryfield).finalsearchbutton();
		boolean isList = search.isListDisplayed();
		Assert.assertTrue(isList, Constants.ISLIST);
	}
}
