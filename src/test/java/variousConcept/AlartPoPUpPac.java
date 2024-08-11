package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AlartPoPUpPac {

	WebDriver driver;

	By User_Name_Field = By.xpath("//input[@id='user_name']");
	By User_PasswordField = By.xpath("//input[@name='password']");
	By User_Bytton_Field = By.xpath("//button[@id='login_submit']");

	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
     
	}
 
	private String alartpPopUp() {
		String alartMassage=driver.switchTo().alert().getText();
		return alartMassage;
		
	}

	@Test
	public void AlartPac() throws InterruptedException {

		driver.findElement(User_Name_Field);
		driver.findElement(User_PasswordField);
		driver.findElement(User_Bytton_Field).click();
		Thread.sleep(2000);

		String alter = driver.switchTo().alert().getText();
		System.out.println(alter);

		Assert.assertEquals("Alart not popUp", "Please enter your user name", alter);
//		driver.switchTo().alert().accept();

	}
	
	
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
