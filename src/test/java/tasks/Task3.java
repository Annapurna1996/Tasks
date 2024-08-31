package tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Task3 {
	WebDriver driver;
  @Test
  public void Practice_Form() {
	  driver = new ChromeDriver();
	  driver.get("https://demoqa.com/automation-practice-form");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	  jsExecutor.executeScript("window.scrollBy(0,500);");
      
	  driver.findElement(By.id("firstName")).sendKeys("Annapurna");
	  driver.findElement(By.id("lastName")).sendKeys("N");
	  driver.findElement(By.id("userEmail")).sendKeys("annapurnanagavarapu15@gmail.com");
	  
	// driver.findElement(By.xpath("//div//input[@value='Female']")).click();
	  List<WebElement> gender =driver.findElements(By.xpath("//div[contains(@class,'custom-radio')]"));	
	  for (WebElement category : gender) {
		  if(category.getText().equalsIgnoreCase("Female")) {
			  category.click();	  
			  
		  }
		  driver.findElement(By.id("userNumber")).sendKeys("9876543210"); 
		  
		  driver.findElement(By.id("dateOfBirthInput")).click();
		  WebElement months = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		  Select month = new Select(months);
		  month.selectByVisibleText("April");
		  WebElement years =driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		  Select year = new Select(years);
		  year.selectByValue("1996");
		  driver.findElement(By.xpath("//div[text()='25']")).click();
		 // JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		  jsExecutor.executeScript("window.scrollBy(0,500);");
	      
		  
		  driver.findElement(By.id("subjectsInput")).sendKeys("M");
		  driver.findElement(By.xpath("//div[text()='Maths']")).click();
		  driver.findElement(By.id("subjectsInput")).sendKeys("H");
		  driver.findElement(By.xpath("//div[text()='Hindi']")).click();
		  List<WebElement> Checkboxes = driver.findElements(By.xpath("//div[contains(@class,'custom-control')]"));
		  for (WebElement checkbox : Checkboxes) {
			 if(checkbox.getText().equalsIgnoreCase("Reading")) {
				 checkbox.click();
			 }
			
		}
		  driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\HP\\OneDrive\\Pictures\\Screenshots\\labimg.jpeg");
		  driver.findElement(By.id("currentAddress")).sendKeys("Streetno_5,srnagar,Hyderabad");
		  jsExecutor.executeScript("window.scrollBy(0,500);");

		 driver.findElement(By.id("state")).click();
		 driver.findElement(By.xpath("//div[text()='Uttar Pradesh']")).click();
		 driver.findElement(By.id("city")).click();
		 driver.findElement(By.xpath("//div[text()='Lucknow']")).click();
		driver.findElement(By.id("submit")).click();
		//driver.close();
	}
	 
	 
	 
	  
	  
	  
	  
  }
}
