package Paychex.Paychex;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResetPassword {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://www.eplanservices.com");

		driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Having trouble signing in?']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Reset my password']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ethomastest");
		driver.findElement(By.xpath("//div[@id='continueButton']")).click();
		driver.findElement(By.xpath("//input[@id='secQuestion']")).sendKeys("ePlan");
		driver.findElement(By.xpath("//div[@id='finishButton']")).click();
		String successNotice = driver.findElement(By.xpath("//h1[normalize-space()='Your request was successful!']")).getText();
		Assert.assertEquals(successNotice, "Your request was successful!");
	}
}
