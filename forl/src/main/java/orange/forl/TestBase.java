package orange.forl;


import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestBase {

	public static WebDriver driver;
	@Test
	public void driverhub() {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement>  alllist = driver.findElements(By.xpath("//li[@class='oxd-main-menu-item-wrapper']/a/span"));
		for (int i = 0; i < alllist.size(); i++) {
			String txt = alllist.get(i).getText();
			if(txt.equalsIgnoreCase("Admin")) {
				alllist.get(i).click();
				break;
			}

		}

		//input[@type='checkbox']   //div[@class='oxd-table-cell oxd-padding-cell']/div  //data-v-c186142a
		// (//div[@class='oxd-table-cell oxd-padding-cell'][2])
		List<WebElement> allnames = driver.findElements(By.xpath(" (//div[@class='oxd-table-cell oxd-padding-cell'][2])"));

		for (int i = 0; i < allnames.size(); i++) {
			String namereq =	allnames.get(i).getText();
			//System.out.println(namereq +"and"+ i);
			if (namereq.equalsIgnoreCase("Anthony.Nolan")) {
				int k = i+1;
				driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'][2])["+k+"]/preceding-sibling::div")).click();
				break;
			}
		}
		LinkedList<String> set = new LinkedList<String>();
		LinkedList<String> set1 = new LinkedList<String>();
		List<WebElement> allnameforsort = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][4]"));
		for (WebElement webElement : allnameforsort) {
			String tobeadded = webElement.getText();
			set.add(tobeadded);
		}
		driver.findElement(By.xpath("//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th'][4]/div")).click();
		driver.findElement(By.xpath("(//span[text()='Ascending'])[3]")).click();
		List<WebElement> allnameforAsort = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][4]"));
		for (WebElement webelement : allnameforAsort) {
			String tobeaadded =	webelement.getText();
			set1.add(tobeaadded);
		}
		Collections.sort(set);
		Collections.sort(set1);
		System.out.println(set);
		System.out.println(set1);
		String fisrtword = set.get(0);
		String secondset1 = set1.get(0);
		System.out.println(fisrtword +" "+ secondset1);
		if(fisrtword.startsWith("A")) {
			System.out.println("it starts with A");
		}
		else {
			System.out.println("no it isn't");
			Collections.sort(set);
		}
		if(secondset1.startsWith("A")) {
			System.out.println("it starts with A");
		}
		else {
			System.out.println("no it isn't");
			Collections.sort(set);
		}
		if (set.equals(set1)) {
			System.out.println("it is ascending order");
		}
		
		
	}


}
