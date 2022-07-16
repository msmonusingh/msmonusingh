package Base;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Baseclass {
    public  static WebDriver driver;

    public  static ExtentTest test;
    public static ExtentReports extent;
    public String screenShotName;


    @BeforeSuite
    public void setUp() {
        if (extent == null) {
            extent= new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
            extent.attachReporter(spark);

        }
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
    }

    public String screenShot() throws IOException {
        Date d= new Date();
        String d1 = d.toString().replace(":", "_").replace(" ", "_");
        screenShotName = "Screen_" + d1 + ".png";
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dest=System.getProperty("user.dir")+"/target/"+screenShotName;
        FileUtils.copyFile(source, new File(dest));
        return dest;

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
