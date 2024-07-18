package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IndividualPage  extends BaseClass{
	
	@When ("Click New Button")
     public IndividualPage clicknew() throws IOException {
		
		try {
			 WebElement clk = getDriver().findElement(By.xpath("//div[text()='New']"));
		 	getDriver().executeScript("arguments[0].click();", clk);
			reportStep("click on newbutton", "pass");
		} catch (Exception e) {
			System.out.println(e);
			reportStep("not click on newbutton", "fail");
		}
    	
 		return  this;
    	 
	}
     @When ("Enter the LastName")
     public IndividualPage enterlastname() throws IOException {
 		
 		try {
 			 getDriver().findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys("Kumars");
 			reportStep("enter the lastname", "pass");
 		} catch (Exception e) {
 			System.out.println(e);
 			reportStep("enter the lastname", "fail");
 		}
    	 
    	
    	 return this;
     }

     @When ("Click Save")
     public  IndividualPage selectkumars() throws IOException {
    		try {
    			 getDriver().findElement(By.xpath("(//span[text()='Save'])[2]")).click();
    			reportStep("click save", "pass");
    		} catch (Exception e) {
    			System.out.println(e);
    			reportStep("not click on save", "fail");
    		}
    	 
    	
    	 return this;
     }
     
     @Then ("Verify The Name")
     public IndividualPage verifylastname() throws IOException {
    		try {
    			 String message = getDriver().findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
    			    System.out.println(message);
   			reportStep("verify the name", "pass");
   		} catch (Exception e) {
   			System.out.println(e);
   			reportStep("not verify the name", "fail");
   		}
   	 
   
 	return this;
     }
     
     @When ("Enter LastNAme in SearchBox")
     public IndividualPage enternameinsearchbox() throws InterruptedException, IOException {
 		try {
 			 WebElement name =getDriver().findElement(By.xpath("//input[@name='Individual-search-input']"));
     		name.sendKeys("Kumars");
     		name.sendKeys(Keys.ENTER);
     		Thread.sleep(3000);
			reportStep("enter lastname in searchbox", "pass");
		} catch (Exception e) {
			System.out.println(e);
			reportStep("not enter lastname in searchbox", "fail");
		}
    
    		return this;
     }
     @When ("Click on role button")
     public IndividualPage clickrolebutton() throws InterruptedException, IOException {
    		try {
    			 WebElement ele = getDriver().findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
    		       getDriver().executeScript("arguments[0].click();", ele);
    		       Thread.sleep(3000);
  			reportStep("click on role button", "pass");
  		} catch (Exception e) {
  			System.out.println(e);
  			reportStep("not click on role button ", "fail");
  		}
    
       return this;
     }
     
     @When ("Click Edit Icon")
     public IndividualPage clickoneddit() throws IOException {
    		try {
    			 WebElement edit = getDriver().findElement(By.xpath("//a[@title='Edit']/div"));
    	    		getDriver().executeScript("arguments[0].click();", edit);
   			reportStep("click edit button", "pass");
   		} catch (Exception e) {
   			System.out.println(e);
   			reportStep("not click on edit button", "fail");
   		}
    	
    		return this;
     }
     
     @When ("click on selectoption")
     public IndividualPage selectoption() throws IOException {
    		try {
    			getDriver().findElement(By.xpath("//a[@class='select']")).click();
   			reportStep("click on select option", "pass");
   		} catch (Exception e) {
   			System.out.println(e);
   			reportStep("not click on select option", "fail");
   		}
    	
    	return this;
     }
     
     @When ("click on Mr")
     public IndividualPage clickonMr() throws IOException {
    		try {
    			 getDriver().findElement(By.xpath("//a[text()='Mr.']")).click();
   			reportStep("click on Mr", "pass");
   		} catch (Exception e) {
   			System.out.println(e);
   			reportStep("not click on Mr", "fail");
   		}
    
    	 return this;
     }
     @When ("click on firstname")
     public IndividualPage enterfirstname() throws IOException {
    		try {
    			getDriver().findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Ganesh");
   			reportStep("click on firstname", "pass");
   		} catch (Exception e) {
   			System.out.println(e);
   			reportStep("not click on firstname", "fail");
   		}
    		
    		return this;
     }
     @When ("click on save")
     public IndividualPage clicksave() throws InterruptedException, IOException {
    		try {
    			getDriver().findElement(By.xpath("(//span[text()='Save'])[2]")).click();
    	    	 Thread.sleep(3000);
   			reportStep("click save", "pass");
   		} catch (Exception e) {
   			System.out.println(e);
   			reportStep("not click on save", "fail");
   		}
    	 
    	 return this;
     }
     
     @Then ("Verify")
     public IndividualPage verifyeditname() throws IOException {
    		try {
    			 String msg = getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
    	    	 System.out.println(msg);
   			reportStep("verify firstname", "pass");
   		} catch (Exception e) {
   			System.out.println(e);
   			reportStep("verifylastname", "fail");
   		}
    	
    	 return this;
     }
       
}
