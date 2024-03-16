package datadriventesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XMLParameterizationTest {
   @Test
   public void loginTest(XmlTest xml) throws InterruptedException
   {
	   WebDriverManager.firefoxdriver().setup();
	   WebDriver driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.get(xml.getParameter("url"));
	   long time=Long.parseLong(xml.getParameter("time"));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	   driver.findElement(By.name("email")).sendKeys(xml.getParameter("user"));
	   driver.findElement(By.name("password")).sendKeys(xml.getParameter("pwd"));
	   driver.findElement(By.id("last")).click();
	   Thread.sleep(3000);
	   driver.close();
   }
}
