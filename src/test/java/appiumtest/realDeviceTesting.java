package appiumtest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class realDeviceTesting {
	
//	public static String userName = "rahulkumarlambdatest"; //Enter your LT Username here
//    public static String accessKey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6"; //Enter your LT AccessKey here
//    
//    public static String gridURL = "@hub.lambdatest.com/wd/hub";
	
	//WebDriver driver;
		static AppiumDriver driver;
		//AndroidDriver driver;

		
		@BeforeTest
		public static void openOnClickListenersOnRealDevice() throws Exception {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "android");
			capabilities.setCapability("deviceName", "Galaxy Tab A7");
			capabilities.setCapability("platformVersion", "12");
			//capabilities.setCapability("build", "Appium Test");
			//capabilities.setCapability("name", "Appium First Test");
			//capabilities.setCapability("project", "Appium");
			capabilities.setCapability("udid","R9WN91TLGBJ");
			capabilities.setCapability("appPackage","com.example.onclicklisteners");
			capabilities.setCapability("appActivity","com.example.onclicklisteners.MainActivity");
			
			
			
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//            //capabilities.setCapability("name",platform+" "+device+" "+version);
//            capabilities.setCapability("deviceName", "Galaxy S23");
//            capabilities.setCapability("platformVersion", "13");
//            capabilities.setCapability("platformName", "android");
//            capabilities.setCapability("app", "lt://APP10160631101687366258894337");
//            capabilities.setCapability("build", "TestingBuild");
//            capabilities.setCapability("name", "FirstAndroidTest");
//            capabilities.setCapability("project", "AppiumTest");
//            //capabilities.setCapability("isRealMobile", true);
//            capabilities.setCapability("console", true);
//          capabilities.setCapability("network", true);
//          capabilities.setCapability("visual", true);
//          capabilities.setCapability("devicelog", true);
			
			
			URL url = new URL("http://127.0.0.1:4725/wd/hub");
			driver = new AppiumDriver(url, capabilities);
			
//			String hub = "https://" + userName + ":" + accessKey + gridURL;
//            AppiumDriver driver = new AppiumDriver(new URL(hub), capabilities);
			
			
			
			
			
			
		}
		
		@Test
		public static void testOne() {
			// TODO Auto-generated method stub
			

			System.out.println("App started on Real device......");
			
			driver.findElement(By.id("com.example.onclicklisteners:id/firstWay")).click();
//			try {
//				openOnClickListenersOnRealDevice();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				System.out.println(e.getCause());
//				System.out.println(e.getMessage());
//				e.printStackTrace();
//			}
		}
		
		
		@AfterTest
		public static void tearDown() {
			//driver.close();
			//driver.quit();
			System.out.println("Testing passed");
		}
		


}
