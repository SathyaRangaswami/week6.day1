package steplead;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	public ChromeDriver driver;
	public String leadID;
	public List<String>  allhandles;
	public List<String> allhandles2;
	public String newCompanyName;
	public String deleteLeadID;
	public String text;
	@Given("Open the chrome browser")
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
	}
	@Given("Load the application url  {string}")
	 public void loadUrl(String url)
	 {
		 driver.get(url);
		 	
	 }

	@Given("Enter the username as {string}")
	 public void enterUserName(String username)
	 {
		driver.findElement(By.id("username")).sendKeys(username);
		 
	 }
	@Given("Enter the password as {string}")
	 public void enterPassword(String password)
	 {
		driver.findElement(By.id("password")).sendKeys(password);
		 
	 }
	@When("Click on the login button")
	public void clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("Homepage should be displayed")
	public void verifyHomePage() {
		
		String title = driver.getTitle();
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		Assert.assertEquals(displayed,true );
	}
	@When("Click on {string} link")
	public void clickLink(String linkText)
	{
		//driver.findElement(By.linkText(linkText)).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+linkText+"')]")).click();
	}
	@Then("Navigate to {string} page")
	public void verifyPage(String pageName)
	{
		System.out.println(pageName+ "is displayed");
	}
	
	@When("Click on Phone tab")
	public void clickonPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@Given("Enter the phone number as {string}")
	public void phoneNumber(String phoneNumber) {
		
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
	}
	@Given("Enter the delete phone number as {string}")
	public void deletePhoneNumber(String deletephoneNumber) {
	
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(deletephoneNumber);
	}
	@Given("Enter the company name as {string}")
	public void companyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);    
	}
	@Given("Enter the first name as {string}")
	public void firstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		
	}
	@Given("Enter the last name as {string}")
	public void lastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}
	
	@Then("Get the first LeadID")
	public void getFirstLeadId() {
		 leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@Then("Switch to windowhandle0")
	public void switchWindowHandle0() {
		driver.switchTo().window(allhandles.get(0));
	}
	@When("Click on Submit button")
	public void submit()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	@When("Click on Lookup icon")
	public void LookUpIcon() throws InterruptedException {
	 
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	
	}
	@Given("Enter the first name in Lead as {string}")
	public void getFirstName(String firstName)
	{
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);	
	}
	@When("Click on Find Leads link in the lead")
	public void findLead() throws InterruptedException
	{
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	}
	@Then("Get the first Lead ID")
	public void getLead() {
		 leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
						
	}
@When("Click on Lookup icon in lead")
public void lookup() throws InterruptedException
{
	
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
}
@When("Click on  first LeadId")
public void firstLeadId()
{
driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
driver.switchTo().window(allhandles2.get(0));
driver.findElement(By.xpath("//a[text()='Merge']")).click();
driver.switchTo().alert().accept();
}
@When("Click on first LeadID in delete")
public void deleteLeadID() {
	deleteLeadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
}
@Then("Get the first name {string}")
public void editFirstName(String text)
{
 text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
System.out.println("name: "+text);
driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click(); String view = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
 if(view.equals("View Lead"))
 {
	 System.out.println("view Lead is verified");
 }
 else
 {
	 System.out.println("Title not verified");
 }
}
@When("Clear the company name in the updated form")
public void updateCompanyName()
{
	driver.findElement(By.id("updateLeadForm_companyName")).clear();
}
@Given("Enter the new company name as {string}")
public void newCompanyName(String newCompanyName)
{
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newCompanyName);
}
@When("Click on update form")
public void update()
{
	driver.findElement(By.xpath("//input[@value='Update']")).click();
}
@Then("Get the {string} updated and validate")
public void validate(String companyName) {
	 companyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();	
	 System.out.println("newcompanyName: "+companyName);
	 companyName=companyName.replaceAll("//w","");
	 if(companyName.equals(newCompanyName))
	 {
		 System.out.println("Company name is updated");
	 }
	 else
	 {
		 System.out.println("Company name is not updated");
	 }
	 
driver.close();
}
	
	@Given("Enter the LeadID as {string}")
	public void enterLeadId(String deleteLeadID) {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(deleteLeadID);
	}
	@Then("Get the record and validate")
	public void getRecordValidate() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		driver.close();
	}
	@Given("Enter the first name as {string} in edit")
	public void editleadFirstName(String editFirstName)
	{
	driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(editFirstName);
	}
	@When("Click on Email")
	public void clickEmail()
	{
		driver.findElement(By.xpath("//span[text()='Email']")).click();
	}
	@Given("Enter the Emailaddress as {string}")
	public void enterEmail(String emailAddress)
	{
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(emailAddress);
	}
	@Then("Get the first Lead ID in duplicate")
	public void findDuplicate()
	{
		 text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
			System.out.println("name: "+text);
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
			
	}
  @Then("Get the record and validate duplicate")
  public void duplicateVliadate() throws InterruptedException
  {
	  String duplicate = driver.findElement(By.xpath("//div[text()='Duplicate Lead']")).getText();
		 if(duplicate.equals("Duplicate Lead"))
		 {
			 System.out.println("Duplicate Lead is verified");
		 }
		 else
		 {
			 System.out.println("Title not verified");
		 }
		 driver.findElement(By.className("smallSubmit")).click();
		 String text2 = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();	
		 System.out.println("duplicate name: "+text2);
		 if(text.equals(text2))
		 {
			 System.out.println("the duplicated lead name is same as captured name");
		 }
		 else
		 {
			 System.out.println("Lead name are different");
		 }
		 Thread.sleep(5000);
		 driver.close();
  }
  }

