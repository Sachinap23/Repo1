package com.app.orangeHRM.generics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static int getRowCount(String path, String sheet) {
		int rc=-1;      // here u can give 0 also
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream (path));   //or u can write separate like below
			rc= wb.getSheet(sheet).getLastRowNum();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rc;
		
	}
	 public static String getData(String path,String sheet, int r, int c) {
		 String val="";      //here u given empty string
		 try {
			 FileInputStream fis= new FileInputStream(path);
			 Workbook wb = WorkbookFactory.create(fis);
			 val=wb.getSheet(sheet).getRow(r).getCell(c).toString();      
		 }
		 catch(Exception e) {
				e.printStackTrace();
			}
		return val;
		  
	 }

}

