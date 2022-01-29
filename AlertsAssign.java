package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAssign {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Click on simple alert box
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();

		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		// Get text of alert box
		String text = alert.getText();
		System.out.println(text);

		// Accept alert
		alert.accept();

		// Click on Confirmation alert box
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(2000);
		String text2 = alert.getText();
		System.out.println(text2);
		alert.dismiss();

		// Click on Prompt alert box

		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert alerts = driver.switchTo().alert();
		Thread.sleep(2000);
		String text3 = alerts.getText();
		System.out.println(text3);

		alerts.sendKeys("Test");
		Thread.sleep(2000);
		alert.accept();

		// Click on sweet alert
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();

		// Accept sweet alert
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);

		driver.close();
		Thread.sleep(2000);

	}

}
