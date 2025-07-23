package PageBase;

import TestBase.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class pageBaseClass extends TestBase {
    public static AndroidDriver driver;
    public pageBaseClass(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        pageBaseClass.driver = driver;
    }

    public static void webElementWait(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfAllElements());
    }
    public static void click(WebElement element) {
        webElementWait(element, 2000);
        element.click();
    }

    public void enterText(WebElement element, String text) {
        webElementWait(element, 2000);
        element.sendKeys(text);
    }
}
