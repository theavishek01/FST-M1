package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Home page title: " + driver.getTitle());

        driver.findElement(By.xpath("//button[@class='ui violet button']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajax-content']/h1")));

        System.out.println(driver.findElement(By.xpath("//div[@id='ajax-content']/h1")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajax-content']/h3")));
        System.out.println(driver.findElement(By.xpath("//div[@id='ajax-content']/h3")));

        driver.quit();
    }
}
