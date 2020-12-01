package com.app.orangeHRM.generics;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class AutoLib implements IAutoConst {
	
private WebDriver driver;
	
	public static void getPhoto(WebDriver driver, String path) {
		TakesScreenshot t= (TakesScreenshot) driver;
		File srcFile= t.getScreenshotAs(OutputType.FILE);
		File destFile= new File(path);
		try {
			FileUtils.copyFile(srcFile,destFile);	
		}
		catch(IOException e) {
			e.getStackTrace();
		}
	}
	
	public static String getscreenshot(WebDriver driver) {
		String path = System.getProperty("user.dir")+"\\Screenshot\\screenshot_"+getCurrentTime()+".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		//File destFile= new File(path);
		try {
			FileHandler.copy(src, new File(path));
		}
		catch(IOException e) {
			System.out.println("Failed to capture screenshot");
		}
		return path;
		}
	
	public static String getCurrentTime() {
		DateFormat dateformat= new SimpleDateFormat("ss_mm_HH_dd_MM_yy");
		Date date=new Date();
		return dateformat.format(date);
		
	}

	public WebDriver getdriver(String browsertype) {
		System.out.println("========Browser is getting ready========");
		if(browsertype.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		}else if(browsertype.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}
		return driver;
		
	}

}



