package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class activity4 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.samsung.android.app.contacts")
                .setAppActivity("com.samsung.android.contacts.contactslist.PeopleActivity")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void contacts(){
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
        //driver.findElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id='com.samsung.android.app.contacts:id/container'])[3]")).click();
        //driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id='com.samsung.android.app.contacts:id/titleLayout'])[1]")).sendKeys("999148292");
        //wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.app.contacts:id/nameEdit")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.samsung.android.app.contacts:id/nameEdit")));
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/nameEdit")).sendKeys("Aaditya Varma");

        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id='com.samsung.android.app.contacts:id/editor_content_container'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");
        driver.findElement(AppiumBy.accessibilityId("Save")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.samsung.android.app.contacts:id/header")));
        String name = driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/header")).getText();
        Assert.assertEquals(name,"Aaditya Varma");
    }
    @AfterClass
    public void closeTest(){
        driver.quit();
    }
}
