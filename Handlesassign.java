package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlesassign {

	public static void main(String[] args) throws InterruptedException {
		// Setup driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
				
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Click on home
		driver.findElement(By.id("home")).click();
		System.out.println(driver.getTitle());
		
		//String ref = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String window : windowHandles) {
			System.out.println(window);
		}
		List<String> win = new ArrayList<String>(windowHandles);
		String parent = win.get(0);
		String child = win.get(1);
		System.out.println(child);
		
		// Switch to window
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parent);
		
		// In case a new window is opened, have to get window handles again
		driver.switchTo().window(parent);
		WebElement findElement = driver.findElement(By.tagName("h1"));
		System.out.println(findElement.getText());
		
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles2);
		int size = windowHandles2.size();
		System.out.println(size);
		
		for (int i = 0; i < size; i++) {
			driver.switchTo().window(list.get(i));
			System.out.println(driver.getTitle());	
			
		}
		
		Thread.sleep(2000);
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		
		// Close all windows 
		driver.quit();

	}

}
