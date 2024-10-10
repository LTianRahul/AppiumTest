package appiumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public class mobileWebOnEmulator 

{
    public static AppiumDriver driver;
    public static String uname = "rahulkumarlambdatest";
    public static String akey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";

    public static void main(String[] args) throws MalformedURLException, InterruptedException  {


    	
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("w3c", true);
        ltOptions.put("platformName", "android");
         ltOptions.put("deviceName", "Galaxy S23 Plus");
         ltOptions.put("platformVersion", "14");
      ltOptions.put("app", "lt://APP10160161211700671147522636");
        //capabilities.setCapability("privateCloud", true);
         ltOptions.put("build", "SmartUI - Real Device Native App");
         //'appPackage':'com.ALLDATA.MyALLDATA'
         //'appActivity':'crc64f5db9d7c2fe474a6.MainActivity' 'autoWebview':true, autoWebviewTimeout':5000
         ltOptions.put("appPackage", "com.ALLDATA.MyALLDATA");
         ltOptions.put("appActivity", "crc64f5db9d7c2fe474a6.MainActivity");
         ltOptions.put("autoWebview", true);
         ltOptions.put("autoWebviewTimeout", "5000");
         ltOptions.put("unicodeKeyboard", true);
         ltOptions.put("automationName", "UiAutomator2");
         ltOptions.put("resetKeyboard", true);
         ltOptions.put("name", "SmartUI - Test");
         ltOptions.put("autoGrantPermissions", true);
         ltOptions.put("autoAcceptAlerts", true);
//         ltOptions.put("appProfiling", true);
        ltOptions.put("project", "SmartUI - Real Device Native App");
        // ltOptions.put("appium:automationName", "flutter");
        //ltOptions.put("appium:appiumVersion", "2.0");  //1.19.0 in emulator default, 1.22.3 in RD default
       ltOptions.put("isRealMobile", false);
         ltOptions.put("visual", true);
//         ltOptions.put("performance", true);

         
         capabilities.setCapability("lt:options", ltOptions);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("build", "23andme Popup");
//        capabilities.setCapability("name", "Test 1");
//
//        capabilities.setCapability("platformName", "android");
//      //  capabilities.setCapability("platformName", "ios");
//
//        capabilities.setCapability("deviceName", "Galaxy S21 5G");
//       // capabilities.setCapability("deviceName", "iPhone 14");


      //  capabilities.setCapability("platformVersion", "16.0");
       // capabilities.setCapability("isRealMobile", true);

        //capabilities.setCapability("appiumVersion","1.22.1");
      //  capabilities.setCapability("fixedIP","10.243.32.129");

        //  capabilities.setCapability(ChromeOptions.CAPABILITY, options);



        driver = new AppiumDriver(new URL("http://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"),capabilities);

        Thread.sleep(2000);
        
        
        
        System.out.println("Clicked on Location permission");
       // driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        
//        System.out.println("Entered Username");
//        
//        driver.findElement(By.xpath("//*[@resource-id='com.cubostecnologia.zigpdvandroidoffline:id/textInputEditText']")).sendKeys("Rahul");
        
        Thread.sleep(5000);
        
        System.out.println("Entered Username");
        driver.findElement(By.id("user")).click();
        
        driver.findElement(By.id("user")).sendKeys("Rahul");

//        System.out.println("Entered Password");
     
//        driver.findElement(By.xpath("//*[contains(@text, 'Password')]")).sendKeys("12345");
        
        Thread.sleep(5000);
        System.out.println("Entered Password");
        driver.findElement(By.id("password")).click();
        
        driver.findElement(By.id("password")).sendKeys("12345");
        
        Thread.sleep(5000);
        

       // System.out.println("Clicked");
      
        
       // ((AppiumDriver)driver).hideKeyboard(); 
        
       // driver.findElement(By.id("com.cubostecnologia.zigpdvandroidoffline:id/titleTX")).click();
        
       
      // driver.findElement(By.xpath("//*[@resource-id='com.cubostecnologia.zigpdvandroidoffline:id/loginZB']")).click();
        
       // driver.findElement(AppiumBy.androidUIAutomator("UiSelector().index(2)")).click();
        
        
//        driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\"com.cubostecnologia.zigpdvandroidoffline:id/titleTX\")).getChildByText("
//                + "new UiSelector().className(\"android.view.ViewGroup\"))")).click();

        
//        System.setProperty("webdriver.chrome.driver","D:\\Code Stuff\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--user-data-dir=C:\\Users\\abidk\\AppData\\Local\\Google\\Chrome\\User Data");
//        options.addArguments("--profile-directory=Profile 5");
//        options.addArguments("--start-maximized");
//        ChromeDriver driver = new ChromeDriver(options);

//        driver.get("https://github.com/lambdatestsupport/smartui-Java");
//        Thread.sleep(60000);
        
        

        driver.quit();
    }
    
   
}