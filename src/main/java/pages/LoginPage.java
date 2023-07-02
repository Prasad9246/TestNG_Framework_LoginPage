package pages;

import org.openqa.selenium.By;

import com.cs.enums.WaitTypes;
import com.cs.utils.SeleniumUtils;

public class LoginPage {

	private final static By TXT_USERNAME = By.name("username");
	private final static By TXT_PASSWORD = By.name("password");
	private final static By BTN_LOGIN = By.xpath("//button[@type='submit']");

	private LoginPage setUserName(String userName) {
		SeleniumUtils.sendKeys(TXT_USERNAME, userName, WaitTypes.VISIBLE, "USERNAME");
		return this;
	}

	private LoginPage setsetPassword(String password) {
		SeleniumUtils.sendKeys(TXT_PASSWORD, password, WaitTypes.PRESENCE, "PASSWORD");
		return this;
	}

	private HomePage clickLoginBtn() {
		SeleniumUtils.click(BTN_LOGIN, WaitTypes.CLICKABLE, "LOGIN BUTTON");
		return new HomePage();
	}

	public HomePage loginAppl(String userName, String password) {
		return setUserName(userName).setsetPassword(password).clickLoginBtn();
	}

}
