package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import base.BaseClass;

public class CreateIndividuals extends BaseClass {
	
	
	  @Test
      public  void createindividuals() throws InterruptedException {

		WebElement clk = getDriver().findElement(By.xpath("//div[text()='New']"));
		
		
		getDriver().executeScript("arguments[0].click();", clk);
		
		getDriver().findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys("Kumars");
		
		getDriver().findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		String message = getDriver().findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		//verify Individuals Name
}

}
