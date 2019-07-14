package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import utility.setup;


public class login_page {

	private WebDriver driver;
	
	@Given("^Open Webapp$")
	public void open() {
		System.out.println("########################");
		driver = new setup().getChromeDriver();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
		driver.get("http://ec2-13-235-82-170.ap-south-1.compute.amazonaws.com:8080/SpringCICD/login");
	}
	
	@Given("^If page title is \"(.*)\"$")
	public void check_title(String title)
	{
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(title));
	}
	
	@Given("^enter username \"(.*)\"$")
	public void enter_un(String un)
	{
		System.out.println(un);
		driver.findElement(By.id("username")).sendKeys(un);
	}
	
	@Given("^enter password \"(.*)\"$")
	public void enter_pw(String pw)
	{
		driver.findElement(By.id("password")).sendKeys(pw);
	}
	
	@Given("^click on submit$")
	public void click_submit()
	{
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
	}
	
	@Given("^check bad credentials message$")
	public void check_bad_user_message()
	{
		boolean Vflag = driver.findElement(By.xpath("//div[@class='alert alert-danger' and text()='Bad credentials']")).isDisplayed();
	    Assert.assertTrue(Vflag);
	}
	
	@Given("^check validation message for username$")
	public void check_vald_msg_username()
	{
		boolean Vflag = driver.findElement(By.id("username")).getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field.");
	    //System.out.println(driver.findElement(By.id("username")).getAttribute("validationMessage"));
		Assert.assertTrue(Vflag);
	}
	
	@Given("^check validation message for password$")
	public void check_vald_msg_password()
	{
		boolean Vflag = driver.findElement(By.id("password")).getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field.");
	    //Assert.assertTrue(Vflag);
	}
	
	@Given("^close browser$")
	public void close_browser()
	{
		driver.quit();
	}
	
	
}
