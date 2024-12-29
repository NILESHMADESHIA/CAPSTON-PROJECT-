package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D18DropDownHendling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?");
		
		WebElement droplst = driver.findElement(By.id("country"));
		
		Select countries = new Select(droplst);
		System.out.println("Selected Country"     + countries.getFirstSelectedOption().getText());
		
		List<WebElement> countryList = countries.getOptions();
		
		System.out.println("Total Countries: "   +countryList.size());
		//for(WebElement c: countryList)
		//	System.out.println(c.getText());
		
		//countries.selectByVisibleText("Ireland");
		//countries.selectByValue("103");
		//finding Index using For loop
		//int i= 0;
		//for(WebElement c : countryList)
		//{
			//System.out.println(i  + c.getText());
			//i++;
		//}
		countries.selectByIndex(100);
		
		
		
		
		
		
		System.out.println("Selected Country"     + countries.getFirstSelectedOption().getText());
		
		// TODO Auto-generated method stub

	}

}
