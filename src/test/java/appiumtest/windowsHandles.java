package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class windowsHandles {

	// Main Dashboard
//	String username = "rahulkumarlambdatest";
//    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
	
	//Stagin Env creds

//	String username = "kayakiy597";
//	String authkey = "4jXvjSdnzteo39rxFVUzbTwZzOiwwyseiywHdNSFMBEcYIz06z";
	
	//Production Env creds

//		String username = "pimovi2573";
//		String authkey = "BK3JESBFIr0SRGAtPmUnGGk9lRz0V3YwUIlyZqkM5D4AD91jUp";
    
    
    // Production Env service accounts creds
	String username = "ProdSA";
	String authkey = "qmMPNpy8C6uFOXjBaU3uCd7UOQfcDHE3RXbgNSm3aJkVKyx1jm";
    
	
	
    private WebDriver driver;
    private String status = "failed";

    public String gridURL = "@hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", false);
        ltOptions.put("build", "Windows Handles Prod");
       // ltOptions.put("PageLoadStrategy", "eager");
        ltOptions.put("browserName", "chrome");
        ltOptions.put("platformName", "win 10");
        ltOptions.put("browserVersion", "118");
       // ltOptions.put("selenium_version", "4.13.0");
        ltOptions.put("visual", true);
        ltOptions.put("console", true);
//        ltOptions.put("tunnel", true);
       // ltOptions.put("mitm", true);
//        ltOptions.put("performance", true);
        capabilities.setCapability("lt:options", ltOptions);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
    }

    @Test
    public void testAdsDetails() throws InterruptedException {
    	 driver.get("https://demoqa.com/browser-windows");

    	 Thread.sleep(2000);
         // Open new child window within the main window
         driver.findElement(By.id("windowButton")).click();
      	 Thread.sleep(2000);
         //Get handles of the windows
         String mainWindowHandle = driver.getWindowHandle();
         Set<String> allWindowHandles = driver.getWindowHandles();
         Iterator<String> iterator = allWindowHandles.iterator();

         // Here we will check if child window has other child windows and will fetch the heading of the child window
         while (iterator.hasNext()) {
             String ChildWindow = iterator.next();
                 if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                 driver.switchTo().window(ChildWindow);
                 WebElement text = driver.findElement(By.id("sampleHeading"));
                 System.out.println("Heading of child window is " + text.getText());
             }
         }
        
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            // driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
    
}
