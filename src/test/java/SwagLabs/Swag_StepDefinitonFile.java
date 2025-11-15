package SwagLabs;

import java.awt.Desktop.Action;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Swag_StepDefinitonFile {
     
	 WebDriver driver = Swag_Hookfile.driver;
 //  WebDriverWait wait = Swag_Hookfile.wait;
	 


@Given("User navigates to {string}")
public void user_navigates_to(String url) {
    
	driver.get(url);
	
}

@When("User enters username {string}")
public void user_enters_username(String username) {
	
   driver.findElement(By.id("user-name")).sendKeys(username);
   
}

@When("User enters password {string}")
public void user_enters_password(String password) {

   driver.findElement(By.id("password")).sendKeys(password);
}

@When("User clicks on login button")
public void user_clicks_on_login_button() {
	
   driver.findElement(By.id("login-button")).click();
   
}

@Then("User should be navigated to the Products page")
public void user_should_be_navigated_to_the_products_page() {
   
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Swag Labs']")));
       	
     String Actual_text = text.getText();
     
       if(Actual_text.equals("Swag Labs"))
        {
    	   System.out.println(Actual_text + " -- Login Successfull");
        }
       else 
       {
    	   System.out.println("Login Failed");
       }
           

}

@Then("User should see error message {string}")
public void user_should_see_error_message(String ERROR) {
     
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement errormsg = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']")));
 
          String errorText = errormsg.getText();
        	 System.out.println(errorText); 
}

@Given("User enters the products and select the price {string}") 
public void User_enters_the_products_and_select_the_price(String ProductPrice) throws Exception {
	
	WebElement price = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
	     Select s = new Select(price);
            Thread.sleep(3000);
	    s.selectByVisibleText(ProductPrice);
  
	    }

@Then("user clicks on Twitter Facebook LinkedIn and user switch to fb and creates an account and switch back to parent tab")
public void social_media() throws Exception
{
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(18));  
	driver.findElement(By.xpath("//a[text()='Twitter']")).click();
	driver.findElement(By.xpath("//a[text()='Facebook']")).click();
	driver.findElement(By.xpath("//a[text()='LinkedIn']")).click();
	
	 String Parent_Tab = driver.getWindowHandle();
	  Set<String> child_tabs = driver.getWindowHandles();
	   
	    
	  for(String a:child_tabs)
	    {
	    WebDriver t1 =driver.switchTo().window(a);
	      String tab_names = driver.getTitle();
	          System.out.println(tab_names);
	          
	       if(tab_names.equals("Sauce Labs | Facebook"))
	           {
driver.findElement(By.xpath("//div[@class='xjbqb8w x1iyjqo2 x193iq5w xeuugli x1n2onr6']//input[@name='email']")).sendKeys("seeenaa");        
	    	   
	        	  driver.findElement(By.xpath("//div[@aria-label='Create new account']")).click();
	                
	            
                   String parent_tab1 =   driver.getWindowHandle();
                  Set<String>  child =  driver.getWindowHandles();
                  
                  for(String aa:child)
                  {
                WebDriver t2 = driver.switchTo().window(aa);
                
                  }

    driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Robin");
	         driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Hood");
	        
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByVisibleText("1");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Jan");
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("2000");
        
        
     driver.findElement(By.xpath("//label[text()='Male']/input[@name='sex']")).click();
     driver.findElement(By.name("reg_email__")).sendKeys("yyyzzz045@gmail.com");
     driver.findElement(By.id("password_step_input")).sendKeys("Yyy000@@");
     driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']")).click();
       
     WebDriverWait wwww = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement ww = wwww.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_error_inner")));
             
             String actualtext1 = ww.getText();
             if(actualtext1.equals("It looks like you're trying to create an account for a business, organisation or character. Please create a "))
             {
            	 System.out.println(actualtext1 + " created_*****");
             }
             else
             {
            	 System.out.println("Login Failed********");
             }
            System.out.println("***** DoNe *****");
      
	           }
	         	  
	    }
	             driver.switchTo().window(Parent_Tab);
        
}


@Then ("user clicks on {string} and add to cart")
public void user_clicks_on_product_and_add_to_cart (String productName) {
    driver.findElement(By.xpath("//div[text()='" + productName + "']//ancestor::div[@class='inventory_item']//button")).click();
    driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
    System.out.println(productName + " added to cart and cart page opened successfully!");
}



@Then("user verifies {string} product which has price {string}")
public void user_verifies_product_which_has_price(String productName, String expectedPrice) {

    WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement product = w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='inventory-item-name']")));
    String actual_product = product.getText();
    System.out.println("Actual Product : " +  actual_product);

    if (actual_product.equals(productName)) {
        Assert.assertEquals(actual_product, productName, "--- Product Available");
        System.out.println("Product name matched successfully: " + actual_product);
    } else {
        System.out.println("Product name not matching");
    }

    WebElement price = w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='inventory-item-price']")));
    String actual_price = price.getText();
    System.out.println("Actual Price: " + actual_price);

    if (actual_price.equals(expectedPrice)) {
        Assert.assertEquals(actual_price, expectedPrice, "----- Price matching");
        System.out.println("Price matched successfully: " + actual_price);
    } else {
        System.out.println("Price not matching - Failed");
    }
}


@Then ("user clicks on checkout and fill address {string}, {string}, {string}")
public void address(String FN , String LN , String postalcode)
{
	driver.findElement(By.id("checkout")).click();
	
	driver.findElement(By.id("first-name")).sendKeys(FN);
	driver.findElement(By.id("last-name")).sendKeys(LN);
	driver.findElement(By.id("postal-code")).sendKeys(postalcode);
	driver.findElement(By.id("continue")).click();
	
}

@Then("user clicks on finish and return back to homepage")
 public void finish() throws Exception
 {
	WebDriverWait wait001 = new WebDriverWait(driver, Duration.ofMillis(5000));
 	  driver.findElement(By.xpath("//button[text()='Finish']")).click();
          
 WebElement h1 =  wait001.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='complete-header']")));
      String actual_t = h1.getText();
      String expected_t = "Thank you for your order!";
      
      if(actual_t.equals(expected_t))
      {
    	  System.out.println(actual_t + " -- Order Successfull");
      }
      else
      {
    	  System.out.println("Order Failed");
      }
      
          Thread.sleep(Duration.ofSeconds(4));
  WebElement scr = driver.findElement(By.id("contents_wrapper")) ;   
          
          TakesScreenshot ts = (TakesScreenshot) driver;
      File source = scr.getScreenshotAs(OutputType.FILE);
      File destination = new File("C:\\Users\\srini\\eclipse-workspace\\Swag_Labss\\target\\Swag_LabsReportss\\ScreenShot\\OrderSuccessfull_Screenshot.png");
       source.renameTo(destination);
        System.out.println("ScreenShot captured");
          
        
      driver.findElement(By.xpath("//button[text()='Back Home']")).click();
     

 }


 @Then ("user clicks on open menu and then About")
 public void open_menu() throws Exception
 {
	  
	 driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
	 driver.findElement(By.xpath("//a[text()='About']")).click();
	 
	 	 
WebElement product	= driver.findElement(By.xpath("//div[@class='MuiContainer-root MuiContainer-maxWidthXl MuiContainer-disableGutters css-1l45bh9']//span[text()='Products']"));
      Actions act = new Actions(driver);
              act.moveToElement(product).build().perform();
              
    driver.findElement(By.xpath("//div[@class='MuiBox-root css-1n2ole0']//span[text()='Sauce Web Testing']")).click();
 
 }



}
