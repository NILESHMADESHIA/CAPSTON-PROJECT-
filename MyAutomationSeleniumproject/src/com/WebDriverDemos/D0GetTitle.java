package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D0GetTitle {

	public static void main(String[] args) {
		String expTitle = "Google", actTitle;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		actTitle = driver.getTitle();
		
		System.out.println("Title:" + actTitle);
		if (actTitle.equals("Google"))
			System.out.println("Test case pass");
		else
			System.out.println("Test case fail");
		driver.close();
		
		

	}

}
