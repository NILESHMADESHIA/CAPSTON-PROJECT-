package com.TestNGDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D11WritetoExcel {
	  
	File file ;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	
	  @Test
	  public void writeData() {
		  row =sheet.createRow(0);
		  cell =row.createCell(0);
		  
		  cell.setCellValue("Nilesh");
	  }
	  @BeforeTest
	  public void beforeTest() throws FileNotFoundException {
		  file = new File("ExcelFile//MyFirstEXcel.xlsx");
		  fos = new FileOutputStream(file);
		  wb = new XSSFWorkbook();
		  sheet =wb.createSheet("My Sheet");
		  
	  }
	
	  @AfterTest
	  public void afterTest() throws IOException {
		  wb.write(fos);
	  }

}
