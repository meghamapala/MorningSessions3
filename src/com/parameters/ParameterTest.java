package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"env","browser","url","emailId","password"})
    //This is another approach of dataDriven using testng.xml
	//not good practice to store Test data in testng.xml file it is up to us
	public void targetLoginTest(String env,String browser,String url,String emailId,String password)
			throws InterruptedException {
		if (browser.equals("chrome")) {
	        System.setProperty("webdriver.chrome.driver", "/Users/meghamapalagama/eclipse-workspace/MorningSessions3/chromedriver 4");
	        driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/meghamapalagama/"
			+ "eclipse-workspace/MorningSessions2/chromedriver 3");
			driver=new FirefoxDriver();
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	driver.get(url);
	
	driver.findElement(By.xpath("//span[@data-test='accountUserName']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"accountNav-signIn\"]/a/div")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("input[name='username']")).sendKeys(emailId);
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
	Thread.sleep(3000);
	driver.close();
	}
}


