package demo;

//import static org.junit.Assert.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.junit.*;
//import org.junit.jupiter.api.*;
//import org.junit.After;
//import org.junit.Assert;.....
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
//	WebDriver driver = new ChromeDriver();
	private static WebDriver driver;
	
	@Test (priority=1)
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\flyma\\OneDrive\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://sakshingp.github.io/assignment/login.html");
		driver.manage().window().maximize();

		
	}
  @Test (priority=2)
	public void test_title() throws InterruptedException{
		// TODO Auto-generated method stub
		String actualTitle = driver.getTitle();
//		Assert.assertEquals("Demo App",actualTitle);
        Assert.assertEquals("Demo App", actualTitle);
		System.out.println(" Title Matched! Test case Passed!");

  }
  
  @Test (priority=3)
	public void test_login_details() throws InterruptedException{
	  
		
//		 Enter valid user_name and password to login.........
			driver.findElement(By.id("username")).sendKeys("akshay");
			Thread.sleep(1000);
			driver.findElement(By.id("password")).sendKeys("jain");
			Thread.sleep(1000);	
			
			// Remember me 
//			boolean isElementSelected = driver.findElement(By.className("form-check-input")).isSelected();
//			Assertions.assertTrue(isElementSelected, "Element is not selected");
			
			driver.findElement(By.className("form-check-input")).click();
			boolean isElementSelected = driver.findElement(By.className("form-check-input")).isSelected();
			Assert.assertTrue(isElementSelected);
			System.out.println("Remenber me Clickable! Test case Passed!");
			Thread.sleep(1000);

			
			// Click on login....
			driver.findElement(By.id("log-in")).click();
			Thread.sleep(2000);
  }
  @Test (priority=4)
	public void test_url() throws InterruptedException{
	  

			
			// save current url and compare with original url....
			String act_url = driver.getCurrentUrl();
			System.out.println("Current url: "+act_url);
			Assert.assertEquals(act_url,"https://sakshingp.github.io/assignment/home.html");
			System.out.println("Home url Matched! Test Case Passed");
  }
  
  @Test (priority=5)
	public void test_table_clickable() throws InterruptedException{

			
			
			// Navigate to the transaction table.......
		    WebElement transactionTable = driver.findElement(By.id("transactionsTable"));
		    transactionTable.click();
		    
  }
  
  @Test (priority=6)
	public void test_sort() throws InterruptedException{

	//Locate the AMOUNT header element and click it........
	  WebElement amountHeader = driver.findElement(By.id("amount"));
	    amountHeader.click();
	    
		Thread.sleep(1000);
			
			// Extract the value of the onclick attribute to check sort function execute or not ......
			String onclickValue = amountHeader.getAttribute("onclick");
		
			// Check if the onclick attribute value matches the expected value
			boolean isSorted = onclickValue != null && onclickValue.equals("sortTable(4)");
		
			// Save the result of the check in a boolean variable.....
			Assert.assertEquals(isSorted,true);
			System.out.println(" Amount Header Sorted! Test Case Passed!");

		   
			Thread.sleep(1000);
//			driver.quit();

			
  }


  @Test (priority=7)
public void closeBrowser() {
	driver.quit();
}

}
