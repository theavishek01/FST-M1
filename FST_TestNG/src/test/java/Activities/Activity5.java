package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test
    public void pageTitleTest(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }
    @Test (groups = {"HeaderTests"})
    public void HeaderTest1(){
        String header3 = driver.findElement(By.id("third-header")).getText();
        Assert.assertEquals(header3,"Third header");
    }
    @Test (groups = {"HeaderTests"})
    public void HeaderTest2(){
        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(251, 189, 8)");
    }

    @Test (groups = {"ButtonTests"})
    public void ButtonTest1(){
        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
    }

    @Test (groups = {"ButtonTests"})
    public void ButtonTest2(){
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }

    @AfterClass(alwaysRun = true)
    public void closeTest(){
        driver.close();
    }
}
