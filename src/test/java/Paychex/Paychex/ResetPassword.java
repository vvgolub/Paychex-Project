package Paychex.Paychex;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResetPassword {
	public static void main(String[] args) throws InterruptedException {
		
		Utils.setUp();

		Utils.driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		Thread.sleep(2000);
		Utils.driver.findElement(By.xpath("//a[normalize-space()='Having trouble signing in?']")).click();
		Utils.driver.findElement(By.xpath("//span[normalize-space()='Reset my password']")).click();
		Utils.driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ethomastest");
		Utils.driver.findElement(By.xpath("//div[@id='continueButton']")).click();
		Utils.driver.findElement(By.xpath("//input[@id='secQuestion']")).sendKeys("ePlan");
		Utils.driver.findElement(By.xpath("//div[@id='finishButton']")).click();
		String successNotice = Utils.driver.findElement(By.xpath("//h1[normalize-space()='Your request was successful!']")).getText();
		Assert.assertEquals(successNotice, "Your request was successful!");
		
		Utils.driver.quit();
}
}