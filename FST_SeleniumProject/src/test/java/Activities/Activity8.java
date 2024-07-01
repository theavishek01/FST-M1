package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity8 {
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
    public void leaveAppli(){
        driver.findElement(By.xpath("//table[@class='quickLaungeContainer']/tbody/tr/td[4]")).click();
        Select s = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        s.selectByVisibleText("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-07-03");
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-07-04");
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        String leaveStatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[5]")).getText();
        System.out.println(leaveStatus);
    }
    @AfterClass(alwaysRun = true)
    public void closeTest(){
        driver.close();
    }
}
