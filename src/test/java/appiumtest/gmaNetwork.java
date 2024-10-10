package appiumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class gmaNetwork {
	String username = "rahulkumarlambdatest";
	String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
	private RemoteWebDriver driver;
	private String status = "failed";

	public String gridURL = "@hub.lambdatest.com/wd/hub";
	
//	public String gridURL = "@localhost:9688/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", false);
		ltOptions.put("build", "gmaNetwork");
		// ltOptions.put("PageLoadStrategy", "eager");
		ltOptions.put("browser", "chrome");
		ltOptions.put("platform", "win 10");
		ltOptions.put("browserVersion", "120.0");
		// ltOptions.put("selenium_version", "4.13.0");
		ltOptions.put("visual", true);
		ltOptions.put("console", true);
//        ltOptions.put("performance", true);
		capabilities.setCapability("lt:options", ltOptions);

		driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + gridURL), capabilities);
		
	}

	@Test
	public void testAdsDetails() throws InterruptedException {
		driver.get("https://www.gmanetwork.com/entertainment/");
		Thread.sleep(10000);
		
	driver.executeScript("lambda:network"); 

		driver.findElement(By.cssSelector(".fc-footer-buttons button p")).click();
		Thread.sleep(30000);

//        driver.findElement(By.cssSelector(".fc-footer-buttons button p")).click();
//        Thread.sleep(20000);
//	    driver.executeScript("lambda:network=all");
		// xpath = //*[@class='tablet dfped']/div/div/div/iframe
		// css selector = #div-dfp-84 #andbeyond7282 div iframe

		WebElement adsMessage = driver
				.findElement(By.xpath("//ads[@dfp-ad-unit='ENT_Home_Desktop_Leaderboard']/div/div/div/iframe"));
//        String adText = adsMessage.getText();
//        String adUrl = adsMessage.getAttribute("iframe");
//        Thread.sleep(5000);

		// Print ad details
//        System.out.println("Ad Text: " + adText);
//        System.out.println("Ad URL: " + adUrl);

		boolean isElementDisplayed = adsMessage.isDisplayed();
		// Assert.assertTrue(isElementDisplayed, "Element is not displayed on the
		// webpage.");

		// Print the result in the console
		System.out.println("Is Element Displayed? " + isElementDisplayed);

		Thread.sleep(5000);
		//Clicking on I AGREE Button
	//	driver.findElement(By.xpath("//*[@class='ckn-buttons']/a[1]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		

//       WebElement ads_1 = driver.findElement(By.xpath("//section[@class=\"ent-grid\"]/div/div/div[7]/ads/div"));

		WebElement infiniteScrollView = driver.findElement(By.xpath("//*[@class='ent-grid']/div/div"));

		//// *[@class='ent-grid']/div/div for the infinite scrollView

		js.executeScript("arguments[0].scrollIntoView();", infiniteScrollView);

		WebElement ads_1 = infiniteScrollView
				.findElement(By.xpath("//section[@class='ent-grid']/div/div/div[7]/ads/div"));

		Thread.sleep(2000);
//       JavascriptExecutor js = (JavascriptExecutor) driver;
//       js.executeScript("window.scrollBy(0,400)");

//        adsMessage.click();
		boolean isAdsDisplayed_1 = ads_1.isDisplayed();

		System.out.println("Is first ads Displayed? " + isAdsDisplayed_1);

//       ads_1.click();

		// //section[@class='ent-grid']/div/div/div[13]/ads/div

		Thread.sleep(3000);

		js.executeScript("arguments[0].scrollIntoView();", ads_1);

		WebElement ads_2 = infiniteScrollView
				.findElement(By.xpath("//section[@class='ent-grid']/div/div/div[13]/ads/div"));

		Thread.sleep(4000); // recently changed this to 2000 to 3000 to 4000
//      JavascriptExecutor js = (JavascriptExecutor) driver;
//      js.executeScript("window.scrollBy(0,400)");

//       adsMessage.click();
		boolean isAdsDisplayed_2 = ads_2.isDisplayed();

		System.out.println("Is seconds ads Displayed? " + isAdsDisplayed_2);

//		Thread.sleep(2000);
		ads_2.click();

		Thread.sleep(2000);
		
		System.out.println(" ======================== Clicked ========================");

//		js.executeScript("arguments[0].scrollIntoView();", ads_2);
//
//		WebElement ads_3 = infiniteScrollView
//				.findElement(By.xpath("//section[@class='ent-grid']/div/div/div[18]/ads/div"));
//
//		Thread.sleep(2000);
////JavascriptExecutor js = (JavascriptExecutor) driver;
////js.executeScript("window.scrollBy(0,400)");
//
////adsMessage.click();
//		boolean isAdsDisplayed_3 = ads_3.isDisplayed();
//
//		System.out.println("Is third ads Displayed? " + isAdsDisplayed_3);
//
//		Thread.sleep(2000);
//
//		js.executeScript("arguments[0].scrollIntoView();", ads_3);
//
//		WebElement ads_4 = infiniteScrollView
//				.findElement(By.xpath("//section[@class='ent-grid']/div/div/div[24]/ads/div"));
//
//		Thread.sleep(2000);
////JavascriptExecutor js = (JavascriptExecutor) driver;
////js.executeScript("window.scrollBy(0,400)");
//
//		js.executeScript("arguments[0].scrollIntoView();", ads_4);
////adsMessage.click();
//		boolean isAdsDisplayed_4 = ads_4.isDisplayed();
//
//		System.out.println("Is fourth ads Displayed? " + isAdsDisplayed_4);
//
//		ads_4.click();
//
//		Thread.sleep(2000);

		// Adding a small wait time to ensure the script has time to scroll
		// Thread.sleep(500); // Be cautious with using Thread.sleep as it can make
		// tests flaky

		// Replace "yourElementId" with the actual ID of the element you want to check
		// String elementId = "yourElementId";

		// Wait for the element to be visible using WebDriverWait
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
//
//        // Check if the element is displayed
//        boolean isElementVisible = element.isDisplayed();
//        Assert.assertTrue(isElementVisible, "Element with ID '" + elementId + "' is not visible.");
//
//        // You can also print the result in the console
//        System.out.println("Is Element with ID '" + elementId + "' Visible? " + isElementVisible);
	}

//        Assert.assertTrue(adsMessage.isDisplayed(), "Element is not displayed on the webpage.");

	// status="passed";

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			// driver.executeScript("lambda-status=" + status);
			driver.quit();
		}
	}
}
