package com.app.orangeHRM.testscripts;
//orange hrm login program

import org.testng.annotations.Test;
import com.app.orangeHRM.generics.BaseTest;
import com.app.orangeHRM.pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void orangeHRMlogin() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(UN);
		Thread.sleep(2000);
		lp.setPassword(PW);
		Thread.sleep(2000);
		lp.enterlogin();
	}

}
