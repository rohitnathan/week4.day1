 package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learnwindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		// launch the browser
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("https:leafground.com/pages/Window.html");

		driver.manage().window().maximize();

		// click on Home
		driver.findElement(By.id("home")).click();

		String title = driver.getTitle();
		System.out.println(title);

		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		
		//window to a Set

		Set<String> windowHandles = driver.getWindowHandles();

		for (String window : windowHandles) {
			System.out.println(window);

		}
        
		//converting from Set to List to get window info
		List<String> windows = new ArrayList<String>(windowHandles);

		String childwindow = windows.get(1);
		System.out.println(childwindow);

		// Switch to Window

		driver.switchTo().window(childwindow);

		String title2 = driver.getTitle();

		System.out.println(title2);

		// close all windows
		driver.quit();

	}

}
