package variousConcept;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void windowHandle() throws InterruptedException {

		/*
		 * System.out.println(driver.getWindowHandle());
		 * System.out.println(driver.getTitle());
		 */

		String handle1 = driver.getWindowHandle();
		System.out.println(handle1);
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("selenium");
		driver.findElement(By.xpath("//button[@id='ybar-search']")).click();
		String handle2 =driver.getWindowHandle();
		String title2 =driver.getTitle();
		
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();

		for (String str : handles) {
			System.out.println(str);
			driver.switchTo().window(str);
		}

		String titles = driver.getTitle();
		System.out.println(titles);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500)");

		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		String handle3 =driver.getWindowHandle();
     	String titles3 = driver.getTitle();
		
		Set<String> handles2 = driver.getWindowHandles();
		System.out.println(handles2);

		for (String st2 : handles2) {
			System.out.println(st2);
			driver.switchTo().window(st2);
		
			}
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		/*
		 * driver.switchTo().window(handle1); System.out.println(handle1);
		 * System.out.println(title);
		 */
	}

}
