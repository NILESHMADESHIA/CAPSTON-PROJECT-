package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D19HendlingListBox {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		WebElement listBox = driver.findElement(By.id("multiselect1"));
		Select cars = new Select(listBox);
		
		List<WebElement> carlist = cars.getOptions();
		System.out.println("All cars");
		
		for( WebElement c : carlist)
			System.out.println(c.getText());
		if(cars.isMultiple())
		{	
			cars.selectByIndex(1);
			cars.selectByIndex(2);
			
			List<WebElement> selectedCars = cars.getAllSelectedOptions();
			System.out.println("\nSelected Cars");
			for(WebElement c : selectedCars)
				System.out.println(c.getText());
			
		}
		//cars.deselectByIndex(2);
		cars.deselectAll();
		// TODO Auto-generated method stub

	}

}
