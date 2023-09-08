package mandatoryHomeworkSalesforce;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class SaleforceCreateCase {

    public static void main(String[] args) {
       
    	WebDriverManager.chromedriver().setup();

        
        WebDriver driver = new ChromeDriver();

        
        driver.manage().window().maximize();

        
        driver.get("https://login.salesforce.com");

        

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("Login"));

        usernameInput.sendKeys("dharsinieee@gmail.com");
        passwordInput.sendKeys("Archanadharsini07*");
        loginButton.click();

       
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement globalActionsIcon = driver.findElement(By.cssSelector("button[title='Global Actions']"));
        globalActionsIcon.click();

        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement newCaseButton = driver.findElement(By.xpath("//a[@title='New Case']"));
        newCaseButton.click();

        
        WebElement contactNameDropdown = driver.findElement(By.xpath("//select[@title='Contact Name']"));
        Select contactNameSelect = new Select(contactNameDropdown);
        contactNameSelect.selectByVisibleText("Archana Dharsini "); 

       
        WebElement statusDropdown = driver.findElement(By.xpath("//select[@title='Status']"));
        Select statusSelect = new Select(statusDropdown);
        statusSelect.selectByVisibleText("Escalated");

        
        WebElement subjectInput = driver.findElement(By.xpath("//input[@title='Subject']"));
        WebElement descriptionInput = driver.findElement(By.xpath("//textarea[@title='Description']"));

        subjectInput.sendKeys("Testing");
        descriptionInput.sendKeys("Dummy");

        
        WebElement saveButton = driver.findElement(By.xpath("//button[@title='Save']"));
        saveButton.click();

       
        driver.quit();
    }
}
