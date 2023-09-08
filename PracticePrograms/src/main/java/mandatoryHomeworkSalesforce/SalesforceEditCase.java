package mandatoryHomeworkSalesforce;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceEditCase {
    public static void main(String[] args) {
        
    	WebDriverManager.chromedriver().setup();

        
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("dharsinieee@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Archanadharsini07*");
        driver.findElement(By.id("Login")).click();

        
        driver.findElement(By.className("slds-icon-waffle")).click();

       

        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        
     
        WebElement moreTab = driver.findElement(By.xpath("//a[@title='More']"));
        moreTab.click();

       
        WebElement dropdownIcon = driver.findElement(By.xpath("//a[@title='Show Navigation Menu']"));
        dropdownIcon.click();

        WebElement casesOption = driver.findElement(By.xpath("//a[@title='Cases']"));
        casesOption.click();
        
     
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    

        WebElement casesTab = driver.findElement(By.xpath("//a[@title='Cases Tab']"));
        casesTab.click();

        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        
        
        

       

       String caseOwnerAlias = "ADhar"; 
        WebElement caseDropdown = driver.findElement(By.xpath("//a[contains(@title, '" + caseOwnerAlias + "')]"));
       caseDropdown.click();
       driver.findElement(By.xpath("//a[text()='Edit']")).click();

       

        WebElement statusDropdown = driver.findElement(By.xpath("//span[text()='Status']/parent::label/following-sibling::div//a"));
        statusDropdown.click();
        driver.findElement(By.xpath("//a[text()='Working']")).click();

        

        WebElement priorityDropdown = driver.findElement(By.xpath("//span[text()='Priority']/parent::label/following-sibling::div//a"));
        priorityDropdown.click();
        driver.findElement(By.xpath("//a[text()='Low']")).click();

        
        WebElement caseOriginDropdown = driver.findElement(By.xpath("//span[text()='Case Origin']/parent::label/following-sibling::div//a"));
        caseOriginDropdown.click();
        driver.findElement(By.xpath("//a[text()='Phone']")).click();

        
        WebElement slaViolationDropdown = driver.findElement(By.xpath("//span[text()='SLA Violation']/parent::label/following-sibling::div//a"));
        slaViolationDropdown.click();
        driver.findElement(By.xpath("//a[text()='No']")).click();

        
        driver.findElement(By.xpath("//button[text()='Save']")).click();

        
        driver.quit();
    }
}
