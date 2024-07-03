package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTestSteps {
    WebDriver driver;
    Alert alert;

    @Given("User is on the page")
    public void openPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }
    @When("User clicks the Simple Alert button")
    public void openSimpleAlert(){
        driver.findElement(By.cssSelector("#simple")).click();
    }

    @Then("Alert opens")
    public void AlertOpens(){
        alert = driver.switchTo().alert();
    }

    @When("User clicks the Confirm Alert button")
    public void openConfirmAlert(){
        driver.findElement(By.cssSelector("#confirm")).click();
    }

    @When("User clicks the Prompt Alert button")
    public void openPromptAlert(){
        driver.findElement(By.cssSelector("#prompt")).click();
    }

    @And("Read the text from it and print it")
    public void readAndPrint(){
        System.out.println("Alert says: " + alert.getText());
    }

    @And("Write a custom message in it")
    public void customMsg(){
        alert.sendKeys("Custom Message");
    }

    @And("Close the alert")
    public void closeAlert(){
        alert.accept();
    }

    @And("Close the alert with Cancel")
    public void closeAlertCancel(){
        alert.dismiss();
    }

    @And("Close Browser")
    public void closeTest(){
        driver.close();
    }
}
