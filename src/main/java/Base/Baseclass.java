package Base;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class Baseclass {
    public  static WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports extent;


    @BeforeSuite
    public void setUp() {
        if (extent == null) {
            extent = new ExtentReports("Report/report.html", true);
            extent.loadConfig(new File("Report/ReportsConfig.xml"));
        }
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
    }

    @AfterSuite
    public void teaDown()
    {
        if(driver!=null)
        {
            extent.flush();
            driver.quit();
        }
    }
}
