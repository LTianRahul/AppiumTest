package appiumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class testCompleteSunWing {
	String username = "rahulkumarlambdatest";
	String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
	private WebDriver driver;
	private String status = "failed";

	public String gridURL = "@hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", false);
		ltOptions.put("build", "SunWing");
		ltOptions.put("browser", "chrome");
		ltOptions.put("platform", "win 11");
		ltOptions.put("browserVersion", "122.0");
		ltOptions.put("visual", true);
		ltOptions.put("console", true);
		capabilities.setCapability("lt:options", ltOptions);

		driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey + gridURL), capabilities);
	}

	@Test
	public void testAdsDetails() throws InterruptedException {
		//driver.get("https://www.sunwing.ca/en/");
		
		driver.get("https://get.metaboosting.com/fb/quiz-03/");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[text()='Men Start Here']")).click();
		
//		driver.findElement(By.xpath("//a[normalize-space()='Flights']")).click();

		Thread.sleep(5000);
		
		//driver.findElement(By.cssSelector("#booking-search-box-app > form > div > label:nth-child(3) > span:nth-child(2)")).click();
		
		
//		WebElement shadowElement = (WebElement) driver.findElement(By.xpath("//div[@id='booking-search-box-wrapper']"))//Shadow Host root locator
//				.getShadowRoot().findElement(By
//						.cssSelector("#booking-search-box-app > form > div > label:nth-child(3) > span:nth-child(2)"));//radio button element
//
//		shadowElement.click(); //clicking or selecting the radio button

		Thread.sleep(10000);

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
