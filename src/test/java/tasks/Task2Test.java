package tasks;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Task2Test {
	WebDriver driver;
  @Test(dataProvider="SearchData",dataProviderClass = Task2DataSuplier.class)
  public void TestSearch(String product,String Message) {
	  driver = new ChromeDriver();
	  //driver.get("https://demo.opencart.com/");
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys(product);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  try {
		  WebElement prod =driver.findElement(By.xpath("//span[@class=\"BUOuZu\"]"));
		  
		boolean ele = prod.isDisplayed();
		assertTrue(ele);
		System.out.println("successfully login");
	} catch (Exception e) {
		String error=driver.findElement(By.xpath("//div[@class='BHPsUQ']")).getText();
		boolean msg =error.equalsIgnoreCase(Message);
		assertTrue(msg);
		System.out.println("error message displayed");
		
	}
	  driver.close();
  }
}
