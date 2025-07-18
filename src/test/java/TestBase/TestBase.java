package TestBase;

import com.google.common.util.concurrent.Service;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public AndroidDriver driver;
    public static DesiredCapabilities caps;
    public static AppiumDriverLocalService service;;

    @BeforeClass
    public static void Capabilities() {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:udid", "emulator-5554");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.accion.money.accion_money");
        caps.setCapability("appium:appActivity", "com.accionmfb.accion_monie_v2.MainActivity");
        caps.setCapability("appium:noReset", true); // boolean, not string
    }
    @BeforeClass
    public static void startServer(){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\iaghanchi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info").build();
                 service.start();
    }
    @Test
    public void setUp() {
        startServer();
        Capabilities();
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        if(driver==null){
            driver.quit();
        }
    }
}
