package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class fitPeoStepDefinition {
	
	WebDriver driver;

    @Given("Navigate to the FitPeo Homepage")
    public void navigateToHomepage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://fitpeo.com");
        Thread.sleep(3000);
    }
    
    @When("Click on Revenue Calculator Page")
    public void revenueCalculator() throws InterruptedException {
    	 Actions actions = new Actions(driver);
         actions.keyDown(Keys.CONTROL) 
                .sendKeys(Keys.SUBTRACT)
                .keyUp(Keys.CONTROL)
                .perform(); 
    	WebElement element = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
    	element.click();
    	Thread.sleep(2000);
    }
    
    @Then("Scroll down to the Slider section")
    public void scrollDown() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    	Thread.sleep(2000);
    }
    
    @And("Adjust the Slider to the value 820")
    public void slider() throws InterruptedException {
    	WebElement sliderHandle = driver.findElement(By.xpath("//div[@class='MuiBox-root css-j7qwjs']/span/span[3]/input"));
    	for (int i = 1; i <= 620 ; i++) {
    		sliderHandle.sendKeys(Keys.ARROW_RIGHT);
        }
        Thread.sleep(3000);
    }
    
    @And("Verify the updated value of 820 in the text field")
    public void textFieldValue() throws InterruptedException {
    	WebElement textBoxValue1 = driver.findElement(By.xpath("//div[@class='MuiFormControl-root MuiTextField-root css-1s5tg4z']/div/input"));
    	String textboxValue = textBoxValue1.getAttribute("value");
    	System.out.println("Value textbox " +textboxValue);
    	Assert.assertEquals(textboxValue, "820");
    	Thread.sleep(1000);
    }
    
    
    @Then("Select the following CPT codes")
    public void userEntersAnd(DataTable dataTable) throws InterruptedException {
    	
    	Thread.sleep(3000);
    	String xpath="//p[text()='/Var/']/following-sibling::label/span/input";        	
        for(Map<String, String> data : dataTable.asMaps()) {
        	
        	driver.findElement(By.xpath(xpath.replace("/Var/",data.get("input1")))).click();
        	driver.findElement(By.xpath(xpath.replace("/Var/",data.get("input2")))).click();
        	driver.findElement(By.xpath(xpath.replace("/Var/",data.get("input3")))).click();
        	driver.findElement(By.xpath(xpath.replace("/Var/",data.get("input4")))).click();
     
        }
        Thread.sleep(1000);
    }
    
    
    @And("Validate recurring payment")
    public void recurringPayment() {
    	WebElement element = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month:']/p"));
    	System.out.println(element.getText());
    	Assert.assertEquals(element.getText(),"$27000");
    }
    

    @After
    public void tearDown() {
	    if (driver != null) {
	          driver.quit(); 
	    }
	}

}
