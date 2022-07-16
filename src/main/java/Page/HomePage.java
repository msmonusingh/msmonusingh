package Page;

import Base.Baseclass;
import com.aventstack.extentreports.Status;


public class HomePage extends Baseclass {

    public void homePgae() {
        driver.get("https://beta.amazjobs.com/");
        //test.log(Status.INFO, "home page open");


    }
}
