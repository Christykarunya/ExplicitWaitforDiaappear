package Week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitforDisappear {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); //for explicit wait
		
		//Go to DOM-sources tab-pressF8 (freezes the screen)
		WebElement button = driver.findElement(By.id("btn"));
		wait.until(ExpectedConditions.invisibilityOf(button));
		
		String text = driver.findElement(By.tagName("strong")).getText();
		System.out.println("Text :" +text);
	}

}
