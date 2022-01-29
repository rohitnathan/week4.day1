package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		// launch the browser
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

		driver.manage().window().maximize();

		driver.switchTo().frame("iframeResult");

		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Rohit");

		alert.accept();

		String text = driver.findElement(By.id("demo")).getText();

		// System.out.println(text);

		if (text.contains("Rohit")) {
			System.out.println("Verified Sucessfully");
		} else {
			System.out.println("Mismatch");
		}

	}

}
