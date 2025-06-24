package mainprojecttesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Loginpageproject;
import utilities.ExcelUtility;
import pages.Homepage;

public class Homepagetesting extends Base
{
Homepage home;

@Test
public void valiodateWhetherUserCanLogoutTheApplicationSuccessfully() throws IOException
{
	Loginpageproject loginpageproject=new Loginpageproject(driver);
	String username=ExcelUtility.getStringdata(1, 0, "Loginpagetest");
	String password=ExcelUtility.getStringdata(1, 1, "Loginpagetest");
	loginpageproject.enterUsernameAndPassword(username, password);
	home=loginpageproject.clickSignIn();
	home.clickAdminAndLogoutButton();
	String expected="Login | 7rmart supermarket";
	String actual=driver.getTitle();
	Assert.assertEquals(expected,actual,Constants.ISTITLEMATCHED);
	/*loginpageproject.clickSignIn();
	Homepage homepage=new Homepage(driver);
	homepage.clickAdminAndLogoutButton();*/
	
}
}
