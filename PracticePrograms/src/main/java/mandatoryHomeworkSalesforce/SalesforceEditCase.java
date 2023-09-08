package mandatoryHomeworkSalesforce;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SalesforceEditCase {

	public WebDriverWait wait;
	public ChromeDriver driver;
	
    @Test(dependsOnMethods = "mandatoryHomeworkSalesforce.SaleforceCreateCase.tc001_CreateNewCase")
	public void tc002_EditCase() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("dharsinieee@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Archanadharsini07*");
		driver.findElement(By.id("Login")).click();
		
		//Click on toggle menu button from the left corner
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Setup Home']"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		
		//Click view All and click Sales from App Launcher
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='View All Applications']"))).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Click on Cases tab visible or select from more.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
		WebElement accountsElement = driver.findElement(By.xpath("//span[text()='More']"));
		wait.until(ExpectedConditions.elementToBeClickable(accountsElement));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",accountsElement);
		driver.findElement(By.xpath("(//*[@data-id='Case'])[last()]")).click();
		driver.findElement(By.xpath("(//*[contains(@class,'rowActionsPlaceHolder')])[1]")).click();
		
		 // Update Status as Working
		driver.findElement(By.xpath("(//a[@title='Edit'])[last()]")).click();
		driver.findElement(By.xpath("(//label[text()='Status']/following-sibling::div)[1]//button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Working']"))).click();	
		
		//Update Priority to low
		driver.findElement(By.xpath("(//label[text()='Priority']/following-sibling::div)[1]//button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Low']"))).click();	
		
		//Update Case Origin as Phone
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//label[text()='Case Origin']/following-sibling::div)[1]//button")));
		driver.findElement(By.xpath("(//label[text()='Case Origin']/following-sibling::div)[1]//button")).click();
	    driver.findElement(By.xpath("//span[@title='Phone']")).click();	
	    
	    //Update SLA violation to No
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//label[text()='SLA Violation']/following-sibling::div)[1]//button")));	
		driver.findElement(By.xpath("(//label[text()='SLA Violation']/following-sibling::div)[1]//button")).click();
		driver.findElement(By.xpath("//span[@title='No']")).click();
		//Click on Save and Verify Status as Working
		driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();	
		driver.findElement(By.xpath("//*[@name='refreshButton']")).click();
		String firstEleStatus = driver.findElement(By.xpath("((//td[4]/span)[1]//span)[1]")).getText();
		Assert.assertEquals(firstEleStatus,"Working");
		
	}
	
	@AfterTest
	public void afterSetup() {
		
		driver.close();
	}


}