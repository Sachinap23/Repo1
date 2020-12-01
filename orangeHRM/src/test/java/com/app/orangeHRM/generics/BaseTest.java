package com.app.orangeHRM.generics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest implements IAutoConst{
	
	public WebDriver driver;
	public ExtentReports report;
	public static ExtentTest logger;  
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	/*
	 * @BeforeSuite public void cleanup() { try { FileUtils.deleteDirectory(new
	 * File("./test-output")); }catch(IOException e) { System.out.println(e); } }
	 */
	
	@BeforeSuite
	public void setupreport() {
		System.out.println("============ Report Started============");
		report=new ExtentReports(System.getProperty("user.dir")+"/Reports/"+getDate()+".html");	
	}
	
	@BeforeMethod
	public void openApp() {
		AutoLib getDrive=new AutoLib();
		driver= getDrive.getdriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(APP_URL);
	}
	@AfterMethod
	public void closeApp(ITestResult itestresult) {
		 int status = itestresult.getStatus();
		 String name = itestresult.getName();
		 if (status == 1) {
			 Reporter.log(" Test "+name+" is pass ",true);
		 }else if(status==2) {
			 Reporter.log(" Test "+name+" is fail ",true);
			 AutoLib.getPhoto(driver,IMG_PATH+"screenshot_"+AutoLib.getCurrentTime()+".png");
			 
			 //AutoLib.getPhoto(driver,IMG_PATH+name+".png");    //   ./Screenshot/InvalidLogin.png
			// AutoLib.getscreenshot(driver);
		 }else if(status==3){
			 Reporter.log(" Test "+name+" is skip ",true);
		 }
		 //driver.close();
	}
	
	@AfterSuite
	public void endReport() {
		//report.flush();                 //this ll delete report object
		System.out.println("AfterSuite:- Extent report is generated>>> Kindly check report folder");
	}
	
	public static String getDate() {
		long time = System.currentTimeMillis();
		SimpleDateFormat userformat=new SimpleDateFormat("MMM-dd-yyyy-HH-mm-ss");
		Date date=new Date(time);
		String newdate = userformat.format(date);
		return newdate;
	}
	

}


