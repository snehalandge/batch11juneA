package pomClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	static WebDriver driver;
	
	@FindBy(xpath="//div[text()='My Account']")
	private WebElement profileName;
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchField;
	@FindBy(xpath="//div[@class='_1AtVbE']")
	private WebElement getText;
	
	@FindBy(xpath="//div[@class='_2kHMtA']")
	private WebElement productList;
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> productPriceList;
	@FindBy(xpath="//div[text()='My Profile']")
	private WebElement profilePage;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		
	}
	
	public String getprofiletext() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement newText=wait.until(ExpectedConditions.visibilityOf(profileName));
		
		String pName=newText.getText();
		
		return pName;
		
		
	}
	

	public void searchProduct() {
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement newElement=wait.until(ExpectedConditions.visibilityOf(searchField));
		newElement.sendKeys("realme");
		newElement.sendKeys(Keys.ENTER);
		
		
		
		
		
	}
	public String getValidText() throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement newElement=wait.until(ExpectedConditions.visibilityOf(getText));
		
		String actualWholeText=newElement.getText();
		
		return actualWholeText;
		
		
	}
	public String getLowestPriceofProduct()
	{
		List<Integer> priceList=new ArrayList<>();
		for(WebElement element:productPriceList)
		{
			priceList.add(Integer.parseInt(element.getText().replace("₹", "").replace(",", "")));
			
			
		}
		System.out.println(priceList);
		Collections.sort(priceList);
		return priceList.get(0).toString();
		
		
	}
public void switchToPage(int a) {
		
		driver.findElement(By.xpath("//a[@class='ge-49M' and text()='"+a+"']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ge-49M _2Kfbh8' and text()='"+a+"']")));
		
     }

   public void hoverOnProfilePage()
{
	
	Actions act=new Actions(driver);
	act.moveToElement(profileName).perform();
	
	
}
public void clickOnProfilePage()
{
	
	profilePage.click();
	
}
          

	
	
	

	


}