package Paychex.Paychex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin {

	public static void main(String[] args) throws InterruptedException {

		Utils.setUp();

		Utils.driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		Thread.sleep(2000);
		Utils.driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("ethomastest");
		Utils.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Azsx1234!");
		Utils.driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		
		Utils.driver.quit();

	}
	
	
}
