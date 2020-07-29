package CSP_Login;


import org.testng.annotations.Test;

import org.testng.annotations.*;

import org.testng.annotations.BeforeTest;

import org.testng.Assert;

import org.openqa.selenium.*;

import org.openqa.selenium.ie.*;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.event.KeyEvent;

import java.io.IOException;

import org.openqa.selenium.WebElement;

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

//import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.Iterator;



import java.io.*;

import java.util.*;


public class CSP_Login



{

               // Written for Internet Explorer

                // For each integration, change baseUrl and Partner

               

                public String baseUrl = "https://sqa.eauth.va.gov/accessva/?cspSelectFor=vic";

                public String driverPath = "C:\\Users\\VHAISPPIASEP\\Desktop\\Selenium\\IEDriverServer.exe";

                public WebDriver driver;

                public String Partner = "VIC";

                

                // Taking a screenshot method

                public void screenShot(String filename) throws IOException, InterruptedException

               

                {

                    File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

                    File dest = new File("C:\\Users\\VHAISPPIASEP\\Desktop\\AcS_Screenshots\\CSP_Login\\" + filename+".png");

                    FileUtils.copyFile(scr, dest);

                }

               



  @BeforeTest

  public void Login() throws IOException, InterruptedException

  

  {

                  System.setProperty("webdriver.ie.driver", "C:\\Users\\VHAISPPIASEP\\Desktop\\Selenium\\IEDriverServer.exe");

                  driver = new InternetExplorerDriver();

                  driver.get(baseUrl);

  }

 

  @Test(priority = 0)

  public void AccessVAHomePage() throws IOException, InterruptedException

  {

                  System.out.println("Beginning test at AccessVA for "+Partner);

                  System.out.println();

                  screenShot("1_AccessVAHomePage");

                 

  }

 
  @Test (priority = 1)

  public void RegisterForPartnerAndLearnMore() throws InterruptedException, IOException

  {

                 

                  // User clicks on Register for a Sign-in Partner

                  driver.findElement(By.id("registrationWizardModalDialogLink")).click();

                  System.out.println("1. User clicks 'Register for a Sign-In Partner' : See screenshot 1");

                  screenShot("1_RegisterForSignInPartner");
                  
                  
                 // User selects back button

                 

                  driver.switchTo().frame("lightweightModalIframe");

                  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();

                 

                  System.out.println("2. User clicks back button at 'sign in partner' page. See screenshot 2_back button 1");

                  driver.switchTo().defaultContent();

                 

                  // User selects the Register for a sign in partner link followed by Next button

                  System.out.println("3. User selects the Register for a sign in partner link followed by Next button" );

                  driver.findElement(By.id("registrationWizardModalDialogLink")).click();

                  driver.switchTo().frame("lightweightModalIframe");

                  driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                  screenShot("3_Register For SignIn Partner page 2");

                  System.out.println("4. User arrives at page two of Sign In Partner  See screenshot 3_Register For SignIn Partner page 2");

                 

                  // User clicks back button

                  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();

                  screenShot("5_Back button 2");

                  System.out.println("5. User clicks back button at 'sign in partner' page 2. See screenshot 5_back button 2");

                 

                  // User clicks next twice to get to Partner options page

                  System.out.println("6. User clicks 'next' twice to get to Partner options page. See screenshot 6_Partner Options Page");

                  driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                  driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                  screenShot("6_Partner Options Page");

                 

                  // User selects "need help selecting" option

                  System.out.println("7. User clicks on 'Need help selecting?' and arrives at Learn More page. See screenshot 7_Learn More Page");

                  driver.findElement(By.xpath("//a[@href='/accessva/widget_learn_more?appId=vic&mainpages']")).click();

                  screenShot("7_Learn More Page");

                  driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();



                 

                  // User back up to Partner options page and clicks Cancel button

                  System.out.println("8. User clicks Back --> Cancel button and returns to AccessVA home screen: See screenshot 8_Back To AccessVA Home Page");

                  System.out.println();

                  driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();

                  screenShot("8_Back To AccessVA Home Page");

                  driver.switchTo().defaultContent();

                 

 }

 



 

  @Test (priority = 2)

  public void DSLogon() throws InterruptedException, IOException

