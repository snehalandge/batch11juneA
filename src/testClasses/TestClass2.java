package testClasses;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import base.Driver;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class TestClass2 {
	
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
	@Test(priority=1)
	public void verifyusercanSearchProduct () throws InterruptedException 
	{
	k1.searchProduct();
		
		k1 = new HomePage(driver);
		
		String actualText =k1.getValidText();
		
		Assert.assertTrue(actualText.contains("Showing 1 –"));	
		
	}
	@Test(priority = 2)
	public void VerifyUserCanGetLowestPriceProductFromEachPage() {
		
		
		Map<Integer, String> lowPriceMapExpected = new HashMap<>();
		lowPriceMapExpected.put(1, "10000");
		lowPriceMapExpected.put(2, "10000");
		lowPriceMapExpected.put(3, "10000");
		lowPriceMapExpected.put(4, "10000");
		lowPriceMapExpected.put(5, "10000");
		
		
	//	List<String> lowsetPriceFron5Page = new ArrayList<>();
		
		Map<Integer, String> lowPriceMapActual = new HashMap<>();
		
		for(int i=1; i<=5; i++) {
			
			if(i != 1) {
				
				k1.switchToPage(i);
			}
			k1 = new HomePage(driver);
			
	//	lowsetPriceFron5Page.add(hp.getLowestPriceOfProduct());
			
			lowPriceMapActual.put(i, k1.getLowestPriceofProduct());
		}
		
		
	}
	@Test
	public void test2()
	{
		System.out.println("test2");
		
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
		
	}
	@AfterClass
	public void afterClass()
	{
		
		System.out.println("after class");
	}
	
	

}
