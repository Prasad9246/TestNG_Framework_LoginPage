package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotations;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest2 extends BaseTest{

	@DataProvider
	public Object[][] getData2(){
		return new Object[][] {
			{
				"Admin","admin123"
			}
		}; 
	}
	
	@FrameworkAnnotations(author = "Pashya",category = "regression")
	@Test(dataProvider="getData2",description = "Verify login Url")
	public void verifyLoginUrl(String userName, String password) {
		
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.loginAppl(userName,password);
		
		String actUrl = homePage.getHomePageUrl();
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		Assert.assertEquals(actUrl, expUrl,"Actual Url : "+actUrl+"does not match with expected Url : "+expUrl);
	}
}
