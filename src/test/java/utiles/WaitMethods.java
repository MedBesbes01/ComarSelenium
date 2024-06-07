package utiles;                                                                                                                                                                                                                    

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitMethods {

	WebDriverWait waitExplicit;

	public void implicitWait(WebDriver driver, long second) {
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.MILLISECONDS);
	}


	public WebElement explicitWaitUntilPresenceOfElementLocatedXpath(WebDriver driver, String locator, long second) {
		WebElement wElement;
		waitExplicit = new WebDriverWait(driver, second);
		wElement = waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		return wElement;
	}
	
	


}
