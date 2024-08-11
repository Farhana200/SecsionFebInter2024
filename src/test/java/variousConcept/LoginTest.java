package variousConcept;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LoginTest {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
	}

	@Test
	public void launchBrowser() {

		// driver.findElement(By.xpath("")).sendKeys("demo@codefios.com");
		// driver.findElement(By.id("password")).sendKeys("abc123");
		// driver.findElement(By.id("login_submit")).click();

		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("demo@codefios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@id='login_submit']")).click();
		
		WebElement dashboard = driver.findElement(By.xpath("//strong[contains(text(),'Dashboard')]"));
		Assert.assertTrue("Element not found", dashboard.isDisplayed());

	}

	// @After
	public void tearDown() {
		driver.close();
	}

}
