package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class EditIndividuals { 
	
	public static void main(String[] args) throws InterruptedException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(option);
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Leaf$123");
	driver.findElement(By.id("Login")).click();
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
	driver.executeScript("arguments[0].scrollIntoView();", scroll);
	WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
	driver.executeScript("arguments[0].click();", individual);
	WebElement clk = driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
	driver.executeScript("arguments[0].click();", clk);
	WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
	name.sendKeys("Kumars");
	name.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	//.sendKeys("Kumars",Keys.ENTER);
	WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
	driver.executeScript("arguments[0].click();", ele);
	Thread.sleep(3000);
	WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
	driver.executeScript("arguments[0].click();", edit);
	driver.findElement(By.xpath("//a[@class='select']")).click();
	driver.findElement(By.xpath("//a[text()='Mr.']")).click();
	driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Ganesh");
	driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	Thread.sleep(2000);
	String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
   //Verify the first name as 'Ganesh'
	}

}
