package parallel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(value = "@Skip", order = 0)
	public void skip_scenario(Scenario scenario) {
		System.out.println("SKIPPED SCENARIO is: " + scenario.getName());
		Assume.assumeTrue(false);
	}

	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 2)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

	
//	private DriverFactory driverFactory;
//	private WebDriver driver;
//	private ConfigReader configReader;
//	Properties prop;
//	
//	
//	@Before(order = 0)
//	public void getProperty() {
//		configReader = new ConfigReader();
//		prop = configReader.init_prop();	
//	}
//	
//	@Before (order = 1)
//	public void launchBrowser() {
//		String browserName = prop.getProperty("browser");
//		driverFactory = new DriverFactory();
//		driver = driverFactory.init_driver(browserName);
//	}
//	/* Note: 
//	 * In case @Before (), annotation the order = 0 will be executed first, and then order = 1 will be executed.
//	 * But in case of @After() annotation the order = 0 will be executed second, and order = 1 will be executed first.
//	 */
//	@After(order = 0)
//	public void quitBrowser() {
//		driver.quit();
//	}
//	
//	/* This method will take the screenshot.
//	 * The Scenario object should be imported from "io.cucumber.java.Scenario"
//	 */
//	
//	@After (order = 1)
//	public void tearDown(Scenario scenario) {
//		if(scenario.isFailed()) {
//			// take screenshot
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//			
//			scenario.attach(sourcePath, "image/png", screenshotName);
//		}
//	}
//	

}
