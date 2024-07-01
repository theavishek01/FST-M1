package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void headerImgURL(){
        WebElement image = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
        String imgSrc = image.getAttribute("src");
        System.out.println("Image URL: "+imgSrc);
    }
    @AfterClass(alwaysRun = true)
    public void closeTest(){
        driver.close();
    }
}
