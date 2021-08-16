package windowHandleDemo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle_Demo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		String parentWindow= driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String> listofWindows= driver.getWindowHandles();
		int size=listofWindows.size();
		System.out.println(size);
		
		
		for(String childWindow:listofWindows) {
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.name("emailid")).sendKeys("safa@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		
		
		
		
		
		
		//Inside the For Earch Loop, after switching to the particular window, 
		//Check the Title of that page using if condition
		
		
		
//		for(String childWindow:listofWindows) {
//			
//			driver.switchTo().window(childWindow);
//			System.out.println(driver.getTitle());
//			if(driver.getTitle().equalsIgnoreCase(" Guru99 Bank Home Page ")) {
//				driver.findElement(By.name("emailid")).sendKeys("safa@gmail.com");
//				driver.findElement(By.name("btnLogin")).click();
//				driver.close();
//			}
//		}
//		driver.switchTo().window(parentWindow);
		
		

	}

}
