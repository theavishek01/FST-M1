package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Page title: "+driver.getTitle());

        String H3 = driver.findElement(By.xpath("//h3[@class='ui yellow header']")).getText();
        System.out.println("3rd Header text: "+H3);

        String H5 = driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        System.out.println("5th Header color: "+H5);

        String violetBtn = driver.findElement(By.xpath("//button[@class='ui violet button']")).getAttribute("class");
        System.out.println("Violet button class: "+violetBtn);

        String greyBtn = driver.findElement(By.xpath("//button[@class='ui grey button']")).getText();
        System.out.println("Grey button text: "+greyBtn);

        driver.quit();
    }
}
