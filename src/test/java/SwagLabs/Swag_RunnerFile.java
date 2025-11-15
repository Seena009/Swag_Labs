package SwagLabs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
	features = "C:\\Users\\srini\\eclipse-workspace\\Swag_Labss\\src\\test\\resources\\Swag.feature"	
  ,glue = "SwagLabs"	
  ,plugin = {"pretty", "html:C:\\Users\\srini\\eclipse-workspace\\Swag_Labss\\target\\Swag_LabsReportss\\Reports.html"   }
  , tags = "@ValidLogin "	
		
		)

public class Swag_RunnerFile {
}
