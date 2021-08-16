package screenShotSelenium4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class takeSchreenshotWith4 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		takeAshotImage(driver, "TEP-AshotImage");

	}
	
	public static void takeAshotImage(WebDriver driver, String ashot) {
		WebElement element1= driver.findElement(By.xpath("//img[@alt='guru99']"));
		File src = 	element1.getScreenshotAs(OutputType.FILE);
		//String path = "D:\\TEP Solution and Cons\\Automation_Selenium\\Selenium\\SeleniumDemo\\FullScreenAshot\\"+ashot+System.currentTimeMillis()+".jpg";
		File destination= new File("./Selenium4/gurulogo.png");

		
		
		try {
			FileUtils.copyFile(src,destination);
	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
