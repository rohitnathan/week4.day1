package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		// Initial Setup
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login
		driver.get("http://leaftaps.com/opentaps/control/login");

		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("(//input[@id='username'])")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@class = 'decorativeSubmit']")).click();

		// 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//div[@id = 'label']")).click();

		// 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();

		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();

		// 8. Click on First Resulting Contact
		Set<String> handlesFrom = driver.getWindowHandles();
		List<String> windowFrom = new ArrayList<String>(handlesFrom);
		driver.switchTo().window(windowFrom.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a[1]")).click();

		// 9. Click on Widget of To Contact
		driver.switchTo().window(windowFrom.get(0));
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		Thread.sleep(2000);

		// 10. Click on Second Resulting Contact
		Set<String> handlesTo = driver.getWindowHandles();
		List<String> windowTo = new ArrayList<String>(handlesTo);
		driver.switchTo().window(windowTo.get(1));
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/following::a[1]")).click();

		// 11. Click on Merge button using Xpath Locator
		driver.switchTo().window(windowTo.get(0));
		driver.findElement(By.linkText("Merge")).click();

		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// 13. Verify the title of the page
		System.out.println(driver.getTitle());

		// Quit all browsers
		driver.quit();

	}

}