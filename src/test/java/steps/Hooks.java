package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.ScreenOrientation;
import utils.HelperClass;

public class Hooks {
    @Before
    public static void launchApp() {
        HelperClass.getDriver().activateApp(HelperClass.getCurrentAppBundleId());
        if (HelperClass.getDriver().getOrientation() == ScreenOrientation.LANDSCAPE){
            HelperClass.getDriver().rotate(ScreenOrientation.PORTRAIT);
        }
    }

    @After
    public static void closeApp() {
        HelperClass.getDriver().terminateApp(HelperClass.getCurrentAppBundleId());
    }
}
