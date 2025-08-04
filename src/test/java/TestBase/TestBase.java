package TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public static AndroidDriver driver;
    public static DesiredCapabilities caps;
    public static AppiumDriverLocalService service;;


    @BeforeSuite
    public static void Capabilities() {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:udid", "BISON2103027170");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.accion.money.accion_money");
        caps.setCapability("appium:appActivity", "com.accion.mfb.accion_monie_v2.MainActivity");
        caps.setCapability("appium:noReset", false);
    }
    @BeforeSuite
    public static void startServer(){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\iaghanchi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info").build();
                 service.start();
    }

    public static Object getScreenshotAs(OutputType<File> file) {
        return file;
    }

    @BeforeSuite
    public void setUp() {
        startServer();
        Capabilities();
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        }
        @AfterSuite
        public void tearDown(){
        if(driver==null){
            driver.quit();
        }

}
}
