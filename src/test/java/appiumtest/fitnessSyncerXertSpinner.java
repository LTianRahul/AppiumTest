package appiumtest;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.ios.IOSDriver;

//import org.junit.Test;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

public class fitnessSyncerXertSpinner {
	String username = "badoyap845";
	String authkey = "MC54HMiu6YhWTbnOZo1z9fKb6YJ9lWMDHBEFiLBTDguTBwDl6h";
	// private RemoteWebDriver driver;
	private static AppiumDriver driver;
	// private String status = "failed";

	public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);

		// ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
		ltOptions.put("name", "test 1 " + LocalDate.now());
		ltOptions.put("build", "FitnessSyncer");
		ltOptions.put("isRealMobile", true);
		ltOptions.put("platformName", "ios");
		//ltOptions.put("appiumVersion", "2.0.0");
		//ltOptions.put( "browserName", "Safari" );
		ltOptions.put("deviceName", "iPhone 13");
		ltOptions.put("autoAcceptAlerts", false);
		ltOptions.put( "network", true );
		ltOptions.put( "unicodeKeyboard", true );
		ltOptions.put( "resetKeyboard", true );
		ltOptions.put("platformVersion", "15"); // lt://APP10160601511703202882836940
		ltOptions.put("app", "lt://APP1016020161707919924218625");
		ltOptions.put("console", true);
		capabilities.setCapability("lt:options", ltOptions);

		try {
			driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
			Thread.sleep(5000);

		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testSimple() throws Exception {
		try {
			
			//Clicking on Sign In button
			driver.findElement(By.name("Sign In")).click();

			Thread.sleep(2000);

			//Entering the Email ID
			driver.findElement(By.className("XCUIElementTypeTextField")).click();
			
			driver.findElement(By.className("XCUIElementTypeTextField")).sendKeys("acceptancetestxxx@eyt.ca");

			//Entering the Password
			WebElement passwordField = driver.findElement(By.className("XCUIElementTypeSecureTextField"));

			passwordField.click();

			passwordField.sendKeys( "7D'/UXNO~w|5LRyuRUS4SW,E:Y9;6E:b9" ); // 1

	

//			int passwordLength = passwordField.getText().length();
//			System.out.println("Length of Old password is " + passwordLength);
////			for (int i = 0; i < passwordLength; i++) {
////				passwordField.sendKeys(Keys.BACK_SPACE);
////			}

//			passwordField.sendKeys(Keys.DELETE);
//			
//			passwordField.sendKeys( "b" ); // 2

			Thread.sleep(1000);

//			String newPasswordValue = passwordField.getText();
//
//			System.out.println("New Password is " + newPasswordValue);
//
//			int newPasswordValueLength = passwordField.getText().length();
//			
//			System.out.println("Length of New password is " + newPasswordValueLength);
//			// status="passed";

			//Clicking on Sign In button
			driver.findElement(By.name("Sign In")).click();
			
			Thread.sleep(10000);
			
			////*[@type="XCUIElementTypeOther" and ./parent::*[@type="XCUIElementTypeOther" and ./following-sibling::*[@name="Add a new Source"]]]
			
//			driver.findElement(By.name("Add a new Source")).click();
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./parent::*[@type=\"XCUIElementTypeOther\" and ./following-sibling::*[@name=\"Add a new Source\"]]]")).click();
			
			//Printing Source
		//	System.out.println(driver.findElement(By.name("Source")).getText());
			
			Thread.sleep(3000);
			
			System.out.println(driver.findElement(By.xpath("//*[@name=\"Data Type\"]")).getText());	
			
			Thread.sleep(3000);
//			//  setIosPickerValue( "Xert", 1 );
//		driver.findElement(By.xpath("//*[@class='XCUIElementTypeScrollView']/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypePicker[1]"));
//		Thread.sleep(3000);
//		
//			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypePicker\" and ./*[@value=\"Blood Pressure\"]]")).click();
		
			WebElement element = driver.findElement(By.xpath("//*[@class='XCUIElementTypeScrollView']/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypePicker[1]"));
			Thread.sleep(3000);
			//WebElement elementuipicker = element.findElement(By.xpath("//*[@value=\"Blood Pressure\"]]"));
			
			//Thread.sleep(3000);
			
			// Scroll to the element
		//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementuipicker);

			
			element.click();

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// status="failed";
		}
	}
	
//	public void setIosPickerValue( String pickerValue, int spinnerIndex ) {
//	
//		//WebElement e = driver.findElement(By.className("XCUIElementTypePickerWheel"));
//		
//		WebElement e = (WebElement) driver.findElement(By.xpath("//*[@class='XCUIElementTypeScrollView']/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypePicker[2]"))[spinnerIndex;
//	  //    WebElement e = driver.findElement(By.className("XCUIElementTypePickerWheel");
//	      String item = e.getText();
//	      Map<String, Object> params = new HashMap();
//	      params.put( "order", "next" );
//	      params.put( "offset", 0.15 );
//	      params.put( "element", e );
//	      while ( !item.equals( pickerValue ) ) {
//	         driver.executeScript( "mobile: selectPickerWheelValue", params );
//	         item = e.getText();
//	      }
//	   }
	
//	 public static WebElement[] findByClass( String clazz ) {
//	      List<WebElement> elements = driver.findElements( By.className( clazz ) );
//	      return elements.toArray( new WebElement[0] );
//	   }

	@AfterTest
	public void tearDown() throws Exception {

		// driver.executeScript("lambda-status=" + status);
		driver.quit();

	}

}
