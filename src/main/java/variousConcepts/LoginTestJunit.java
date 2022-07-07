package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestJunit {
	WebDriver driver;	
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}
	
	@Before
	public void init() throws InterruptedException {
	//  user.dir	
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\annar\\SeleniumFeb22\\crm\\driver\\chromedriver.exe");
	//	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	//	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");      more used one
		System.out.println("Init method");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(null));
	}
	@Test
	public void loginTest() throws InterruptedException {//how it looks at work
		try {
			driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
			driver.findElement(By.id("password")).sendKeys("abc123");
			driver.findElement(By.id("login")).click();
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//@Test
//	public void negLoginTest() throws InterruptedException {
//		driver.findElement(By.id("username")).sendKeys("kjuh@techfios.com");
//		driver.findElement(By.id("password")).sendKeys("jkjl233");
//		driver.findElement(By.id("login")).click();
//		Thread.sleep(2000);
//	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