  {

 

                List<WebElement> DSlogon = driver.findElements(By.id("btn_ds_logon"));

                if (DSlogon.size() != 0)

                 

                {





                                System.out.println("DS Logon has been found as an integration with "+Partner);

                                System.out.println();

                               

                                System.out.println("1. User clicks 'Learn More and selects DS Logon option' See Screenshot DS Logon_0");

                                driver.findElement(By.id("learnMoreModalDialogLink")).click();                                                                                

                                driver.findElement(By.xpath("//a[@title='Learn more about DS Logon']")).click();

                                screenShot("DS Logon_0 DS Logon Learn More info");

                                driver.findElement(By.id("DS_Logon_cancel")).click();

                                driver.findElement(By.id("learn_more_back_button")).click();

                               

                                System.out.println("2. User clicks the 'back' button twice and arrives back at Access VA Home page ");

                                driver.findElement(By.id("btn_ds_logon")).click();

                                System.out.println("3. User clicks 'Sign in with DS Logon' and is redirected 'Secure Login Redirect' popup page: See screenshot DS Logon_1");

                                screenShot("DS Logon_1 Checking Secure Login Redirect");

                               

                                System.out.println("4. User clicks 'terms of VA System use' see screenshot DS Logon_2 ");

                                driver.findElement(By.id("show_terms_of_use")).click();

                                screenShot("DS Logon_2 VA System Terms of Use");

                                driver.findElement(By.id("about-modal-cancel_button")).click();

                               

                                System.out.println("5. User clicks back, then Cancel, and is redirected back to AccessVA Home page: See Screenshot DS Logon_3");

                                driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();

                                screenShot("DS Logon_3 Redirection back to AccessVA Home page");                     

                               

                                System.out.println("6. User clicks 'Sign in with DS Logon' again then clicks 'Accept'");

                                driver.findElement(By.id("btn_ds_logon")).click();

                                //driver.switchTo().frame("lightweightModalIframe");

                                driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();

                                System.out.println("7. User arrives at DS Logon home page: See Screenshot DS Logon_4" );

                                screenShot("DS Logon_4 User arrives at DS Logon Home page");

                               

                                driver.get(baseUrl);

                               

                               

                                System.out.println("8. User clicks on Register for a Sign-In Partner --> Next--> Next --> and Arrives at Partner Selection: See screenshot DS Logon_4");

                               

                                driver.findElement(By.id("registrationWizardModalDialogLink")).click();

                                driver.switchTo().frame("lightweightModalIframe");

                                driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                                driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                                screenShot("DS Logon_4 User arrives at Partner selection page");

                               

                                System.out.println("9. User selects Register for DS Logon option and Arrives at Secure Login Redirect Page: See screenshot DS Logon_5");

                                driver.findElement(By.xpath("//button[starts-with(@title,'Register for DS Logon')]")).click();

                                screenShot("DS Logon_5 User arrives at Secure Redirect page");

                               

                                System.out.println("10. User clicks accept and arrives at DS Logon Home Page: See screenshot DS Logon_6");

                                driver.findElement(By.id("next_button")).click();

                                screenShot("DS Logon_6 User arrives back at DS Logon Home page");

                                System.out.println("");

                                driver.get(baseUrl);

                               

                }

 

                else

                {

                                System.out.println("DS Logon is not implemented in this integration");

                                System.out.println();

                               

                }

  }

 
  @Test (priority = 3)

  public void CaCCard() throws IOException, InterruptedException, AWTException

