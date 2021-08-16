package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksDemo {
	
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://www.zlti.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> elements= driver.findElements(By.tagName("a"));
		int noofElements = elements.size();
		System.out.println("Number of Elements: "+ noofElements);
		
		for(WebElement element: elements) {
			String url=element.getAttribute("href");
			varifyLink(url);
		}
	
	}
	
	public static void varifyLink(String urlLink){
		
		try {
			URL link = new URL(urlLink);
			try {
				HttpURLConnection httpConnect = (HttpURLConnection)link.openConnection();
				httpConnect.setConnectTimeout(500);
				httpConnect.setRequestMethod("HEAD");
				httpConnect.connect();
				
				if(httpConnect.getResponseCode()== 200) { 
					 System.out.println(urlLink+" - "+httpConnect.getResponseMessage());
				 }
				 if(httpConnect.getResponseCode()>=400) {
				 System.out.println(urlLink+" - "+"Its a broken link");
				 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
