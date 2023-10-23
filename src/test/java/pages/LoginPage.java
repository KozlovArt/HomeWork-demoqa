package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage {
                           //Elements
    SelenideElement userName = $("#userName"),
                    password = $("#password"),
                    loginButton = $("#login");

                           //Actions
    public LoginPage openPage() {
        open("https://demoqa.com/login");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public LoginPage setUserName(String name) {
        userName.setValue(name);
        return this;
    }
    public LoginPage setPassword(String userPassword) {
        password.setValue(userPassword);
        return this;
    }
    public LoginPage login() {
        loginButton.click();
        return this;
    }
    public LoginPage checkEmptyUserName() {
        userName.shouldHave(cssClass("is-invalid"));
        return this;
    }
    public LoginPage checkEmptyPassword() {
        password.shouldHave(cssClass("is-invalid"));
        return this;
    }
    public LoginPage checkSuccessfulLogin() {
        $(byText("Log out")).should(exist);
        return this;
    }
}
