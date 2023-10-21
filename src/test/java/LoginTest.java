import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class LoginTest {

    LoginPage loginPage = new LoginPage();
    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1020x800";
    }
    @Test
    void test1_UserLoginWithoutUserName() {
        loginPage.openPage()
                 .setUserName("")
                 .setPassword("222")
                 .login()
                 .checkEmptyUserName();
    }
    @Test
    void test2_UserLoginWithoutPassword() {
        loginPage.openPage()
                .setUserName("Вася")
                .setPassword("")
                .login()
                .checkEmptyPassword();
    }
    @Test
    void test3_UserLogin() {
        loginPage.openPage()
                .setUserName("Test")
                .setPassword("Test(111)^")
                .login()
                .checkSuccessfulLogin();
    }
}
