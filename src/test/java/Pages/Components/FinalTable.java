package Pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FinalTable {

    SelenideElement table = $(".table-responsive");
    public void checkFullResult(String studentName, String studentEmail, String gender,
                            String mobile, String dateOfBirth, String subjects,
                            String hobbies, String picture, String address,
                            String stateAndCity){
        table.$(byText("Student Name")).parent().shouldHave(text(studentName));
        table.$(byText("Student Email")).parent().shouldHave(text(studentEmail));
        table.$(byText("Gender")).parent().shouldHave(text(gender));
        table.$(byText("Mobile")).parent().shouldHave(text(mobile));
        table.$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        table.$(byText("Subjects")).parent().shouldHave(text(subjects));
        table.$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        table.$(byText("Picture")).parent().shouldHave(text(picture));
        table.$(byText("Address")).parent().shouldHave(text(address));
        table.$(byText("State and City")).parent().shouldHave(text(stateAndCity));
    }
    public void checkShortResult(String studentName, String gender,
                                String mobile) {
        table.$(byText("Student Name")).parent().shouldHave(text(studentName));
        table.$(byText("Gender")).parent().shouldHave(text(gender));
        table.$(byText("Mobile")).parent().shouldHave(text(mobile));
    }
}
