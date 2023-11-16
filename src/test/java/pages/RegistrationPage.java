package pages;

import com.codeborne.selenide.Configuration;
import pages.components.*;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    ///// SelenideElements
    Calendar calendar = new Calendar();
    SubjectSelector subjectSelector = new SubjectSelector();
    StateSelector stateSelector = new StateSelector();
    CitySelector citySelector = new CitySelector();
    FinalTable finalTable = new FinalTable();
    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    genderWrapper = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    userHobbies = $("#hobbiesWrapper"),
                    userPicture = $("#uploadPicture"),
                    userAddress = $("#currentAddress"),
                    submitButton = $("#submit");



    ///// Actions
    public RegistrationPage openPage() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubject(String subject) {
        subjectSelector.setSubject(subject);
        return this;
    }
    public RegistrationPage setHobbies(String hobbies) {
        userHobbies.$(byText(hobbies)).click();
        return this;
    }
    public RegistrationPage setPicture(String pictureName) {
        if (!Configuration.browser.equalsIgnoreCase("firefox")){
        userPicture.uploadFromClasspath(pictureName);
        }
        return this;
    }
    public RegistrationPage setAddress(String address) {
        userAddress.setValue(address);
        return this;
    }
    public RegistrationPage setState(String state) {
        stateSelector.setState(state);
        return this;
    }
    public RegistrationPage setCity(String city) {
        citySelector.setCity(city);
        return this;
    }
    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }
    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

}