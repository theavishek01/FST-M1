package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net");
         String pgTitle = driver.getTitle();

        System.out.println("Homepage title: "+pgTitle);

        driver.findElement(By.id("about-link")).click();

        String pg2title = driver.getTitle();

        System.out.println("About us page title: "+pg2title);

        driver.close();
    }
}
