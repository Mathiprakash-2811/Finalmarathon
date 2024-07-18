package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class HomePageTc extends BaseClass{
	
	@BeforeTest
	public void getData() {
		dataFile="Salesforce";
		testName="HomePage";
		testAuthor="Mathi";
		testCategory="Smoke";
		testDescription="HomePage Scenario";
	}
	
	@Test(dataProvider = "getValue")
	public void homepage(String uname, String pass) throws IOException {
		LoginPage lp = new LoginPage();
		lp.enterTheUsername(uname).enterThePassword(pass).clickOnLoginButton()
		.applauncher().clickviewall().clickindividual()
		 .clicknew().enterlastname().selectkumars().verifylastname();

	}

}
