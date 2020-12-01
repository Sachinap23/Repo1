package com.app.orangeHRM.testscripts;

import org.testng.annotations.Test;

import com.app.orangeHRM.generics.BaseTest;
import com.app.orangeHRM.generics.Excel;
import com.app.orangeHRM.pages.AddEmployee_PIM;
import com.app.orangeHRM.pages.LoginPage;

public class AddEmployeeTest extends BaseTest {
	
	@Test
	public void addEmployeeTest() {
		String fn = Excel.getData(XL_PATH, "addEmployee", 1, 0);
		String ln = Excel.getData(XL_PATH, "addEmployee", 1, 1);
		String un = Excel.getData(XL_PATH, "addEmployee", 1, 2);
		String pw = Excel.getData(XL_PATH, "addEmployee", 1, 3);
		String rpw =Excel.getData(XL_PATH, "addEmployee", 1, 4);
		
		LoginPage lp=new LoginPage(driver);
		lp.Login(UN, PW);
		
		AddEmployee_PIM emp=new AddEmployee_PIM(driver);
		emp.goTo_submenu_PIM_addEmployee();
		emp.setFirstName(fn);
		emp.setlastName(ln);
		emp.clickCheckBox();
		emp.setusername(un);
		emp.setPassword(pw);
		emp.setrePassword(rpw);
		emp.clickSaveBTN();
		
	}

}
