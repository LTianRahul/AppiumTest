package appiumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class CalTest {
	
	//WebDriver driver;
	static AppiumDriver driver;
	//AndroidDriver driver;
	
//	public static String userName = "rahulkumarlambdatest"; //Enter your LT Username here
//    public static String accessKey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6"; //Enter your LT AccessKey here

   // public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openOnClickListenersOnEmulator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	@Test
	public static void openOnClickListenersOnEmulator() throws Exception {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("deviceName", "Pixel_5");
		capabilities.setCapability("automationName", "UIautomator2");
		capabilities.setCapability("platformVersion", "10");
		//capabilities.setCapability("build", "Appium Test");
		//capabilities.setCapability("name", "Appium First Test");
		//capabilities.setCapability("project", "Appium");
		capabilities.setCapability("udid","emulator-5554");
		//capabilities.setCapability("lambdaMaskCommands", new String[]{"setValues","setCookies"});
		capabilities.setCapability("appPackage","providence.nassau.mobile.swedishhealth.stage");
		capabilities.setCapability("appActivity","providence.nassau.mobile.swedishhealth.mvvm.MainActivity");
		
//		 DesiredCapabilities capabilities = new DesiredCapabilities();
//         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//         ltOptions.put("w3c", true);
//         ltOptions.put("platformName", "android");
//         ltOptions.put("deviceName", "Galaxy S23");
//         ltOptions.put("platformVersion", "13");
//         ltOptions.put("app", "lt://APP10160631101690215740557369");
//         ltOptions.put("build", "AppiumBuildRahulTestCal");
//         ltOptions.put("name", "AppiumTestRahulTestCal");
//         ltOptions.put("project", "AppiumProjectRahulTestCal");
//         ltOptions.put("isRealMobile", true);
//         ltOptions.put("appProfiling", true);
//         ltOptions.put("video", true);
//         ltOptions.put("visual", true);
//         capabilities.setCapability("lt:options", ltOptions);
		
		
//         driver = new AppiumDriver(new URL("https://" +userName +":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);
//
//         System.out.println("App started on Real device......");
//			
//			driver.findElement(By.id("com.example.onclicklisteners:id/firstWay")).click();
//			
//			Thread.sleep(3000);
//	
//		driver.findElement(By.id("com.example.onclicklisteners:id/second")).click();
//	
//Thread.sleep(3000);
//
//		driver.findElement(By.id("com.example.onclicklisteners:id/second")).click();
//	
//Thread.sleep(3000);
//	
//		driver.findElement(By.id("com.example.onclicklisteners:id/secondWay")).click();
//Thread.sleep(3000);
//	
//		driver.findElement(By.id("com.example.onclicklisteners:id/thirdWay")).click();
//		
//		((JavascriptExecutor) driver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"This is a sample remark for failed test \"}} ");
//		
			
		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AppiumDriver(url, capabilities);
		
		  Thread.sleep(20000);
		
		System.out.println("App started......");
		
		 System.out.println("Clicking on I UNDERSTAND");
         
         driver.findElement(By.id("providence.nassau.mobile.swedishhealth.stage:id/btnAccept")).click();
         
       
         
         driver.findElement(By.id("providence.nassau.mobile.swedishhealth.stage:id/inputText")).sendKeys("ab@ab.com");
		
//		driver.findElement(By.id("com.example.onclicklisteners:id/firstWay")).click();
//		
		driver.quit();
		
		
		
	}

}
