package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity3 {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException  {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.sec.android.app.popupcalculator")
                .setAppActivity(".Calculator")
                .noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, caps);
    }
    @Test
    public void addition(){
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Plus")).click();
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("Calculation")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(result,"14 Calculation result");
    }
    @Test
    public void subtract(){
        driver.findElement(AppiumBy.accessibilityId("1")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Minus")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Calculation")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(result,"5 Calculation result");
    }
    @Test
    public void multiply(){
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.accessibilityId("1")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Calculation")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(result,"500 Calculation result");
    }
    @Test
    public void division(){
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Division")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();
        driver.findElement(AppiumBy.accessibilityId("Calculation")).click();
        String result = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(result,"25 Calculation result");
    }
    @AfterClass
    public void closeTest(){
        driver.quit();
    }
}
