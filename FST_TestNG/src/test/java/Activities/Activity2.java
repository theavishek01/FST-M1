package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void Act2Test1(){
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }
    @Test
    public void Act2Test2(){
        WebElement blackbtn = driver.findElement(By.cssSelector("button.ui.black.button"));
        Assert.assertEquals(blackbtn.getText(),"black");
    }

    @Test(enabled = false)
    public void Act2Test3(){

    }

    @Test
    public void Act2Test4(){
        throw new SkipException("Skip exception TC");
    }

    @AfterClass
    public void closeMethod(){
        driver.close();
    }
}
