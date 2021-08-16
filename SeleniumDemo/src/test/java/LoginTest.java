import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest1 {
	

	
	@Test
	public void longInTest() {
		
		driver.findElement(By.id("email")).sendKeys("safa");
		driver.findElement(By.id("pass")).sendKeys("1234");
		driver.findElement(By.xpath("//button[starts-with(@id,'u_0')]")).click();
	}

}
