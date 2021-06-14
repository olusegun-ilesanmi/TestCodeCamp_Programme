package DeydamTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    //Import Selenium Webdriver
    private WebDriver driver;

    @BeforeClass  // functions before test commence
        public void setUp() throws InterruptedException {  //class
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe"); // add the chromedriver on which the test will run
        driver = new ChromeDriver() ; // launch the chromedriver.exe file
        driver.get ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login"); //Input the website URL
        Thread.sleep (5000); // wait for the page to load
        driver.manage().window().fullscreen(); //maximize the browser
        System.out.println(driver.getTitle()); //get the page title
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
         public void loginTests () throws InterruptedException {
        //click on the username field and input a valid username "samshegz"
        driver.findElement(By.id("username")).sendKeys("samshegz");
        //click on the password field and input a valid password "Alliswell17@"
        driver.findElement(By.id("password")).sendKeys("Alliswell17@");
        //Click on login button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        //Check if user logged in
        if(driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")) {
            System.out.println("PASSED - User has successfully Logged in");
        }else {
            System.out.println("FAILED - User was unable to Login");
        }
        Thread.sleep(5000);
    }

    @Test
         public void logoutTests () throws InterruptedException {
        // Click on the user profile
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Log Out")).click(); // Click on Logout button
        //Check if User Logged out
        if(driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")) {
            System.out.println("PASSED - User has successfully Logged out");
        }else {
            System.out.println("FAILED - User is still logged n");
        }
        Thread.sleep(5000);
    }

    @AfterTest
              public void tearDown () {
              driver.quit(); //Quit the browser
    }

}
