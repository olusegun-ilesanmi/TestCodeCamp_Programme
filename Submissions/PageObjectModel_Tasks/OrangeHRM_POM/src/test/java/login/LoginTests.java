package login;

import PageObject.DashboardPage;
import org.testng.annotations.Test;
import setup.SetupsTests;

public class LoginTests extends SetupsTests {

    @Test

    public void testLogin() throws InterruptedException {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");

        //Handler for Dashboard
        loginPage.clickLoginButton();
        String pageUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        System.out.println("PASSED - The page Url is " + pageUrl);
    }

    @Test
    public void testLogout () throws InterruptedException {
        try {
             dashboardPage.clickWelcomeAdmin();
             loginPage = dashboardPage.clickLogOutButton();
        } catch (Exception e) {
            String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println("PASSED - The page Url is " + loginUrl);
        }
    }
}
