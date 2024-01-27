package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.HelperClass;

public class Hooks {
    @Before
    public static void launchApp() {
        HelperClass.getDriver().activateApp("com.vodqareactnative");
    }

    @After
    public static void closeApp() {
        HelperClass.getDriver().terminateApp("com.vodqareactnative");
    }
}
