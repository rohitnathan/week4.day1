package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Service {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// Open instance
		driver.get("https://dev92233.service-now.com/login_redirect.do?sysparm_stack=no");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.switchTo().frame(0);
		
		// Login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("qWpuTvYcS92J");
		driver.findElement(By.id("sysverb_login")).click();
		
		// Filter
		driver.findElement(By.id("filter")).sendKeys("incident");
		
		// Click on Incident -> All
		driver.findElement(By.xpath("//div[@class='sn-widget-list-title' and text()='Resolved']/following::div[3]")).click();
		
		// Click on New
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement number = driver.findElement(By.id("incident.number"));
		String attribute = number.getAttribute("value");
		System.out.println("Value of incident: " + attribute);
		
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> set = driver.getWindowHandles();
		
		List<String> list = new ArrayList<String>(set);
		String child = list.get(1);
		
		driver.switchTo().window(child);
		int row = driver.findElements(By.xpath("//table[@id='sys_user_table']//tr")).size();
		System.out.println("Row size: " + row);
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[3]/td[3]")).click();
		
		String title = driver.switchTo().window(list.get(0)).getTitle();
		System.out.println("Page title is: " + title);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div/input[@id='incident.short_description']")).sendKeys("Short Description");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span/following-sibling::input[@placeholder='Search']")).sendKeys(attribute, Keys.ENTER);
		
		// Validate
		String text = driver.findElement(By.xpath("//table[@id='incident_table']//tbody/tr/td[3]")).getText();
		
		if(text.equalsIgnoreCase(attribute)) {
			System.out.println("Incident created successfully");
			
			// Screenshot
			File input = driver.getScreenshotAs(OutputType.FILE);
			File output = new File("./target/Images/Service.png");
			FileUtils.copyFile(input, output);
			
		} else {
			System.out.println("Issue with incident creation");
		}
		
		driver.close();

	}

}