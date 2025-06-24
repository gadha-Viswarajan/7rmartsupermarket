package mainprojecttesting;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.Loginpageproject;
import pages.ManageContact;
import utilities.ExcelUtility;

public class ManageContactTesting extends Base {
	Homepage home;
	ManageContact contact;

	@Test(retryAnalyzer = retry.Retry.class)
	public void ValidateWhetherUserCanManageContacts() throws IOException {
		Loginpageproject loginpageproject = new Loginpageproject(driver);
		String username = ExcelUtility.getStringdata(1, 0, "Loginpagetest");
		String password = ExcelUtility.getStringdata(1, 1, "Loginpagetest");
		loginpageproject.enterUsernameAndPassword(username, password);
		home = loginpageproject.clickSignIn();
		String phone = ExcelUtility.getStringdata(1, 0, "Managecontact");
		String email = ExcelUtility.getStringdata(1, 1, "Managecontact");
		String address = ExcelUtility.getStringdata(1, 2, "Managecontact");
		String deliverytime = ExcelUtility.getStringdata(1, 3, "Managecontact");
		String deliverychargelimit = ExcelUtility.getStringdata(1, 4, "Managecontact");

		contact = home.clickManagecontact();
		contact.clickOnactionButton().enterPhonenumber(phone).enterEmailAddress(email).enterAddress(address)
				.enterDeliverytime(deliverytime).enterDeliveryChargeLimit(deliverychargelimit).clickOnUpdateButton();
	}
}
