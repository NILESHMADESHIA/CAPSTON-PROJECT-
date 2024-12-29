package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D16HendlingCheckBox {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?");
		WebElement chkBox = driver.findElement(By.cssSelector("input[name^=\"chk_alte\"]"));
		System.out.println("Before.....");
		System.out.println("chkBox Selected"  + chkBox.isSelected());
		System.out.println("CheckBox Enabled :   "  + chkBox.isEnabled());
		System.out.println("Ckeck Visible :"  + chkBox.isDisplayed());
		
		if(chkBox.isSelected()== false);
			chkBox.click();
		
		System.out.println("After.....");
		System.out.println("chkBox Selected"  + chkBox.isSelected());
		System.out.println("CheckBox Enabled :   "  + chkBox.isEnabled());
		System.out.println("Ckeck Visible :"  + chkBox.isDisplayed());
		
		// TODO Auto-generated method stub

	}

}
