package appiumtest;

import io.appium.java_client.PushesFiles;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import org.testng.annotations.Test;

public class varoMoneyTest {

  
	public String username = "rahulkumarlambdatest";
	public String accesskey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    private IOSDriver driver;


    @Test
    public void biometricTest() {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "ios");
            ltOptions.put("deviceName", "iPhone.*");
            ltOptions.put("platformVersion", "14");
            ltOptions.put("idleTimeout", "1800");//"timezone", "UTC+02:00"
            ltOptions.put("timezone", "UTC+02:00");
            ltOptions.put("app", "lt://APP1016020161710983343714889"); 
            ltOptions.put("isRealMobile", true); // automationName='flutter',
           // ltOptions.put("resignApp", true); // if we mark this as false then the maps gets loaded even with network true, tunnel true and appProfiling true
//            ltOptions.put("appProfiling", true);
//           ltOptions.put("automationName", "flutter");
            ltOptions.put("network", true);
//            ltOptions.put("enableImageInjection", false);
//            ltOptions.put("region", "us");
            
//            HashMap<String, Object> networkConfig = new HashMap<String, Object>();
//            networkConfig.put("bypassWebsocket", false);
//            ltOptions.put("networkConfig", networkConfig);
           
            ltOptions.put("tunnel", false);
            ltOptions.put("build", "sample-latest");
  
            capabilities.setCapability("lt:options", ltOptions);
         


            String hub = "https://" + username + ":" + accesskey + gridURL;
            driver =  new IOSDriver(new URL(hub), capabilities);
            ((JavascriptExecutor)driver).executeScript("lambda-name=passing-test");

          
            
            // Push a file
           // ((PushesFiles) driver).pushFile("/sdcard/Download/sample.jpg", new File("/Users/rahulkumar/Downloads/baseline-Allego.png"));
            
            Thread.sleep(300000);
            // Pull file
//            byte[] fileBase64 = driver.pullFile("/sdcard/Download/sample.jpg");
//            
//            driver.findElement(By.id("sample")).sendKeys(fileBase64);
//         
//            driver.findElement(By.xpath("//*[@resource-id=\"com.varomoney.bank.uat:id/userEmailPhoneField\"]")).click();
//            
//            
//            driver.findElement(By.xpath("//*[@resource-id=\"com.varomoney.bank.uat:id/userEmailPhoneField\"]")).sendKeys("samatha.schultz.1649395226@qe.varomoney.com");
//            
//        
//            driver.findElement(By.xpath("//*[@resource-id=\"com.varomoney.bank.uat:id/passwordField\"]")).click();
//            
//            driver.findElement(By.xpath("//*[@resource-id=\"com.varomoney.bank.uat:id/passwordField\"]")).sendKeys("Password1!");
//            
//            Thread.sleep(2000);
//            
//            driver.findElement(By.xpath("//*[@resource-id=\"com.varomoney.bank.uat:id/loginButton\"]")).click();
//            
//            Thread.sleep(15000);
//            
//            driver.findElement(By.xpath("//*[@resource-id=\"com.varomoney.bank.uat:id/partnerOffers\"]")).click();
//            
//            Thread.sleep(3000);
//            
//            driver.findElement(By.xpath("//*[@class=\"android.view.ViewGroup\" and ./*[@text=\"Nearby\"]]")).click();
//            
//            Thread.sleep(3000);
//            
//            driver.findElement(By.xpath("//*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
//            
//            Thread.sleep(5000);
            
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }
    }


}
