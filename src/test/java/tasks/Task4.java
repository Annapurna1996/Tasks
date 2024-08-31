package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task4 {
	WebDriver driver;
  @Test
  public void Shopping_Cart() throws InterruptedException {
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();
	  //driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack' ]")).click();
	  //driver.findElement(By.id("add-to-cart")).click();
	  driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	  driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
//	  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//	  jsExecutor.executeScript("window.scrollBy(0,500);");
//	  driver.findElement(By.id("remove-sauce-labs-onesie")).click();
	  driver.findElement(By.id("shopping_cart_container")).click();
	  driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
	  driver.findElement(By.id("checkout")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("firstName")).sendKeys("Annapurna");
	  Thread.sleep(2000);
	  driver.findElement(By.id("last-name")).sendKeys("N");
	  driver.findElement(By.id("postal-code")).sendKeys("534269");
	  driver.findElement(By.id("continue")).click();
	  driver.findElement(By.id("finish")).click();
	  
	  
  }
}
