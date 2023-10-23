package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CitySelector {
    public void setCity(String city){
        $("#city").click();
        $("#city").$(byText(city)).click();
    }
}
