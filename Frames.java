package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		// launch the browser
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("http://www.leafground.com/pages/Alert.htm");
		
		driver.manage().window().maximize();
		
		//switch to frame/Nested frame
		 driver.switchTo().frame(1);
        //driver.switchTo().frame(0);
		 driver.switchTo().frame("frame2");
		 
		 //Webelement
		// driver.findElement(By.id("Click1")).click();
		 
             
        
        driver.findElement(By.id("Click")).click();
        
        //come out of all frames
        driver.switchTo().defaultContent();
        
        String text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(text);
        
        
	}
	
}
