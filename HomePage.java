package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass{
	
	@When ("Click on AppLauncher")
	public HomePage applauncher() throws IOException {
		try {
		getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		reportStep("click on applauncher", "pass");
	    } catch (Exception e) {
		System.out.println(e);
		reportStep("not click on applauncher", "fail");
	}
		
		return this;
	}
	
	@When ("Click on ViewAll")
	public HomePage clickviewall() throws IOException {
		try {
			getDriver().findElement(By.xpath("//button[text()='View All']")).click();
		    reportStep("click on viewall", "pass");
	    } catch (Exception e) {
		System.out.println(e);
		reportStep("not click on viewall", "fail");
	}
		
	return this;
	}
	
	@When ("Click on Individuals")
	public IndividualPage clickindividual() throws IOException {
		try {
			
			WebElement scroll = getDriver().findElement(By.xpath("//p[text()='Party Consent']"));
			getDriver().executeScript("arguments[0].scrollIntoView();", scroll);
		    WebElement individual = getDriver().findElement(By.xpath("//p[text()='Individuals']"));
			getDriver().executeScript("arguments[0].click();", individual);
		   reportStep("click on individuals", "pass");
	    } catch (Exception e) {
		System.out.println(e);
		reportStep("not click on individuals", "fail");
	}

	 return new IndividualPage();
	}

}
