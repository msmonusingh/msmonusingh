package Page;

import Base.Baseclass;
import com.relevantcodes.extentreports.LogStatus;

public class HomePgae extends Baseclass {

    public  void homePgae()
    {
        driver.get("https://beta.amazjobs.com/");
        test.log(LogStatus.INFO,"website is open");
    }
}
