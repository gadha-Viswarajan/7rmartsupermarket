package mainprojecttesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Adminusers;
import pages.Homepage;
import pages.Loginpageproject;
import pages.Searchadminuserinformations;
import utilities.ExcelUtility;

public class Searchadminusersinformationstesting extends Base {
	Homepage home;
	Adminusers admin;
	Searchadminuserinformations search;

	@Test
	public void verifyUserCanSearchTheInformationsDataFromSearchPage() throws IOException {
		Loginpageproject loginpageproject = new Loginpageproject(driver);
		String username = ExcelUtility.getStringdata(1, 0, "Loginpagetest");
		String password = ExcelUtility.getStringdata(1, 1, "Loginpagetest");
		loginpageproject.enterUsernameAndPassword(username, password);
		String username1 = ExcelUtility.getStringdata(1, 0, "Searchadminusersinformationstes");
		home = loginpageproject.clickSignIn();
		admin = home.clickOnAdminuser();
		search = admin.searchButton();
		search.enterUsername(username1).selectUserType().search();
		boolean IsResult = search.isResultDisplayed();
		Assert.assertTrue(IsResult, Constants.ISRESULT);

		/*
		 * Searchadminuserinformations searchadminuserinformations=new
		 * Searchadminuserinformations(driver);
		 * searchadminuserinformations.clickOnSearchButton();
		 * searchadminuserinformations.enterUsername("Gadha");
		 * searchadminuserinformations.selectUserType();
		 * searchadminuserinformations.search();
		 */

	}
}
