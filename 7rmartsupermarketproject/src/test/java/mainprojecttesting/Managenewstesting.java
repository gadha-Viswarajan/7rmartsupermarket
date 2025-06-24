package mainprojecttesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Homepage;
import pages.Loginpageproject;
import pages.Managenews;
import utilities.ExcelUtility;

public class Managenewstesting extends Base 
{
Homepage home;
Managenews manage;

@Test(retryAnalyzer = retry.Retry.class)
public void verifyUserCanAbleToClickManageNewsButton() throws IOException
{
	Loginpageproject loginpageproject=new Loginpageproject(driver);
	String username=ExcelUtility.getStringdata(1, 0, "Loginpagetest");
	String password=ExcelUtility.getStringdata(1, 1, "Loginpagetest");
	String newsfield=ExcelUtility.getStringdata(1, 0,"Managenews");
	loginpageproject.enterUsernameAndPassword(username,password);
	home=loginpageproject.clickSignIn();
	manage=home.clickMangeNewsButton();
	manage.clickNewButton().sendDataOnNewsField(newsfield).clickSaveButton();
	boolean isAler=manage.isAlertDisplayed();
	Assert.assertTrue(isAler,Constants.ISALERT);
}
}
