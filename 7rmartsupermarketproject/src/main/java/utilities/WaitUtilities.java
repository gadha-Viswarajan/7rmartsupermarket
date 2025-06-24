package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities 
{
WebDriver driver;
public void elementtoBeClick(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void elementToBeSelect(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}
public void elementSelectionStateToBe(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
}
public void numberOfElementsToBe(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.numberOfElementsToBe(null, null));
}
public void numberOfWindowsToBe(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.numberOfWindowsToBe(0));
}

}
