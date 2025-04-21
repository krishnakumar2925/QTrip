package Crio.QTrip.BaseComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSingelton {
	
	
	public static WebDriver driverInstance() throws IOException  {
		WebDriver driver =null;
		Properties pro =new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Crio/QTrip/Utilities/GlobalData.properties");
		pro.load(file);
		
		String browser=pro.getProperty("browser");
		
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();	
		default:
			Assert.fail("Invalid Browser compatibility");
	
		}
		
		if (driver != null) {
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	    }

	    return driver;
	}
	
	public static WebDriver launchApplication(String URL) throws IOException {
		WebDriver driver = driverInstance();
		if(driver!= null) {
			driver.get(URL);
		}
		return driver;
		
	}
	
	public static String Capture(WebDriver driver, String FileName) throws IOException {
		String path = System.getProperty("user.dir")+"/Screenshots";
		File tkdir = new File(path);
		if(!tkdir.exists()) {
			tkdir.mkdir();
		}
		
		File scFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File decFile=new File(path+"/"+FileName+".png");
		FileUtils.copyFile(scFile, decFile);
		return System.getProperty("user.dir")+"/Screenshots"+"/"+FileName+".png";
		
	}
	
	

}
