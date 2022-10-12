package testClasses;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Driver;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.ProfilePage;

public class TestClass3 {

	
	WebDriver driver;
	LoginPage k;
	HomePage k1;
	ProfilePage k2;
	String oldAddressCount;
	String newAddressCount;

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser)
	{
		driver=Driver.getDriver(browser);
		
		
	}
	@BeforeMethod
	public void beforeMethod()
	{
		k=new LoginPage(driver);
		k1=new HomePage(driver);
		k2=new ProfilePage(driver);
		
		
		
	}
	@Test
	public void verifyUserCanOpenProfilePage()
	{
		k1.hoverOnProfilePage();
		k1.clickOnProfilePage();
boolean onPage = k2.checkUserOnProfilePage();
		
		Assert.assertTrue(onPage);	
		
		oldAddressCount = String.valueOf(k2.getAddressCount());
		
		
	}
	@DataProvider(name="addressData")
	public Object[][] getData() {
		
		Object[][] k = {{"Akshay", "8956235623","413512","Nanded Road", "B-22, A pune"}, {"Sneha","7845124512", "411023", "Warje", "A-32, B shivaji nagar"}};
		return k;
	}
	
	@Test(priority = 2, dataProvider="addressData")
	public void addNewAddress(String name, String phone, String pincode, String locality, String fullAddress) {
		
		k2.clickOnManageAddress();
		
		List<String> addressDetails = Arrays.asList(name, phone, pincode, locality, fullAddress);
		
		k2.addNewAddress(addressDetails);
		
		newAddressCount = String.valueOf(k2.getAddressCount());
		
		boolean isCountMatching = newAddressCount.equals(oldAddressCount);
		
		Assert.assertFalse(isCountMatching);
		
	}
	@AfterClass
	public static void unloadDriver()
	{
		Driver.unloadDriver();
		
	}
	
	
	
	
	
	
	
	}


