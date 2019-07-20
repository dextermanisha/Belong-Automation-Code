package seleniumgluecode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class test {
	public static WebDriver driver;
    @Given("^User should be able to register$")
    public void user_registration_homepage() throws Throwable {     
    	System.setProperty("webdriver.gecko.driver","C:\\Manisha\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/");
        driver.findElement(By.className("login")).click();
        
    }
    
    @When("^correct email address is entered or should be shown an error message$")
    public void correct_email_address() throws Throwable {
    	driver.findElement(By.id("email_create")).sendKeys("fff");
    	driver.findElement(By.name("SubmitCreate")).click();
    	driver.findElement(By.id("email_create")).sendKeys("dextermanisha@gmail.com");
    	driver.findElement(By.name("SubmitCreate")).click();
    	String loginpageactualtitle=driver.getTitle();
    	String loginpageexpectedtitle="Login - My Store";
    	boolean compare = loginpageexpectedtitle.equalsIgnoreCase(loginpageactualtitle);
    	System.out.println(compare);
    	   	
    }
    
    
    @When("^user is on Megamenu and user hovers over Dresses$")
    public void megamenu() throws Throwable {
    	Actions actions = new Actions(driver);
    	
    	actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Dresses')]"))).perform();
    	
    	  	
    	
    }
    
    @Then("^user should be able to see Summer Dresses$")
    public void dresses_is_displayed() throws Throwable {
    	Actions actions = new Actions(driver);
    	
    	actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Dresses')]"))).perform();
    	
    	Boolean isPresent = driver.findElements(By.xpath("//*[contains(text(),'Summer Dresses')]")).size() > 0;
    }

    @When("^user selects a dress an adds to cart$")
    public void add_cart() throws Throwable {
    	driver.findElement(By.xpath("//*[contains(text(),'Dresses')]")).click();
    	
    	driver.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
    	 	
    	
    	
    }
    
    @Then("^user should be able to see the cart summary page$")
    public void cart_summary() throws Throwable {
    	driver.getPageSource().contains("Product successfully added to your shopping cart");
    	
    }
    
    @Then("^the same product name , color and quantity are displayed in Cart Summary page$")
    public void cart_verification() throws Throwable {
    	String expectedproducttitle="Printed Dress";
    	String expectedproductcolor ="color_13";
    	String expectedquantity="1";
    	String actualproducttitle=driver.findElement(By.className("product-name")).getText();
    	String actualproductcolor=driver.findElement(By.id("layer_cart_product_attributes")).getText();
    	String actualproductquantity=driver.findElement(By.id("layer_cart_product_quantity")).getText();
    	System.out.println("Expected and actual product title match is "+actualproducttitle.equalsIgnoreCase(expectedproducttitle));
    	System.out.println("Expected and actual product color match is "+actualproductcolor.equalsIgnoreCase(expectedproductcolor));
    	System.out.println("Expected and actual product quantity match is "+actualproductquantity.equalsIgnoreCase(expectedquantity));
    	
    }
}
