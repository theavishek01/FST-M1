package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestSteps {
    WebDriver driver;

    @Given("User is on Login Page")
    public void userIsOnLoginPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("User enters username and password")
    public void userPass(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.xpath("//button[@class='ui button']")).click();
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }


    @Then("Read the page title and confirmation message")
    public void confirmation(){
        System.out.println(driver.findElement(By.id("action-confirmation")).getText());
    }

    @And("Close the Browser")
    public void closeTest(){
        driver.close();
    }
}
