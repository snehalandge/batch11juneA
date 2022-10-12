package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailID;
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement clickButton;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	public void enterID()
	{
		emailID.sendKeys("varsha_labade@yahoo.com");
		
	}
	public void enterPassword()
	{
		password.sendKeys("varsha@123");
		
	}
	public void clickSubmitButton()
	{
		clickButton.click();
		
		
	}
	
	
	
	
}
