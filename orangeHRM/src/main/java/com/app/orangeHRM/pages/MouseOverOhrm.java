package com.app.orangeHRM.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverOhrm {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://127.0.0.1/orangehrm-4.4/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Sachin*ap@123");
		driver.findElement(By.name("Submit")).click();
		
		WebElement mainMenu = driver.findElement(By.xpath("//b[contains(text(),'PIM')]"));
		Actions action=new Actions(driver);
		action.moveToElement(mainMenu).build().perform();
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
		
	}

}