  {

 

                  List<WebElement> CAC = driver.findElements(By.id("btn_cac"));

                                if (CAC.size() != 0)

                                 

                                {

                                               

                                System.out.println("DoD CAC Card has been found as an integration with "+Partner);

                                System.out.println();

                                               

                                System.out.println("1. User clicks 'Learn More and selects DoD CAC Card option' See Screenshot DoD CAC Card_0");

                                driver.findElement(By.id("learnMoreModalDialogLink")).click();                                                                                

                                driver.findElement(By.xpath("//a[@title='Learn more about DoD CAC Card']")).click();

                                screenShot("DoD CAC Card_0 DoD CAC Card Learn More info");

                                driver.findElement(By.id("DoD_CAC_Card_cancel")).click();

                                driver.findElement(By.id("learn_more_back_button")).click();

                               

                               

                                driver.findElement(By.id("btn_cac")).click();

                                System.out.println("2. User clicks 'Sign in with DoD CAC Card' and is redirected 'Secure Login Redirect' popup page: See screenshot DoD CAC Card_1");

                                screenShot("DoD CAC Card_1 Checking Secure Login Redirect");

                               

                                try

                                  {

                                 

                                                  Robot robot = new Robot(); 

                                                  

                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                  Thread.sleep(500);

                                                                                                                  

                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                  Thread.sleep(500);

                                                 

                                                  System.out.println("3. User clicks 'terms of VA System use' see screenshot DoD CAC Card_2 ");

                                                  screenShot("DoD CAC Card_2 VA System Terms of Use");

                                                 

                                                  System.out.println("4. User clicks back, then Cancel, and is redirected back to AccessVA Home page: See Screenshot DoD CAC Card_3");

                                                 

                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                  Thread.sleep(500);

                                                 

                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                  Thread.sleep(500);

                                                 

                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                  Thread.sleep(500);

                                                 

                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                  Thread.sleep(500);

                                                 

                                                  

                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                  Thread.sleep(500);

                                                 

                                  }

                               

                                finally

                                  {

                                                  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                                  }

                               

                                screenShot("DoD CAC Card_3 Redirection back to AccessVA Home page");           

                                System.out.println("");

                               

                                               

                                }

                 

                                else

                                {

                                                System.out.println("DoD CAC Card is not implemented in this integration");

                                                System.out.println();

                                               

                                }

 

  }

 
  @Test (priority = 4)

  public void PivCard() throws IOException, InterruptedException, AWTException

  {

 

                  List<WebElement> PIV = driver.findElements(By.id("btn_piv"));

                                if (PIV.size() != 0)

                                 

                                {

                                                System.out.println("VA PIV Card has been found as an integration with "+Partner);

                                                System.out.println();

                                               

                                                System.out.println("1. User clicks 'Learn More and selects PIV Card option' See Screenshot PIV Card_0");

                                                driver.findElement(By.id("learnMoreModalDialogLink")).click();                                                                                

                                                driver.findElement(By.xpath("//a[@title='Learn more about VA PIV Card']")).click();

                                                screenShot("PIV Card_0 DS Logon Learn More info");

                                                driver.findElement(By.id("VA_PIV_Card_cancel")).click();

                                                driver.findElement(By.id("learn_more_back_button")).click();

                                               

                                               

                                                driver.findElement(By.id("btn_piv")).click();

                                                System.out.println("2. User clicks 'Sign in with VA PIV Card' and is redirected 'Secure Login Redirect' popup page: See screenshot PIV Card_1");

                                                screenShot("PIV Card_1 Checking Secure Login Redirect");

                                               

                                                try

                                                  {

                                                 

                                                                  Robot robot = new Robot(); 

                                                                  

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                                                                                  

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                                  System.out.println("3. User clicks 'terms of VA System use' see screenshot PIV Card_2 ");

                                                                  screenShot("PIV Card_2 VA System Terms of Use");

                                                                 

                                                                  System.out.println("4. User clicks back, then Cancel, and is redirected back to AccessVA Home page: See Screenshot PIV Card_3");

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                  }

                                               

                                                finally

                                                  {

                                                                  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                                                  }

                                               

                                               

                                                screenShot("PIV Card_3 Redirection back to AccessVA Home page");                      

                                                                                               

                                                System.out.println("5. User clicks 'Sign in with My HealtheVet' again then clicks 'Accept: See screenshot PIV Card_4'");

                                                driver.findElement(By.id("btn_piv")).click();

                                               

                                                driver.findElement(By.id("piv_next_button")).click();

                                               

                                                try

                                                  {

                                                 

                                                                  Robot robot = new Robot(); 

                                                                  Thread.sleep(2000);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                 

                                                                  

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                 

                                                                  Thread.sleep(3000);

                                                                 

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);



                                                                 

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(10000);

                                                                 

                                                                  screenShot("PIV Card_4 User arrives at ChooseVA Home page");

                                                                  driver.get(baseUrl);

                                                                  System.out.println("");

                                                                 

                                                  }

                                                 

                                                  finally

                                                  {

                                                                  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                                                  }

                                               

                                }

                 

                                else

