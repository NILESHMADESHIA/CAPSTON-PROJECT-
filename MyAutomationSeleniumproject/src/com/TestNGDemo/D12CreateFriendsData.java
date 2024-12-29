package com.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D12CreateFriendsData {
	
	File file ;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	  @Test
	  public void createFriendsData() {
		  row = sheet.createRow(0);
		  cell = row.createCell(0);
		  cell.setCellValue("Nilesh");
		  
		  //row = sheet.createRow(0);
		  cell = row.createCell(1);
		  cell.setCellValue("Madeshia");
		  
		  row = sheet.createRow(1);
		  cell =row.createCell(0);
		  cell.setCellValue("Mini");
		  
		  cell= row.createCell(1);
		  cell.setCellValue("Mandi");
		  
		  sheet.createRow(2).createCell(0).setCellValue("Lekha");
		  sheet.getRow(2).createCell(1).setCellValue("Thunugunta");
		  
		  
	  }
	  @BeforeTest
	  public void beforeTest() throws IOException {
		  file = new File("ExcelFile\\FriendsData.xlsx");
		  fos = new FileOutputStream(file);
		  wb = new XSSFWorkbook();
		  sheet =wb.createSheet();
	  }
	
	  @AfterTest
	  public void afterTest() throws IOException {
		  wb.write(fos);
		  wb.close();
		  fos.close();
	  }

}
