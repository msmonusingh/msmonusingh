package TestClass;

import Base.Baseclass;
import Page.HomePgae;

public class Test  extends Baseclass {
    @org.testng.annotations.Test
    public void Test()
    {
        test=extent.startTest("home page");
        HomePgae home= new HomePgae();
        home.homePgae();
    }


}
