package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import amazon.automateamazon.DriverH;

public class AmazonSignup extends DriverH {
	
	public static Properties prop;
	 By amazonsignin = By.xpath("//header[@id='navbar-main']/div/div/div[3]/div/a[2]");
	 By username = By.xpath("//input[@type='email']");
	 By password = By.xpath("//input[@type='password']");
	 By contin = By.xpath("//input[@id='continue']");
	 By sigin = By.xpath("//input[@id='signInSubmit']");
	 
public AmazonSignup() {
	PageFactory.initElements(driver, this);
}
public void siginin() {
	 prop = new Properties();
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\gowth\\eclipse-workspace\\automateamazon\\src\\main\\java\\amazon\\automateamazon\\config.properties");
	
		prop.load(fis);

	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.manage().window().maximize();
	Actions action = new Actions(driver);
	WebElement signin =  driver.findElement(amazonsignin);
	 action.moveToElement(signin).build().perform();
	 driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();
	 driver.findElement(username).sendKeys(prop.getProperty("username1"));
	 driver.findElement(contin).click();
	 driver.findElement(password).sendKeys(prop.getProperty("password1"));
	 driver.findElement(sigin).click();
	
}

}
