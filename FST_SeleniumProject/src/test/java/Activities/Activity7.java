package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test(priority = 0)
    @Parameters({"username","password"})
    public void login(String username, String password){
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test(priority = 1)
    public void addQuali(){
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//ul[@id='sidenav']//a[contains(text(),'Qualifications')]")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("SDET");
        driver.findElement(By.id("experience_from_date")).sendKeys("2022-02-17");
        driver.findElement(By.id("experience_to_date")).sendKeys("2023-02-18");
        driver.findElement(By.id("btnWorkExpSave")).click();
    }
    @AfterClass(alwaysRun = true)
    public void closeTest(){
        driver.close();
    }
}
