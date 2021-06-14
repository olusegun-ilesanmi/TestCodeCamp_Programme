package FacebookTasks;

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
        // add the chromedriver on which the test will run
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver() ; // launch the chromedriver.exe file
        driver.get ("https://web.facebook.com/login?_rdc=1&_rdr"); //Input the website URL
        Thread.sleep (5000); // wait for the page to load
        driver.manage().window().fullscreen(); //maximize the browser
        System.out.println(driver.getTitle()); //get the page title
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTests () throws InterruptedException {
        //click on the username field and input a valid username "samsfoodng"
        driver.findElement(By.id("email")).sendKeys("samsfoodng");
        //click on the password field and input a valid password "alliswell17"
        driver.findElement(By.id("pass")).sendKeys("alliswell17");
        //Click on login button
        driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
        Thread.sleep(5000);
        //Check if user logged in
        if(driver.getCurrentUrl().contains("https://web.facebook.com/?sk=welcome")) {
            System.out.println("PASSED - User has successfully Logged in");
        }else {
            System.out.println("FAILED - User was unable to Login");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown () {
        driver.quit(); //Quit the browser
    }

}

