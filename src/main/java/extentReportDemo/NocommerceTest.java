package extentReportDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NocommerceTest {
	
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() 
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/My Report.html");
		htmlReporter.config().setDocumentTitle("MY Automation Report");
		htmlReporter.config().setReportName("Functional Report");
	
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("os", "Win10");
		extent.setSystemInfo("Tester Name", "Purvi");
		extent.setSystemInfo("Browser", "Chrome");
		
		//
		
		

	}
	@AfterTest
	
	public void endReport() {
		
		extent.flush();
	}
	
	
	@BeforeMethod
	public void setup() {
		
	 System.setProperty("webdriver.chrome.driver", "C:\\QA DOCS\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();	
	 driver.get("http://demo.nopcommerce.com/");  //open url
		
		
	}
	
	@Test
	public void noCommerceTitleTest() {
		
		test = extent.createTest("NopCommerceTEST");
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "nopCommerce demo store");
		
	
	}
	
	@Test
	public void nopCommerceLogoTest() {
		
		
		test=extent.createTest("NopCommerceLogoTest");
		Boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	@Test
	public void nopcommerceLoginTest() {
		test=extent.createTest("NopCommerceLoginTest");
		Assert.assertTrue(true);	
		
		}
	
	@AfterMethod
	
		public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus()== ITestResult.FAILURE) {
		
			test.log(Status.FAIL, "Test Case Failed is"+result.getName());  //To add name in the extent report
			test.log(Status.FAIL, "Test Case Failed is"+result.getThrowable()); //To Add Error or exception in extent report
			
			String Screenshotpath = NocommerceTest.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(Screenshotpath); //adding screenshot
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			
			test.log(Status.FAIL, "Test Case Skipped is" + result.getName());
		}
		
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is" + result.getName());
		}
		
		driver.quit();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName)throws IOException{
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//After Execution you can see folder "FailedTestScreenshot" under src folder
		
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finaldestination = new File (destination);
		FileUtils.copyFile(source, finaldestination);
		
		return destination;
	}
	
}
