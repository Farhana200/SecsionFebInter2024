package variousConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class DropDownPactice {

	WebDriver driver;

	By User_Name_Field = By.xpath("//input[@id='user_name']");
	By User_PasswordField = By.xpath("//input[@name='password']");
	By User_Bytton_Field = By.xpath("//button[@id='login_submit']");
	By Dashbord_Header_Field = By.xpath("//strong[contains(text(),'Dashboard')]");
	By Customer_Field = By.xpath("//span[contains(text(),'Customers')]");
	By Add_Customer_Field = By.xpath("//span[contains(text(),'Add Customer')]");
	By Customer_FullName_Field = By.xpath("//input[@class='form-control name ']");
	By Company_DrpDown_Field=By.xpath("//select[@name='company_name']");
	By Group_DrpDown_Field=By.xpath("//select[@name='customer_group']");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	// @Test
	public void logIn() {

		driver.findElement(User_Name_Field).sendKeys("demo@codefios.com");
		driver.findElement(User_PasswordField).sendKeys("abc123");
		driver.findElement(User_Bytton_Field).click();
		String ActualDashbodText = driver.findElement(Dashbord_Header_Field).getText();

		//System.out.println(ActualDashbodText);

		Assert.assertEquals("Dashbord not found", "Dashboard", ActualDashbodText);
		// Assert.assertEquals("Dashbord not found", "Codefios", driver.getTitle());

	}

	@Test
	public void dropdown() throws InterruptedException {

		logIn();
		driver.findElement(Customer_Field).click();
		driver.findElement(Add_Customer_Field).click();
		Assert.assertEquals("Addcustomer page not found", "Manage Client", driver.getTitle());

		Thread.sleep(2000);
		driver.findElement(Customer_FullName_Field).sendKeys("Selenium");
	      
		Select sel = new Select(driver.findElement(Company_DrpDown_Field));
		sel.selectByVisibleText("Techfios");
		
		List<WebElement> WebEleList = sel.getOptions();
		System.out.println(WebEleList.size());
		for(WebElement l:WebEleList) {
			System.out.println(l.getText());
			
		}

		
	}
	@Test
	public void groupDrpDwn() {
		
		logIn();
		driver.findElement(Customer_Field).click();
		driver.findElement(Add_Customer_Field).click();
		
		Select sel = new Select(driver.findElement(Group_DrpDown_Field));
		sel.selectByVisibleText("Selenium");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,2000)");
		
		
		
String[] expectedGropValue ={"","SDLC","SQL","SQL","Java","Cloud Computing","Cloud Computing","Java","Selenium"};
        System.out.println(expectedGropValue.length);
		
		List<WebElement> groupList =sel.getOptions();
		System.out.println(groupList.size()); 
		
		for(WebElement t:groupList) {
			System.out.println(t.getText());
		}
		System.out.println();
		
		
		
		for(int i=0;i<groupList.size(); i++) {
			System.out.println(groupList.get(i).getText() + "-->"+ expectedGropValue[i]);
			Assert.assertEquals("List not Display", expectedGropValue[i], groupList.get(i).getText());
			
		}
		
		}



}
