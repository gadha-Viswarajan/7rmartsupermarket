package mainprojecttesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Adminusers;
import pages.Homepage;
import pages.Loginpageproject;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class Adminuserstest extends Base {
	Homepage home;
	Adminusers admin;
	FakerUtility faker = new FakerUtility();

	@Test

	public void validateWhetherUserCanAbleToSaveUsersInAdminuserPage() throws IOException {
		Loginpageproject loginpageproject = new Loginpageproject(driver);
		String username = ExcelUtility.getStringdata(1, 0, "Loginpagetest");
		String password = ExcelUtility.getStringdata(1, 1, "Loginpagetest");
		loginpageproject.enterUsernameAndPassword(username, password);
		home = loginpageproject.clickSignIn();
		admin = home.clickOnAdminuser();
		String username1 = faker.getFakeFirstName();
		String password1 = faker.getPassword();
		admin.clickOnNewButton().addUsernamePassword(username1, password1).selectValue().save();
		boolean isAlert = admin.isAlertDisplayed();
		Assert.assertTrue(isAlert, Constants.ISALERT);

	}
}
