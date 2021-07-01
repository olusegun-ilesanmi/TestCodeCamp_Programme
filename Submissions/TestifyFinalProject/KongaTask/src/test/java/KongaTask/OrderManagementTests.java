package KongaTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrderManagementTests {

    private WebDriver driver;

    //Before Test Annotation
    @BeforeTest

    // Create a Setup class
    public void setUp () throws InterruptedException {
        //Launch Chrome browser using chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        // Open the Login URL
        driver.get ("https://www.konga.com/account/login?return_url=/");
        Thread.sleep(5000);
        //Maximize the screen
        driver.manage().window().fullscreen();
        //Get page Title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    //Test Annotation
    @Test

    //Create LoginTest class
    public void loginTest () throws InterruptedException {
        // Click on the username field and enter a valid email address
        driver.findElement(By.id("username")).sendKeys("project.testify123@gmail.com");
        //Click on the username field and enter a valid Password
        driver.findElement(By.id("password")).sendKeys("alliswell17");
        //Click on Login button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[1]/form/div[3]/button")).click();
        Thread.sleep(5000);
        //Check if user successfully logged in
        if (driver.getCurrentUrl().contains("https://www.konga.com/")) {
            System.out.println("PASSED - User has successfully logged in");
        }
        else {
            System.out.println("FAILED - user was unable to login");
        }
        Thread.sleep(5000);
    }
    //Test Annotation
    @Test

    public void productOrderTest() throws InterruptedException {
        //Click on "Computer and Accessories" link
        driver.findElement(By.linkText("Computers and Accessories")).click();
        //Click on Laptops Subcategory
        driver.findElement(By.linkText("Laptops")).click();
        //Click on "Apple and MackBooks"
        driver.findElement(By.linkText("Apple MacBooks")).click();
        System.out.println("Item successfully searched");
        Thread.sleep(5000);
        //Add item to cart
        driver.findElement(By.cssSelector("#mainContent > section._8d917_1ixfS > section > section > section > section > ul > li:nth-child(3) > div > div > div._4941f_1HCZm > form > div._2aac2_3bwnD._549f7_zvZ8u._49c0c_3Cv2D > button")).click();
        System.out.println("Item added to cart");
        //View added Item in cart
        driver.findElement(By.cssSelector("#app-content-wrapper > div.e5dc4_DR8xw > nav > div._2d4bb_2rbWX > div > div > a._79484_1sLEt._7ad32_SD12Y._16536_xxIKG")).click();
        Thread.sleep(5000);
        //Increment the number of item in the cart
        WebElement cartIncrement = driver.findElement(By.cssSelector("#js-cart-items-wrapper > div > div > div.ed23a_3OozF > div.bb31e_ax8ka > form > div > div > button.c4079_DW1vB"));
        for (int i=1; i<2; i++) {
            cartIncrement.click();
            Thread.sleep(5000);
        }
        //Checkout
        driver.findElement(By.cssSelector("#app-content-wrapper > div.c6dfe_HidJc > section > section > aside > div.fb90d_2mSyi > div > div._2aac2_3bwnD._841f1_1RZK9 > button")).click();
        Thread.sleep(5000);
        // Select Delivery Address
        driver.findElement(By.cssSelector("#mainContent > form > div > div > section:nth-child(1) > div.c8825_2KE_b > div > div._654ae_5UVhe > div > div:nth-child(1) > form > div > div > a")).click();
        // Select an Address on the saved address list
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        //Click on "use this Address" button to select delivery address
        driver.findElement(By.linkText("Use this Address")).click();
        System.out.println("Address selected");
        Thread.sleep(5000);
        // Click on Pay now Button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div/section/div/div[4]/form/ul/li[1]/div/button")).click();
        // Continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div/section/div/div[9]/div/button")).click();
        Thread.sleep(5000);
        //Switch to Payment iframe window
        WebElement paymentIframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(paymentIframe);
        //Select "card payment" option
        driver.findElement(By.xpath("//*[@id='channel-template']/div[2]/div[1]/div[2]/button[1]")).click();
        // Enter Invalid Card number
        driver.findElement(By.id("card-number")).sendKeys("5199 1101 1234 5678");
        //Enter Expiry date
        driver.findElement(By.id("expiry")).sendKeys("0122");
        //Enter cvv2
        driver.findElement(By.id("cvv")).sendKeys("123");
        //Click on Pin field
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();
        //Enter 4digit Pin
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[2]")).click(); //Enter Pin "1"
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[10]")).click(); //Enter Pin "2"
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[11]")).click(); //Enter Pin "3"
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[5]")).click(); //Enter Pin "4"
        System.out.println("Card details entered");
        Thread.sleep(5000);
        // Display the "Invalid card number" Error message
        System.out.println("Error Message - " + driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]")).getText());
        Thread.sleep(5000);
        //Close Card payment iframe
        driver.findElement(By.cssSelector("body > section > section > section > div.data-card > div.data-card__header > aside")).click();
    }
    //After test annotation
    @AfterTest

    public void closeBrowser () {
        // Close the browser
        driver.quit();
    }
}


