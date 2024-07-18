package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utils.IntegrationWIthTC;

public class BaseClass extends AbstractTestNGCucumberTests{
	
	public static ExtentReports repo;
	public static ExtentTest test;

	public String testName,testDescription,testAuthor,testCategory;
	public String dataFile;
	
	private static final ThreadLocal<RemoteWebDriver> tlDriver=new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver() {
		tlDriver.set(new ChromeDriver());
	}
	
	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}
	
	@BeforeMethod
	public  void precondition() throws InterruptedException {
	setDriver();
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");

   // driver = new ChromeDriver(option);

    getDriver().get("https://login.salesforce.com/");
    getDriver().manage().window().maximize();
    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
   /* getDriver().findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
    getDriver().findElement(By.id("password")).sendKeys("Leaf$123");
    getDriver().findElement(By.id("Login")).click();
	Thread.sleep(3000);
	getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	
	getDriver().findElement(By.xpath("//button[text()='View All']")).click();

	WebElement scroll = getDriver().findElement(By.xpath("//p[text()='Party Consent']"));
	getDriver().executeScript("arguments[0].scrollIntoView();", scroll);
	WebElement individual = getDriver().findElement(By.xpath("//p[text()='Individuals']"));
	getDriver().executeScript("arguments[0].click();", individual);*/
	}
	
	@AfterMethod
		public void postcondition() {
		getDriver().quit();
		
	
	}

	@DataProvider(name="getValue")
	public String[][] fetchData() throws IOException {	
		
		return IntegrationWIthTC.readExcel(dataFile);
	
	}

	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter wb=new ExtentHtmlReporter("./reports/marathon3.html");
		wb.setAppendExisting(true);
		repo=new ExtentReports();
		repo.attachReporter(wb);


	}
	
	@AfterSuite
	public void stopReport() {
		repo.flush();
	}
	
	
	@BeforeClass
	public void testDetails() {
		test=repo.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);

	}
	
	public void reportStep( String testDtls,String testStatus) throws IOException {
		if (testStatus.equalsIgnoreCase("pass")) {
			test.pass(testDtls, MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
		}else if(testStatus.equalsIgnoreCase("fail")) {
			test.fail(testDtls, MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
		}

	}
	
	public int takeSnap() throws IOException {
		int random = (int) (Math.random()*99999);

		File scr = getDriver().getScreenshotAs(OutputType.FILE);
		File dst=new File("./snap/img"+random+".png");
		FileUtils.copyFile(scr, dst);
		
		return random;
	}
	
}