                                {

                                                System.out.println("VA PIV Card is not implemented in this integration");

                                                System.out.println();

                                }

  }

 

  @Test (priority = 5)

  public void IDme() throws IOException, InterruptedException, AWTException

  {

 

                  List<WebElement> IDme = driver.findElements(By.id("btn_idme3"));

                                if (IDme.size() != 0)

                                 

                                {

                                                System.out.println("ID.me has been found as an integration with "+Partner);

                                                System.out.println();

                                               

                                                // learn more about ID.me

                                                System.out.println("1. User clicks 'Learn More and selects ID.me option' See Screenshot IDme_0");

                                                driver.findElement(By.id("learnMoreModalDialogLink")).click();                                                                                

                                                driver.findElement(By.xpath("//a[@title='Learn more about ID.me']")).click();

                                                screenShot("IDme_0 IDme Learn More info");

                                                System.out.println("2. User clicks the 'back' button twice and arrives back at Access VA Home page ");

                                                driver.findElement(By.id("ID.me_cancel")).click();

                                                driver.findElement(By.id("learn_more_back_button")).click();

                                               

                                                driver.findElement(By.id("btn_idme3")).click();

                                                System.out.println("3. User clicks 'Sign in with ID.me' and is redirected 'Secure Login Redirect' popup page: See screenshot IDme_1");

                                                screenShot("IDme_1 Checking Secure Login Redirect");

                                               

                                                // Using Tab to check terms of VA System use

                                                try

                                                  {

                                                 

                                                                  Robot robot = new Robot(); 

                                                                  

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                                                                                  

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                                  System.out.println("4. User clicks 'terms of VA System use' see screenshot IDme_2 ");

                                                                  screenShot("IDme_2 VA System Terms of Use");

                                                                 

                                                                  System.out.println("5. User clicks back, then Cancel, and is redirected back to AccessVA Home page: See Screenshot IDme_3");

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                  screenShot("IDme_3 Redirection back to AccessVA Home page");          

                                                                 

                                                  }

                                               

                                                finally

                                                  {

                                                                  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                                                  }

                               

                                               

                                                System.out.println("6. User clicks 'Sign in with ID.me' again then clicks 'Accept'");

                                                driver.findElement(By.id("btn_idme3")).click();

                                               

                                                // Tab over to accept button

                                                try

                                                  {

                                                 

                                                                  Robot robot = new Robot(); 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(1000);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                  }

                                               

                                                finally

                                                  {

                                                                  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                                                  }

                               
                                                System.out.println("7. User arrives at ID.me home page: See Screenshot IDme_4" );

                                                driver.get(baseUrl);

                                                System.out.println("8. User clicks on Register for a Sign-In Partner --> Next--> Next --> and Arrives at Partner Selection: See screenshot IDme_5");

                                                driver.findElement(By.id("registrationWizardModalDialogLink")).click();

                                                driver.switchTo().frame("lightweightModalIframe");

                                                driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                                                driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                                                screenShot("IDme_5 User arrives at Partner selection page");

                                               

                                                System.out.println("9. User selects Register for ID.me option and Arrives at Secure Login Redirect Page: See screenshot IDme_6");

                                                driver.findElement(By.xpath("//button[contains(@title,'ID.me')]")).click();

                                                screenShot("IDme_6 User arrives at Secure Redirect page");

                                                System.out.println("10. User clicks accept and arrives at ID.me Home Page: See screenshot IDme_7");

                                                driver.findElement(By.id("next_button")).click();

                                                System.out.println("");

                                               

                                                driver.get(baseUrl);

                                               

                                }

                 

                                else

                                {

                                                System.out.println("ID.me is not implemented in this integration");

                                                System.out.println();

                                               

                                }

 

  }


  @Test (priority = 6)

  public void Logingov() throws IOException, InterruptedException, AWTException

  {

 

                  List<WebElement> LoginGov = driver.findElements(By.id("btn_logingov3"));

                                if (LoginGov.size() != 0)

                                 

                                {

                                               

                                                System.out.println("Login.gov has been found as an integration with VIC");

                                                System.out.println("");

                                               

                                               

                                                System.out.println("1. User clicks 'Learn More and selects Login.gov option' See Screenshot Logingov_0");

                                                driver.findElement(By.id("learnMoreModalDialogLink")).click();                                                                                

                                                driver.findElement(By.xpath("//a[@title='Learn more about LOGIN.GOV']")).click();

                                                screenShot("Logingov_0 Logingov Learn More info");

                                                System.out.println("2. User clicks the 'back' button twice and arrives back at Access VA Home page ");

                                                driver.findElement(By.id("LOGIN.GOV_cancel")).click();

                                                driver.findElement(By.id("learn_more_back_button")).click();

                                               

                                               

                                                driver.findElement(By.id("btn_logingov3")).click();

                                                System.out.println("3. User clicks 'Sign in with Login.gov' and is redirected 'Secure Login Redirect' popup page: See screenshot LoginGov_1");

                                                screenShot("LoginGov_1 Checking Secure Login Redirect");

                                               

                                                // Using Tab to check terms of VA System use

                                                                                                try

                                                                                                  {

                                                                                                               

                                                                                                               

                                                                                                                  Robot robot = new Robot(); 

                                                                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                                                                  Thread.sleep(500);

                                                                                                                                                                                  

                                                                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                                                                  Thread.sleep(500);

                                                                                                                 

                                                                                                                  System.out.println("4. User clicks 'terms of VA System use' see screenshot Logingov_2 ");

                                                                                                                  screenShot("Logingov_2 VA System Terms of Use");

                                                                                                                 

                                                                                                                  System.out.println("5. User clicks back, then Cancel, and is redirected back to AccessVA Home page: See Screenshot Logingov_3");

                                                                                                                 

                                                                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                                                                  Thread.sleep(500);

                                                                                                                 

                                                                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                                                                  Thread.sleep(500);

                                                                                                                 

                                                                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                                                                  Thread.sleep(500);

                                                                                                                                                                                                                 

                                                                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                                                                  Thread.sleep(500);

                                                                                                                 

                                                                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                                                                  Thread.sleep(500);

                                                                                                                 

                                                                                                                  screenShot("LoginGov_3 Redirection back to AccessVA Home page");

                                                                                                                 

                                                                                                  }

                                                                                               

                                                                                                finally

                                                                                                  {

                                                                                                                  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                                                                                                  }

                                                                               

                                                                                               

                                                                                                System.out.println("6. User click 'Sign in with Login.gov' again then clicks 'Accept'");

                                                                                                driver.findElement(By.id("btn_logingov3")).click();

                                                                                               

                                                                                                // Tab over to accept button

                                                                                                try

                                                                                                  {

                                                                                                 

                                                                                                                  Robot robot = new Robot(); 

                                                                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                                                                  Thread.sleep(500);

                                                                                                                 

                                                                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                                                                  Thread.sleep(500);

                                                                                                                 

                                                                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                                                                  Thread.sleep(1000);

                                                                                                                 

                                                                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                                                                  Thread.sleep(500);

                                                                                                                 

                                                                                                  }

                                                                                               

                                                                                                finally

                                                                                                  {

                                                                                                                  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                                                                                                  }

                                               

                                               

                                                System.out.println("7. User arrives at Login.gov home page: See Screenshot LoginGov_4" );

                                               

                                                driver.get(baseUrl);

                                               

                                                System.out.println("8. User clicks on Register for a Sign-In Partner --> Next--> Next --> and Arrives at Partner Selection: See screenshot LoginGov_5");

                                               

                                                driver.findElement(By.id("registrationWizardModalDialogLink")).click();

                                                driver.switchTo().frame("lightweightModalIframe");

                                                driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                                                driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                                                screenShot("LoginGov_5 User arrives at Partner selection page");

                                               

                                                System.out.println("9. User selects Register for Login.gov option and Arrives at Secure Login Redirect Page: See screenshot LoginGov_6");

                                                driver.findElement(By.xpath("//button[starts-with(@title,'Register for LOGIN.GOV')]")).click();

                                                screenShot("LoginGov_6 User arrives at Secure Redirect page");

                                               

                                                System.out.println("10. User clicks accept and arrives at Login.gov Home Page: See screenshot LoginGov_7");

                                                driver.findElement(By.id("next_button")).click();

                                                driver.get(baseUrl);

                                                System.out.println("");

                                }

                 

                                else

                                {

                                                System.out.println("Login.gov is not implemented in this integration");

                                                System.out.println();

                                               

                                }

 

  }

 

 

  

  @Test (priority = 7)

  public void MyHealthyVet() throws IOException, InterruptedException, AWTException

  {



                  List<WebElement> MyHealtheVet = driver.findElements(By.id("btn_mhvcsp2"));

                                if (MyHealtheVet.size() != 0)

                                 

                                {

                                                System.out.println("My HealtheVet has been found as an integration with "+Partner);

                                                System.out.println();

                                               

                                                System.out.println("1. User clicks 'Learn More and selects My HealtheVet option' See Screenshot MyHealtheVet_0");

                                                driver.findElement(By.id("learnMoreModalDialogLink")).click();                                                                                

                                                driver.findElement(By.xpath("//a[@title='Learn more about My HealtheVet']")).click();

                                                screenShot("MyHealtheVet_0 My HealtheVet Learn More info");

                                                driver.findElement(By.id("My_HealtheVet_cancel")).click();

                                                driver.findElement(By.id("learn_more_back_button")).click();

                                                System.out.println("2. User clicks the 'back' button twice and arrives back at Access VA Home page ");

                                               

                                                driver.findElement(By.id("btn_mhvcsp2")).click();

                                                System.out.println("3. User clicks 'Sign in with My HealtheVet' and is redirected 'Secure Login Redirect' popup page: See screenshot MyHealtheVet_1");

                                                screenShot("MyHealtheVet_1 Checking Secure Login Redirect");

                                               

                                               

                                                try

                                                  {

                                                 

                                                                  Robot robot = new Robot(); 

                                                                  

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                                                                                  

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                                  System.out.println("4. User clicks 'terms of VA System use' see screenshot MyHealtheVet_2 ");

                                                                  screenShot("MyHealtheVet_2 VA System Terms of Use");

                                                                 

                                                                  System.out.println("5. User clicks back, then Cancel, and is redirected back to AccessVA Home page: See Screenshot MyHealtheVet_3");

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_TAB); 

                                                                  robot.keyRelease(KeyEvent.VK_TAB);

                                                                  Thread.sleep(500);

                                                                 

                                                                  robot.keyPress(KeyEvent.VK_ENTER); 

                                                                  robot.keyRelease(KeyEvent.VK_ENTER);

                                                                  Thread.sleep(500);

                                                                 

                                                  }

                                               

                                                finally

                                                  {

                                                                  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                                                  }

                                               



                                                driver.findElement(By.id("mhvcsp2_cancel_button")).click();

                                                screenShot("MyHealtheVet_3 Redirection back to AccessVA Home page");                          

                                               

                                                System.out.println("6. User clicks 'Sign in with My HealtheVet' again then clicks 'Accept'");

                                                driver.findElement(By.id("btn_mhvcsp2")).click();

                                                //driver.switchTo().frame("lightweightModalIframe");

                                                driver.findElement(By.id("mhvcsp2_next_button")).click();

                                                Thread.sleep(1000);

                                                System.out.println("7. User arrives at My HealtheVet home page: See Screenshot MyHealtheVet_4" );

                                               

                                                driver.findElement(By.id("signInButton"));

                                                screenShot("MyHealtheVet_4 User arrives at My HealtheVet Home page");

                                               

                                                driver.get(baseUrl);

                                               

                                                System.out.println("8. User clicks on Register for a Sign-In Partner --> Next--> Nex --> and Arrives at Partner Selection: See screenshot MyHealtheVet_5");

                                               

                                                driver.findElement(By.id("registrationWizardModalDialogLink")).click();

                                                driver.switchTo().frame("lightweightModalIframe");

                                                driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                                                driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

                                                screenShot("MyHealtheVet_5 User arrives at Partner selection page");

                                               

                                                System.out.println("9. User selects Register for My HealtheVet option and Arrives at Secure Login Redirect Page: See screenshot MyHealtheVet_6");

                                                driver.findElement(By.xpath("//button[starts-with(@title,'Register for My HealtheVet')]")).click();

                                                screenShot("MyHealtheVet_6 User arrives at Login Redirect page");

                                               

                                                System.out.println("10. User clicks accept and arrives at My HealtheVet Home Page: See screenshot MyHealtheVet_7");

                                                driver.findElement(By.id("next_button")).click();

                                                screenShot("MyHealtheVet_7 User arrives back at My HealtheVet Home page");

                                                driver.get(baseUrl);

                                                System.out.println("");

                                               

                                }

                 

                                else

                                {

                                                System.out.println("My HealtheVet is not implemented in this integration");

                                                System.out.println();

                                               

                                }


  }


}
