package com.alexstark.pages;

import com.alexstark.pages.components.CalendarComponent;
import com.alexstark.pages.components.CityComponent;
import com.alexstark.pages.components.StateComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticFormPage {

    private final String FORM_TITLE = "Student Registration Form";
    public CalendarComponent calendar = new CalendarComponent();
    public StateComponent stateForm = new StateComponent();
    public CityComponent cityForm = new CityComponent();

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            mobileInput = $("#userNumber"),
            subjectsInput = $("#subjectsWrapper").$("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            submitButton = $("#submit"),
            uploadPicture =  $("#uploadPicture");

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public PracticFormPage typeFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public PracticFormPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticFormPage typeEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticFormPage typeGender(String gender) {
        genderRadio.$(byText(gender)).click();
        return this;
    }

    public PracticFormPage typeMobile(String mobile) {
        mobileInput.setValue(mobile);
        return this;
    }

    public PracticFormPage typeCalendar(String day, String month, String year) {
        calendar.setDate(day,month,year);
        return this;
    }

    public PracticFormPage typeSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public PracticFormPage typeHobbies(String [] hobbies) {
        for (var hobby : hobbies) {
            hobbiesCheckBox.$(byText(hobby)).click();
        }
        return this;
    }

    public PracticFormPage typePicture(String nameOfPicture) {
        uploadPicture.uploadFromClasspath("image/" + nameOfPicture);
        return this;
    }

    public PracticFormPage typeAddress(String address) {
        addressInput.setValue(address).scrollTo().click();
        return this;
    }

    public PracticFormPage typeState(String state) {
        stateForm.setState(state);
        return this;
    }

    public PracticFormPage typeCity(String city) {
        cityForm.setCity(city);
        return this;
    }

    public void typeSubmit() {
        submitButton.click();
    }

    public void checkResultHeader(String modalTitle) {
        $("#example-modal-sizes-title-lg").shouldHave(text(modalTitle));
    }

    public PracticFormPage checkResultBody(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
