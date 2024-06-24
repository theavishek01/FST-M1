package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Home page title: " + driver.getTitle());

        WebElement toggleBtn = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        toggleBtn.click();

        WebElement dynamicChkbx = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']"));
        wait.until(ExpectedConditions.invisibilityOf(dynamicChkbx));

        System.out.println("Checkbox hidden");

        toggleBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicChkbx));
        System.out.println("Checkbox visible");

        driver.quit();
    }
}
