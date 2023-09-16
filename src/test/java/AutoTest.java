
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1020x800";
    }

    @Test
    void testDemoQA(){
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

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
        $("#uploadPicture").uploadFromClasspath("XPath.jpeg");
        $("#currentAddress").setValue("Адрес");
        $("#react-select-3-input").setValue("N");
        $("#state").$(byText("NCR")).click();
        $("#react-select-4-input").setValue("G");
        $("#city").$(byText("Gurgaon")).click();
        $("#submit").click();

        $(byText("Имя Фамилия")).shouldBe(exist);
        $(byText("test@gmail.com")).shouldBe(exist);
        $(byText("Male")).shouldBe(exist);
        $(byText("8999555667")).shouldBe(exist);
        $(byText("01 April,1904")).shouldBe(exist);
        $(byText("English")).shouldBe(exist);
        $(byText("Sports")).shouldBe(exist);
        $(byText("XPath.jpeg")).shouldBe(exist);
        $(byText("Адрес")).shouldBe(exist);
        $(byText("NCR Gurgaon")).shouldBe(exist);
    }
}
