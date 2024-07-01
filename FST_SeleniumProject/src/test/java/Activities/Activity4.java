package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity4 {
    WebDriver driver;
    WebDriverWait wait;
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
    public void addEmp(){
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Xerox");
        driver.findElement(By.id("lastName")).sendKeys("Diamond");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        //driver.findElement(By.id("empsearch_employee_name_empName")).clear();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Xerox");
        //driver.findElement(By.xpath("//div[@class='ac_results']/ul/li[@class='ac_even ac_over']")).click();
        driver.findElement(By.id("searchBtn")).click();
        String name= driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr/td[3]")).getText();
        //String name= driver.findElement(By.xpath("//li[@class='ac_even ac_over']")).getText();

        Assert.assertEquals(name,"Xerox");
    }
    @AfterClass(alwaysRun = true)
    public void closeTest(){
        driver.close();
    }
}
