package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class EditIndividualTc extends BaseClass{
	
	@BeforeTest
	public void getData() {
		dataFile="Salesforce";
		testName="EditIndividual";
		testAuthor="Mathiprakash";
		testCategory="Smoke";
		testDescription="EditIndividual Scenario";
	}
	
	@Test(dataProvider = "getValue")
	public void editindividual(String uname, String pass) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage();
		lp.enterTheUsername(uname).enterThePassword(pass).clickOnLoginButton()
		.applauncher().clickviewall().clickindividual()
		.enternameinsearchbox().clickrolebutton().clickoneddit()
		.selectoption().clickonMr().enterfirstname().clicksave()
		.verifyeditname();
		
	}

}
