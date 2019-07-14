package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.setup;


public class login_page {

	private static WebDriver driver;
	
	@Given("^User open Webapp$")
	public void open() {
		System.out.println("Starting Chrome Driver");
		driver = new setup().getChromeDriver();
		System.out.println("Chrome Driver started -> Navigating to WebApp");
		driver.get("http://ec2-13-235-82-170.ap-south-1.compute.amazonaws.com:8080/SpringCICD/login");
		System.out.println("WebApp opened");
	}
	
	@Given("^If page title is \"(.*)\"$")
	public void check_title(String title)
	{
		System.out.println("Verifiying if page title is "+ title);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(title));
		System.out.println("Verified page title");
	}
	
	@When("^user enters username \"(.*)\"$")
	public void enter_un(String un)
	{
		System.out.println("entering user name "+un);
		driver.findElement(By.id("username")).sendKeys(un);
		System.out.println("username entered");
	}
	
	@When("^user enters password \"(.*)\"$")
	public void enter_pw(String pw)
	{
		System.out.println("entering password "+pw);
		driver.findElement(By.id("password")).sendKeys(pw);
		System.out.println("password entered");
	}
	
	@When("^user clicks on submit$")
	public void click_submit()
	{
		System.out.println("user clicking on Submit button");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		System.out.println("user clicked on submit button");
	}
	
	@Then("^check for bad credentials message$")
	public void check_bad_user_message()
	{
		System.out.println("checking for bad credentials message");
		boolean Vflag = driver.findElement(By.xpath("//div[@class='alert alert-danger' and text()='Bad credentials']")).isDisplayed();
	    Assert.assertTrue(Vflag);
	    System.out.println("bad credentials message validated");
	}
	
	@Then("^check for validation message for username$")
	public void check_vald_msg_username()
	{
		System.out.println("checking for username validation message");
		boolean Vflag = driver.findElement(By.id("username")).getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field.");
		Assert.assertTrue(Vflag);
		System.out.println("username validation message validated");
	}
	
	@Then("^check for validation message for password$")
	public void check_vald_msg_password()
	{
		System.out.println("checking for password validation message");
		boolean Vflag = driver.findElement(By.id("password")).getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field.");
	    Assert.assertTrue(Vflag);
	    System.out.println("password validation message validated");
	}
	
	@Then("^user closes the browser$")
	public void close_browser()
	{
		System.out.println("user attempting to quit the browser");
		driver.quit();
		System.out.println("user successfully quits the bowser");
	}
	
	@When("^user clears username field$")
	public void clear_un()
	{
		System.out.println("clearing user name ");
		driver.findElement(By.id("username")).clear();
		System.out.println("username cleared");
	}
	
	@When("^user clears password field$")
	public void clear_pw()
	{
		System.out.println("clearing password ");
		driver.findElement(By.id("password")).clear();
		System.out.println("password cleared");
	}
	
	@Then("^check for login validation message$")
	public void check_user_login()
	{
		System.out.println("checking for user login");
		boolean Vflag = driver.findElement(By.xpath("//p[text()='Login Successful!']")).isDisplayed();
	    Assert.assertTrue(Vflag);
	    System.out.println("user login validated");
	}
	
}
