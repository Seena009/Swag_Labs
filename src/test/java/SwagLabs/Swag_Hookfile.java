package SwagLabs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Swag_Hookfile {

	 public static WebDriver driver ;
	 public static WebDriverWait wait ;
	 
  @Before
  public void SwagLab_Browser()
  {
	   ChromeOptions ch = new ChromeOptions();
       ch.addArguments("--guest");
         driver = new ChromeDriver(ch);  
         driver.manage().window().maximize();
  }
  
  @After
  public void Teardown() throws Exception
  {
	  Thread.sleep(Duration.ofSeconds(8));
	        driver.quit();
  }
	
	
	
}
