package com.clearTrip.testProject.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.clearTrip.testProject.ConstantData.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public WebDriver initializeBrowser(String browser, String url) {

		driver = null;

		if (browser.equalsIgnoreCase("IE")) {

			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(capabilities);
		}

		// String browser =
		// UtilityClass.readPropertiesFile(Constants.path_propertiesFile,
		// Constants.browser).toString();
		else if (browser.equalsIgnoreCase("CH")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("--ignore-certificate-errors");

			driver = new ChromeDriver(capabilities);

		} else if (browser.equalsIgnoreCase("FF")) {

			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get(url);
		driver.manage().window().maximize();

		return driver;
	}

	public static ExtentReports intializeExtentReport(ExtentReports extent) {
		// Create object of extent report and specify the report file path.
		if (extent == null) {
			extent = new ExtentReports(System.getProperty("user.dir") + "//extentReportFile.html");
			extent.addSystemInfo("Environment", UtilityClass.readPropertiesFile(Constants.path_propertiesFile, Constants.URL));
		}
		return extent;
	}

	public static ExtentTest intializeExtentTest(ExtentReports extent, String text) {
		// Create object of extent Test
		ExtentTest extentTest = extent.startTest(text);
		return extentTest;
	}

	
	}
