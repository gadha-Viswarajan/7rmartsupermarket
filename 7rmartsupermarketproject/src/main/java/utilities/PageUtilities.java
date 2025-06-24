package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtilities 
{
WebDriver driver;
public void selectByIndex( WebElement element,Integer value)//value is the selected value from dropdown.
	{

	Select select=new Select(element);
	select.selectByIndex(value);
	}
public void selectByValue(WebElement element,String Value)
{
	Select select=new Select(element);
	select.selectByValue(Value);
}
public void selectByVisibleText(WebElement element,String value)
{
	Select select=new Select(element);
	select.selectByVisibleText(value);
}
public void Actions(WebElement element)
{
	Actions actions=new Actions(driver);
	actions.moveToElement(element).click();
	actions.doubleClick(element).perform();
}
public void scrolldown()
{
	JavascriptExecutor javascript=(JavascriptExecutor)driver;
	javascript.executeScript("window.scrollBy(0,1000)", "");

}
public void scrollup()
{
	JavascriptExecutor javascript=(JavascriptExecutor)driver;
	javascript.executeScript("window.scrollBy(0,-1000)", "");
}
}

