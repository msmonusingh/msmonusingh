package TestClass;

import Base.Baseclass;
import Page.HomePage;
import com.aventstack.extentreports.Status;

public class Test  extends Baseclass {
    @org.testng.annotations.Test
    public void Test()
    {
        test=extent.createTest("login page");
        HomePage home= new HomePage();
        home.homePgae();
        test.log(Status.INFO,"page open");
    }


}
