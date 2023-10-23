package tests;

import pages.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    void testUserLoginWithoutUserName() {
        loginPage.openPage()
                 .setUserName("")
                 .setPassword("222")
                 .login()
                 .checkEmptyUserName();
    }
    @Test
    void testUserLoginWithoutPassword() {
        loginPage.openPage()
                .setUserName("Вася")
                .setPassword("")
                .login()
                .checkEmptyPassword();
    }
    @Test
    void testUserLogin() {
        loginPage.openPage()
                .setUserName("Test")
                .setPassword("Test(111)^")
                .login()
                .checkSuccessfulLogin();
    }
}
