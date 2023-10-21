package Pages.Components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateSelector {
    public void setState(String state){
        $("#react-select-3-input").setValue(state);
        $(".css-11unzgr").$(byText(state)).click();
    }

}
