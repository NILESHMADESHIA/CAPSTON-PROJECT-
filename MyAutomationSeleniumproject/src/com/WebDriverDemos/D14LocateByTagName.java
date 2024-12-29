package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D14LocateByTagName {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println("Total links"  + links.size());
		/*int i= 0;
		while(i < links.size() ) 
		{
			System.out.println(links.get(i).getText());
			i++;
		}
		*/
		for (WebElement l : links)
		{
			System.out.println(l.getText());
		}
			
		//for (int i= 0; i <= links.size();i++ )
			//System.out.println(links.get(i).getText());
		//String txt=links.get(0).getText();
		//System.out.println(txt);
		//System.out.println(links.get(0).getText());
		// TODO Auto-generated method stub

	}

}
