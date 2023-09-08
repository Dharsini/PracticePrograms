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

public class SaleforceCreateCase {

	public WebDriverWait wait;
	public ChromeDriver driver;
	
	
	@Test
	public void tc001_CreateNewCase()
	{
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Launch the app
		driver.get("https://login.salesforce.com");
		//Login with the credentials
		driver.findElement(By.id("username")).sendKeys("dharsinieee@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Archanadharsini07*");
		driver.findElement(By.id("Login")).click();
		
		//Click on Global Actions SVG icon
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Setup Home']"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='View All Applications']"))).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
		
		WebElement accountsElement = driver.findElement(By.xpath("//span[text()='More']"));
		wait.until(ExpectedConditions.elementToBeClickable(accountsElement));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",accountsElement);
		
		//Click on New Case
		driver.findElement(By.xpath("(//*[@data-id='Case'])[last()]")).click();
		
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//Choose Contact Name from the dropdown
		
		driver.findElement(By.xpath("//*[@placeholder='Search Contacts...']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Archana Dharsini']"))).click();	
		 //Select Case origin as email
		driver.findElement(By.xpath("(//label[text()='Case Origin']/following-sibling::div)[1]//button")).click();
		
		driver.findElement(By.xpath("//span[@title='Email']")).click();	
		//Select status as Escalated
		driver.findElement(By.xpath("(//label[text()='Status']/following-sibling::div)[1]//button")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Escalated']"))).click();
		//Enter Subject as 'Testing' and description as 'Dummy'
		driver.findElement(By.xpath("//*[@name='Subject']")).sendKeys("Testing");
		
		driver.findElement(By.xpath("(//*[text()='Description']/following::textarea)[1]")).sendKeys("Dummy");
		
		// Click 'Save' and verify the message
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String caseNumber = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']//a")).getAttribute("title");
		String expectedNumber = driver.findElement(By.xpath("(//p[@title='Case Number']/following::p)[1]")).getText();		
		Assert.assertEquals(caseNumber, expectedNumber,"case number not created");
		
	}
	
	@AfterTest
	public void afterSetup() {
		
		driver.close();
	}

}