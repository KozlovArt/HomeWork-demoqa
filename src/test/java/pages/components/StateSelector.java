package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateSelector {
    public void setState(String state){
        $("#state").click();
        $("#state").$(byText(state)).click();
    }

}
