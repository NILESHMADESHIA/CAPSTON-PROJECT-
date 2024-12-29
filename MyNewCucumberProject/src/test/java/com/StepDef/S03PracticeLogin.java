package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S03PracticeLogin {
	WebDriver driver;
	
	@Given("I open practice login page")
	public void i_open_practice_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	
	@When("I enter valid user name")
	public void i_enter_valid_user_name() {
	   driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
	   
	}

	@When("I enter valid password")
	public void i_enter_valid_password() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
	    driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	@Then("Home page should display")
	public void home_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("logged-in-successfully"));
	}

	// invalid data enter

	@When("I enter invalid user name")
	public void i_enter_invalid_user_name() {
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("nilesh");
	}

	@When("I enter invalid password")
	public void i_enter_invalid_password() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("nilesh123");
	}

	@When("Click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	@Then("Error massage should display")
	public void error_massage_should_display() {
	    System.out.println(driver.findElement(By.xpath("//div[@id='error']")).getText());
	}

}
