package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity2 {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, caps);
    }
    @Test
    public void browserTest(){
        driver.get("https://v1.training-support.net/");
        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText());
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText());
    }
    @AfterClass
    public void closeTest(){
        driver.quit();
    }
}
