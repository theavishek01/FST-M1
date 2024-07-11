package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @Test
    public void simpleAlertTestCase(){
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened");

        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched focus to alert");

        String alertText = simpleAlert.getText();
        Reporter.log("Alert text is: " + alertText);

        Assert.assertEquals("This is a JavaScript Alert!", alertText);

        simpleAlert.accept();
        Reporter.log("Alert closed");

        Reporter.log("Test case ended");
    }

    @Test
    public void confirmAlertTestCase(){
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Confirm Alert opened");

        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched focus to alert");

        String alertText = confirmAlert.getText();
        Reporter.log("Alert text is: " + alertText );

        Assert.assertEquals("This is a JavaScript Confirmation!", alertText);

        confirmAlert.accept();
        Reporter.log("Alert closed");

        Reporter.log("Test case ended");
    }

    @Test
    public void promptAlertTestCase(){
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened");

        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched focus to alert");

        String alertText = promptAlert.getText();
        Reporter.log("Alert text is: " + alertText );

        promptAlert.sendKeys("Awesome!");
        Reporter.log("Text entered in prompt alert");

        Assert.assertEquals("This is a JavaScript Prompt!", alertText);

        promptAlert.accept();
        Reporter.log("Alert closed");

        Reporter.log("Test case ended");
    }

    @AfterClass(alwaysRun = true)
    public void closeTest(){
        driver.close();
    }
}
