package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	//Initializing web driver and keeping it public for other packages to access
	public static WebDriver wd;
	public static Properties properties;
	public FileInputStream file;

	public TestBase() {
		try {
			properties = new Properties();
			file = new FileInputStream(
					"C:\\Users\\singh\\Inderjit-workspace\\AddCustomer\\src\\main\\java\\Configuration\\configuration.properties");
			properties.load(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void structureInitialisation() {
		/*
		 * WebDriver Manager API to detect the driver version in a system
		 * Switch between browsers when called from configuration
		 */	
		String openSelectedBrowser = properties.getProperty("browser");
		switch (openSelectedBrowser) {
		case ("chrome"):
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
			break;

		case ("edge"):
			WebDriverManager.edgedriver().setup();
			wd = new EdgeDriver();
			break;

		}
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		wd.get(properties.getProperty("WebUrl"));
	}

	public void tearDown() {
		wd.quit();
	}
}
