package setup;

import PageObject.DashboardPage;
import PageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetupsTests {

    // Create a Webdriver object
    private WebDriver driver;

    // Create a Login page Object
    protected LoginPage loginPage;
    // Create a Dashboard page Object
    protected DashboardPage dashboardPage;

    @BeforeTest //TestNG annotation
    public void setUp() {
        // Set chromeBrowser
        System.setProperty("webdriver.chrome.driver" , "resources/chromedriver.exe");
        driver = new ChromeDriver();
        // maximize window
        driver.manage().window().maximize();
        //Open the page URL
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        //Instantiate login page after launching the browser
        loginPage = new LoginPage (driver);
    }

    @AfterTest

    public void closeBrowser() {
        // Exit the browser
        driver.quit();
    }


}
