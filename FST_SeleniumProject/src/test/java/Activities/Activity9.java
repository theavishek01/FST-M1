package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {
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
    public void emergencyCont(){
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//ul[@id='sidenav']//a[contains(text(),'Emergency Contacts')]")).click();
        WebElement tableElement = driver.findElement(By.id("emgcontact_list"));
        List<WebElement> rows = tableElement.findElements(By.xpath("//tbody/tr"));
        for (WebElement rowElement : rows) {
            List<WebElement> cells = rowElement.findElements(By.tagName("td"));
            for (WebElement cellElement : cells) {
                String cellData = cellElement.getText();
                System.out.print(cellData + "\t");
            }
        }
    }
    @AfterClass(alwaysRun = true)
    public void closeTest(){
        driver.close();
    }
}
