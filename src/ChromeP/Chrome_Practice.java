package ChromeP;

import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import java.util.List;
import java.util.Set;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import javax.imageio.ImageIO;
import java.util.Iterator;
import java.io.*;
import java.util.*;

public class Chrome_Practice 
{
	
	public String driverPath = ("C:\\Users\\ppias\\OneDrive\\Desktop\\\\Selenium\\Drivers\\chromedriver.exe");
	public WebDriver driver;
	
	
	 // Taking a screenshot method

    public void screenShot(String filename) throws IOException, InterruptedException
    
    {

        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\ppias\\OneDrive\\Desktop\\Screenshots\\CPractice\\" + filename+".png");
        FileUtils.copyFile(scr, dest);

    }
	
    
    @BeforeTest
    
    public void Set()
    
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ppias\\OneDrive\\Desktop\\\\Selenium\\Drivers\\chromedriver.exe");
    	
    	
    }
    
    
    
    @Test
    
    public void Sample() throws InterruptedException, IOException
    
    {
    	driver = new ChromeDriver();
    	driver.get("http://google.com");
    	
    	// browser resize
    	 Dimension d = new Dimension(800,480);
         driver.manage().window().setSize(d);
         
         // browser maximize
         driver.manage().window().maximize();
         
		  Thread.sleep(2000);
		  driver.findElement(By.cssSelector("[title=\"Search\"]")).sendKeys("wikipedia");
		  Thread.sleep(2000);
		  driver.findElement(By.name("btnK")).click();
		  Thread.sleep(2000);

		  System.out.println("1. User uses google to search for wikipedia: See Screenshot 1 - Home page");
		  screenShot("Screenshot 1 Home page");
    	
    }
	
    
    
    
    
}


 

	


