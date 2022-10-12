package Paychex.Paychex;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrongPassword extends UserLogin{
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://www.eplanservices.com");

		driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("ethomastest");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qwer1234");
		driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		String homePageText = driver.findElement(By.xpath("//div[@class='login-error-msg']//span")).getText();
		Assert.assertTrue(homePageText.contains("Invalid Username/Password."));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qwer123!");
		driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		Assert.assertTrue(homePageText.contentEquals("Invalid Username/Password."));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qwer12345!");
		driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		String lockedAccount = driver.findElement(By.xpath("//div[@class='login-error-msg']//span")).getText();
		Assert.assertTrue(lockedAccount.contentEquals("Account is locked due to too many failed attempts."));
		
		
		
		
		
	}
	
	

}
