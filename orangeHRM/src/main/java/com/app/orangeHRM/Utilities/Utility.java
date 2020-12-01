package com.app.orangeHRM.Utilities;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility implements WebDriver {
	
	public WebDriver driver;
	WebElement element;
	
	public Utility(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//This method will handle synchronization issue- it will wait for the webelement
	public static WebElement WaitForWebElement(WebDriver driver, By bylocator) {
		WebDriverWait wait=new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bylocator));
		return element;
		}
	
	public static WebElement WaitForWebElement(WebDriver driver, By bylocator,int time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bylocator));
		return element;
		}
	
	public static WebElement WaitForWebElement(WebDriver driver, WebElement webelement,int time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
		highLightElement(driver,element);
		return element;
		}
	
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",element);
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');",element);
	}
	
	public static List<WebElement> waitForMultipleWebElement(WebDriver driver, By bylocator) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		List<WebElement> allElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bylocator));
		return allElement;
	}
	
	public static List<WebElement> waitForMultipleWebElement(WebDriver driver, By bylocator,int time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		List<WebElement> allElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bylocator));
		return allElement;
	}
	
	public static void acceptAlert(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}
	
	public static void dismissAlert(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	
	public static void verifyAlertText(WebDriver driver,String expectedText) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		String alert_text_actual = wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertEquals(alert_text_actual, expectedText);
	}
	
	public static void verifyTitle(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(title)));
	}
	
	public static void verifyTitleContains(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		Assert.assertTrue(wait.until(ExpectedConditions.titleContains(title)));
	}
	
	public static void verifyURL(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(url)));
	}
	
	public static void verifyURLcontains(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
	}
	
	public static void SelectValueFromCalender(List<WebElement> elements, String values) {
		for(WebElement ele:elements) {
			String data = ele.getText();
			if(data.equalsIgnoreCase(values)) {
				ele.click();
				break;
			}
		}
	}
	public void CustomListBoxGetText(By locatorName, String expectedvalue) {
		List<WebElement> allOptions = driver.findElements(locatorName);
		//int count = allOptions.size();
		//System.out.println("No of values present in the dropdownList: "+count);
		for(WebElement option:allOptions) {
			String text = option.getText();
			//System.out.println(text);
			if(text.equalsIgnoreCase(expectedvalue)) {
				option.click();
				break;
			}
		}
	}
	public void selectDateFromCalendar(By locatorName, String dateValue) {
		List<WebElement> allDates = driver.findElements(locatorName);
		for(WebElement option:allDates) {
			String data = option.getText();
			
			if(data.equalsIgnoreCase(dateValue)) {
				option.click();
				break;
			}
		}
	}
	
	public void dropDownSelectByValue(By locatorName, String value) {
		WebElement ele;
		ele=driver.findElement(locatorName);
		Select sel=new Select(ele);
		sel.selectByValue(value);
		
	}
	public void dropDownSelectByIndex(By locatorName, int i) {
		WebElement ele=null;
		ele=driver.findElement(locatorName);
		Select sel=new Select(ele);
		sel.selectByIndex(i);
		
	}
	public void dropDownSelectByVisibleText(By locatorName, String arg) {
		WebElement ele;
		ele=driver.findElement(locatorName);
		Select sel=new Select(ele);
		sel.selectByVisibleText(arg);
		
	}
	public boolean isDisplayed(By locatorName) {
		WebElement ele = driver.findElement(locatorName);
		return ele.isDisplayed();
	}
	public void mouseMoveOverAction(By locatorName) {
		try {
			 WebElement element = findElement(locatorName);
			 Actions act=new Actions(driver);
			 act.moveToElement(element).build().perform();
			
		}catch(Exception e) {
			
		}
	}
	public void mouseOverclick(By locatorName) {
			 WebElement element = findElement(locatorName);
			 Actions act=new Actions(driver);
			 act.moveToElement(element).click(element).build().perform();
	}	


	@Override
	public void get(String url) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

}
