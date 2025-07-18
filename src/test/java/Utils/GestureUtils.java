// File: utils/GestureUtils.java
package Utils;

import TestBase.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Pause;

import java.time.Duration;
import java.util.Arrays;

public class GestureUtils extends TestBase {

        public static void performSwipe(AndroidDriver driver, int startX, int startY, int endX, int endY, int holdMillis, int moveMillis) {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(0)); // 0 = left button or touch
            swipe.addAction(new Pause(finger, Duration.ofMillis(holdMillis)));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(moveMillis), Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(0));   // 0 = left button or touch

            driver.perform(Arrays.asList(swipe));
        }

    public static void swipeUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        GestureUtils.performSwipe(driver, startX, startY, startX, endY, 300, 700);
    }

    public static void swipeDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);
        performSwipe(driver, startX, startY, startX, endY, 300, 700);
    }

    public static void swipeLeft(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startY = size.height / 2;
        int startX = (int) (size.width * 0.9);
        int endX = (int) (size.width * 0.1);
        performSwipe(driver, startX, startY, endX, startY, 300, 700);
    }

    public static void swipeRight(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startY = size.height / 2;
        int startX = (int) (size.width * 0.1);
        int endX = (int) (size.width * 0.9);
        performSwipe(driver, startX, startY, endX, startY, 300, 700);
    }
}
