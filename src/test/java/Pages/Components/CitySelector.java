package Pages.Components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CitySelector {
    public void setCity(String city){
        $("#react-select-4-input").setValue(city);
        $(".css-11unzgr").$(byText(city)).click();
    }
}
