package testClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import base.Driver;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class TestClass1 {

	
	static WebDriver driver;
	LoginPage k;
	HomePage k1;
	
	 
		@BeforeClass
		@org.testng.annotations.Parameters("browser")
		
		public void beforeClass(String browser)
		{
		 driver=Driver.getDriver(browser);
			
		}
		@BeforeMethod
		public void beforeMethod()
		{
			k=new LoginPage(driver);
			
			 k1=new HomePage(driver);
			
		}
		@Test
		public void test1() throws InterruptedException
		{
			k.enterID();
			k.enterPassword();
			k.clickSubmitButton();
			
			
			String pName=k1.getprofiletext();
			
			Assert.assertEquals(pName, "My Account","Profile name is not matching");
			
			
		}
		
			
			

		
		
	         
		
		
		
	
	@AfterMethod
	public void afterMethod()
	{
		
		System.out.println("after method");
	
		
	}

}
