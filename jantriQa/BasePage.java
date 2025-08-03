package jantriQa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage 
{
	protected WebDriver driver;

    @BeforeMethod
    public void setUp() 
    {
    	System.setProperty("webdriver.chrome.driver","./soft/chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notifications");
    	WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://dev-dash.janitri.in/"); 
     
    }
    

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
