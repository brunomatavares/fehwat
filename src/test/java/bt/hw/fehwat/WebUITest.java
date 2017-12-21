package bt.hw.fehwat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebUITest {
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		
		Properties prop = new Properties();
	
		try {
			InputStream input = Properties.class.getResourceAsStream("/config/config.properties");

			if(input != null) {
				// load a properties file
				prop.load(input);
	
				String browser = prop.getProperty("browser");
						
				if("Firefox".equals(browser)){
					System.setProperty("webdriver.gecko.driver",prop.getProperty("webdriver.gecko.driver"));
					driver = new FirefoxDriver();
				} else if ("Chrome".equals(browser)) {
					System.setProperty("webdriver.chrome.driver",prop.getProperty("webdriver.chrome.driver"));
					driver = new ChromeDriver();
				} else {
					throw new IllegalArgumentException("Invalid browser: " + browser);
		     	}
			} else {
				throw new IllegalArgumentException("Invalid configuration, check config.properties ");
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException("SetUp failed: "+ex.toString());
		}
		
	}
	
	@After
	public void cleanUp(){
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void tearDown(){
		driver.close();
	}
}
