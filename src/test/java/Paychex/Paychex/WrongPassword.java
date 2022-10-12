package Paychex.Paychex;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrongPassword extends UserLogin{
	
	public static void main(String[] args) throws InterruptedException {
		
		Utils.setUp();

		Utils.driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		Thread.sleep(2000);
		Utils.driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("ethomastest");
		Utils.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qwer1234");
		Utils.driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		String homePageText = Utils.driver.findElement(By.xpath("//div[@class='login-error-msg']//span")).getText();
		Assert.assertTrue(homePageText.contains("Invalid Username/Password."));
		Utils.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qwer123!");
		Utils.driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		Assert.assertTrue(homePageText.contentEquals("Invalid Username/Password."));
		Utils.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qwer12345!");
		Utils.driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		String lockedAccount = Utils.driver.findElement(By.xpath("//div[@class='login-error-msg']//span")).getText();
		Assert.assertTrue(lockedAccount.contentEquals("Account is locked due to too many failed attempts."));
		
		Utils.driver.quit();
		
		
		
	}
	
	

}
