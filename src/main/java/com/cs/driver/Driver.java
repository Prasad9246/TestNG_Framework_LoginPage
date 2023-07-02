package com.cs.driver;
import static com.cs.ReadProperties.ReadPropertiesFile.prop;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import driverManager.DriverManager;

public final class Driver {

	private Driver() {}
	public static WebDriver driver;
	
	public static void initDriver() {
		String browserName = prop.getProperty("browser");
		if(DriverManager.getDriver()==null) {
			driver = DriverFactory.getDriver(browserName);
			DriverManager.setDriver(driver); // parallel testing
		}
		driver.get(prop.getProperty("url"));
		if(prop.getProperty("maxwindow").equalsIgnoreCase("true"))
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
	}
	
	public static void quitBrowser() {
		if(DriverManager.getDriver()!=null) {
			DriverManager.getDriver().quit();
			DriverManager.setDriver(null);
		}
	}
}
