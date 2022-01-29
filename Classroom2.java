package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom2 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();

		// launch the browser
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().window().maximize();

		// get screenshot of the full page
		File source = driver.getScreenshotAs(OutputType.FILE);

		File dest = new File("./images/Home.png");

		FileUtils.copyFile(source, dest);
		
		

		// Sweet alert Ok click
		// Taking the screenshot of the webelement

		WebElement Ok = driver.findElement(By.xpath("//button[@type='submit']"));//.Click();

		File source1 = Ok.getScreenshotAs(OutputType.FILE);

		File dest1 = new File("./images/Home.png");

		FileUtils.copyFile(source1, dest1);

		// CLick on Flight link

		driver.findElement(By.linkText("FLIGHTS")).click();

		// Navigate to window

		Set<String> windowHandles = driver.getWindowHandles();

		// Converting to List from Set to get title

		List<String> windows = new ArrayList<String>(windowHandles);

		String flightwin = windows.get(1);
		driver.switchTo().window(flightwin);
		System.out.println(flightwin + driver.getTitle());

		// Close parent window

		driver.switchTo().window(windows.get(0));
		driver.close();
	}

}
