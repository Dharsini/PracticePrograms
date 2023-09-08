package mandatoryHomeworkSalesforce;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceDeleteCase {
	
    public static void main(String[] args) {
        

    	WebDriverManager.chromedriver().setup();
    	 //System.setProperty("webdriver.chrome.driver", "/Users/archanadharsini/.cache/selenium/chromedriver/mac64/116.0.5845.96/chromedriver");

         
         WebDriver driver = new ChromeDriver();
        
        
        driver.get("https://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("dharsinieee@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Archanadharsini07*");
        driver.findElement(By.id("Login")).click();

        

        
        driver.findElement(By.className("slds-icon-waffle")).click();

        
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();

        
        driver.findElement(By.xpath("//span[text()='Cases']")).click();

        

        String caseOwnerAlias = "ADhar"; 
        WebElement caseDropdown = driver.findElement(By.xpath("//a[contains(@title, '" + caseOwnerAlias + "')]"));
        caseDropdown.click();
        driver.findElement(By.xpath("//a[text()='Delete']")).click();

        

        
        boolean isCaseDeleted = driver.findElements(By.xpath("//a[contains(@title, '" + caseOwnerAlias + "')]")).isEmpty();

        if (isCaseDeleted) {
            System.out.println("The case with owner alias '" + caseOwnerAlias + "' is deleted.");
        } else {
            System.out.println("The case with owner alias '" + caseOwnerAlias + "' is not deleted.");
        }

        
        driver.quit();
    }
}

