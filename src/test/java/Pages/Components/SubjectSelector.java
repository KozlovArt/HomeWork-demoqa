package Pages.Components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubjectSelector {
    public void setSubject(String subject){
        $("#subjectsInput").setValue(subject);
        $(".subjects-auto-complete__menu").$(byText(subject)).click();
    }
}
