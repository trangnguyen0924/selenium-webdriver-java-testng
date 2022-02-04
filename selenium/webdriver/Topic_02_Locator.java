package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Locator {
	//khai bao mot bien dai dien cho webdriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe"); 
		// khoi dong trinh duyet
		driver = new FirefoxDriver(); 
		
		// set thoi gian cho de tim element
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 
		//mo page len
		driver.get("https://www.hogodoc.com/");
	}
	@Test
	public void TC01_Check_registerpage_UI() {
		//kiem tra vao trang dang ky thanh cong
		driver.findElement(By.xpath("//a[@id='tryLink']")).click();
		driver.findElement(By.xpath("//span[text()='CREATE A NEW ACCOUNT']")).isDisplayed();
	}
		
	
	@Test
	public void TC02_Check_require_Last_Name() {
		driver.findElement(By.xpath("//a[@id='btnSubmit']")).click();
		driver.findElement(By.xpath("//div[@class='lastnameformError parentFormvalidation formError']//div[text()='* This field is required']")).isDisplayed();

	}
	
	@Test
	public void TC03_Check_register_successfully() {
		driver.findElement(By.xpath("//a[@id='btnSubmit']")).click();
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Trang");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("trang.nguyenthuy0924@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Trang123456");
		driver.findElement(By.xpath("//a[@id='btnSubmit']")).click();
		driver.findElement(By.xpath("//div[@class='text-msg']//div[(text()='Thank you for signing up to HoGo')]")).isDisplayed();
		

	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}