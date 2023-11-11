
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AutoTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browser = System.getProperty("Browser", "firefox");
        Configuration.browserVersion = System.getProperty("BrowserVersion", "98.0");
        Configuration.baseUrl = System.getProperty("Stand", "https://demoqa.com");
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize= System.getProperty("Resolution", "1920x1080");
        Configuration.remote = System.getProperty("Host", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (!Configuration.browser.equalsIgnoreCase("firefox")){
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        closeWebDriver();
    }

    @Test
    @Tag("main")
    void testDemoQA(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        step("Open form", () -> {
                    open("/automation-practice-form");
                    executeJavaScript("$('#fixedban').remove()");
                    executeJavaScript("$('footer').remove()");
                });
        step("Fill form", () -> {
                    $("#firstName").setValue("Имя");
                    $("#lastName").setValue("Фамилия");
                    $("#userEmail").setValue("test@gmail.com");
                    $("#genterWrapper").$(byText("Male")).click();
                    $("#userNumber").setValue("8999555667");
                    $("#dateOfBirthInput").click();
                    $(".react-datepicker__month-select").selectOption("April");
                    $(".react-datepicker__year-select").selectOption("1904");
                    $(".react-datepicker__day--001").click();
                    $("#subjectsInput").setValue("Eng");
                    $("#subjectsWrapper").$(byText("English")).click();
                    $("#hobbiesWrapper").$(byText("Sports")).click();
                    if (!Configuration.browser.equalsIgnoreCase("firefox")){
                        $("#uploadPicture").uploadFromClasspath("XPath.jpeg");
                    }
                    $("#currentAddress").setValue("Адрес");
                    $("#react-select-3-input").setValue("N");
                    $("#state").$(byText("NCR")).click();
                    $("#react-select-4-input").setValue("G");
                    $("#city").$(byText("Gurgaon")).click();
                    $("#submit").click();
                });

        step("Verify results", () -> {
            $(byText("Имя Фамилия")).shouldBe(exist);
            $(byText("test@gmail.com")).shouldBe(exist);
            $(byText("Male")).shouldBe(exist);
            $(byText("8999555667")).shouldBe(exist);
            $(byText("01 April,1904")).shouldBe(exist);
            $(byText("English")).shouldBe(exist);
            $(byText("Sports")).shouldBe(exist);
            if (!Configuration.browser.equalsIgnoreCase("firefox")){
                $(byText("XPath.jpeg")).shouldBe(exist);
            }
            $(byText("Адрес")).shouldBe(exist);
            $(byText("NCR Gurgaon")).shouldBe(exist);
        });
    }
}
