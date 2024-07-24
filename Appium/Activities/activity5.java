package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class activity5 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.apps.messaging")
                .setAppActivity(".ui.ConversationListActivity")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void message(){
        driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("ContactSearchField")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Type names, phone numbers or emails']")));
        driver.findElement(AppiumBy.id("ContactSearchField")).sendKeys("8210789145");

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id='ContactSuggestionList']/android.view.View")));
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='ContactSuggestionList']/android.view.View")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")));
        driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys("Hello from Appium");

        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='Compose:Draft:Send']/android.widget.Button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id='message_list']/android.view.View[1]/android.view.View[1]")));

    }
    @AfterClass
    public void closeTest(){
        driver.quit();
    }
}
