package mainprojecttesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Homepage;
import pages.Loginpageproject;
import utilities.ExcelUtility;

public class Logintest extends Base {

	Homepage home;

	@Test(groups = {"smoke test"})
	public void validateWhetherUserCanAbleToLoginWithValidCredentials() throws IOException {

		Loginpageproject loginpageproject = new Loginpageproject(driver);
		String username = ExcelUtility.getStringdata(1, 0, "Loginpagetest");
		String password = ExcelUtility.getStringdata(1, 1, "Loginpagetest");
		loginpageproject.enterUsernameAndPassword(username, password);
		home = loginpageproject.clickSignIn();
		boolean isDashboard = loginpageproject.isDashBoardLoaded();
		Assert.assertTrue(isDashboard, Constants.ISDASHBOARD);

	}

	@Test(groups = {"smoke test"})
	public void ValidateWhetherUserCantAbleToLoginWithInvalidCredentials() {
		Loginpageproject loginpageproject = new Loginpageproject(driver);
		loginpageproject.enterUsernameAndPassword("adminnn", "admin123");
		loginpageproject.clickSignIn();
	}

	@Test
	@Parameters({ "username", "password" })
	public void parameterViaLogin(String username, String password) {
		Loginpageproject loginpageproject = new Loginpageproject(driver);
		loginpageproject.enterUsernameAndPassword(username, password);
		loginpageproject.clickSignIn();
	}

	@Test(dataProvider = "credentials",groups = {"regression testing"})
	public void dataprovider(String username, String password) {
		Loginpageproject loginpageproject = new Loginpageproject(driver);
		loginpageproject.enterUsernameAndPassword(username, password);
		loginpageproject.clickSignIn();
	}

	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" }, { "admin123", "admin" } };
		return data;
	}
}
