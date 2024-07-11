package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://v1.training-support.net");
    }

    @Test
    public void homepageTest(){
        String title = driver.getTitle();
        System.out.println("Page title: "+title);

        Assert.assertEquals("Training Support", title);

        driver.findElement(By.id("about-link")).click();

        System.out.println("New page title: "+ driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"About Training Support");

    }

    @AfterClass
    public void close(){
        driver.quit();
    }

}
