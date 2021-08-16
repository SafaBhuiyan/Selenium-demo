import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1 {

	WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();

		//WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterTest(enabled= false)
	public void closeDriver() {
		driver.quit();
	}
}
