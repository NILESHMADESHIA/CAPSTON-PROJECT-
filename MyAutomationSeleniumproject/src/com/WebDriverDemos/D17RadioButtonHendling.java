package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D17RadioButtonHendling {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?");
		WebElement genFeml = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]"));
		
		System.out.println("Before.....");
		System.out.println("FEMALE CheckBox Selected"  +     genFeml.isSelected());
		System.out.println("FEMALE checkBox Enabled :   "  + genFeml.isEnabled());
		System.out.println("CheckBox Visible :"  + genFeml.isDisplayed());
		genFeml.click();
		
		System.out.println("After.....");
		System.out.println("FEMALE CheckBox Selected"  +    genFeml.isSelected());
		System.out.println("FEMALE checkBox Enabled :   "  + genFeml.isEnabled());
		System.out.println("CheckBox Visible :"  + genFeml.isDisplayed());
		
		// TODO Auto-generated method stub

	}

}
