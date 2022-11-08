package amazon.automateamazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverH {
	
	public static WebDriver driver;
	
	
	public void drivermethod() {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

}
