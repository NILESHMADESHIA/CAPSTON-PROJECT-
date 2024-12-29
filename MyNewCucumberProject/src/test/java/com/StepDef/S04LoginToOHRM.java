package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S04LoginToOHRM {
	
	WebDriver driver;
	
	@Given("Open OHRM")
	public void open_ohrm() {
		 driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@When("Enter valid userName as {string} and password as {string}")
	public void enter_valid_user_name_as_and_password_as(String un, String ps) {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(un);
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(ps);
	}

	

	@When("I click on Login button")
	public void i_click_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
	}

	@Then("Dashboard page should display")
	public void dashboard_page_should_display() {
	   Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	@When("Enter invalid username as {string} and password as {string}")
	public void enter_invalid_username_as_and_password_as(String un, String ps) {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(un);
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(ps);
	}


	
	@When("Click on Login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
	}
	@Then("Error massage should  be display")
	public void error_massage_should_be_display() {
	    System.out.println("Error Massage : "  + driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText());
	}

}
