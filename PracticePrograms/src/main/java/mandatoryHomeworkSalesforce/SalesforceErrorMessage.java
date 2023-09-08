package mandatoryHomeworkSalesforce;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceErrorMessage {
    public static void main(String[] args) {
        
    	WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        
        
        driver.get("https://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("dharsinieee@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Archanadharsini07*");
        driver.findElement(By.id("Login")).click();

       

        WebElement toggleMenuButton = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
        toggleMenuButton.click();

        

        WebElement viewAllLink = driver.findElement(By.xpath("//button[@title='View All']"));
        viewAllLink.click();
        WebElement salesLink = driver.findElement(By.xpath("//p[text()='Sales']"));
        salesLink.click();

        
        WebElement casesTab = driver.findElement(By.xpath("//a[@title='Cases']"));
        casesTab.click();

       
        WebElement newButton = driver.findElement(By.xpath("//a[@title='New']"));
        newButton.click();

        
        WebElement contactNameDropdown = driver.findElement(By.xpath("//span[text()='Contact Name']/../following-sibling::div//a"));
        contactNameDropdown.click();
        WebElement selectContactOption = driver.findElement(By.xpath("//a[@title='Contact Name']"));
        selectContactOption.click();

        
        WebElement statusDropdown = driver.findElement(By.xpath("//span[text()='Status']/../following-sibling::div//a"));
        statusDropdown.click();
        WebElement selectStatusNoneOption = driver.findElement(By.xpath("//a[@title='None']"));
        selectStatusNoneOption.click();

        
        driver.findElement(By.xpath("//span[text()='Subject']/../following-sibling::input")).sendKeys("Testing");
        driver.findElement(By.xpath("//span[text()='Description']/../following-sibling::textarea")).sendKeys("Automation testing");

        
        driver.findElement(By.xpath("//button[@title='Save']")).click();

       
        

        
        driver.quit();
    }
}


