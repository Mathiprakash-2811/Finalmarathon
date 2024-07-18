package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class IndividualTc extends BaseClass {
	@BeforeTest
	public void getData() {
		dataFile="Salesforce";
		testName="CreateIndividual";
		testAuthor="prakash";
		testCategory="Smoke";
		testDescription="CreateIndividual Scenario";
	}
	
	
	@Test(dataProvider = "getValue")
	public void individual(String uname, String pass) throws IOException {
		LoginPage lp = new LoginPage();
		 lp.enterTheUsername(uname).enterThePassword(pass).clickOnLoginButton().
		 applauncher().clickviewall().clickindividual().clicknew().
		 enterlastname().selectkumars().verifylastname();
		 
		 
	}

}
