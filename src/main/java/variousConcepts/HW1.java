package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
	WebDriver driver;
	

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");

	}

//	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}

	@Test
	public void addAccount() throws InterruptedException {
		loginTest();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/a/span[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")).click();
		driver.findElement(By.id("account")).sendKeys("Anna_Radnaeva's");
		driver.findElement(By.id("description")).sendKeys("checking");
		driver.findElement(By.id("balance")).sendKeys("200");
		driver.findElement(By.id("account_number")).sendKeys("1234567890");
		driver.findElement(By.id("contact_person")).sendKeys("Anna D Radnaeva");
		driver.findElement(By.id("contact_phone")).sendKeys("4133654523");
		driver.findElement(By.id("ib_url")).sendKeys("account@chase.com");
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")).click();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
