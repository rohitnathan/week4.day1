package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) throws InterruptedException {
	
		//setup the driver
		
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//load the url
		driver.get("http://www.leafground.com/pages/Alert.htm");
		
		//click on Alert
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		//driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		//driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		//driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		
		Thread.sleep(3000);
		
		//switch to alert box
		Alert alert = driver.switchTo().alert();
		
		//get text
		String text = alert.getText();
		System.out.println(text);
		
		//Enter text in text field
		alert.sendKeys("ABC");
		alert.accept();
		//alert.dismiss();
		
		//Accept the sweet alert
		driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

}
