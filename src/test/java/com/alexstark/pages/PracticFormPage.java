package com.alexstark.pages;

import com.alexstark.pages.components.CalendarComponent;
import com.alexstark.pages.components.CityComponent;
import com.alexstark.pages.components.StateComponent;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
            uploadPicture = $("#uploadPicture");


    @Step("Открыть страницу demoqa.com/automation-practice-form")
    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    @Step("Заполнить поле First Name")
    public PracticFormPage typeFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    @Step("Заполнить поле Last Name")
    public PracticFormPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Заполнить поле Email")
    public PracticFormPage typeEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Выбрать радиокнопку Gender")
    public PracticFormPage typeGender(String gender) {
        genderRadio.$(byText(gender)).click();
        return this;
    }

    @Step("Заполнить поле Mobile")
    public PracticFormPage typeMobile(String mobile) {
        mobileInput.setValue(mobile);
        return this;
    }

    @Step("Выбрать в календаре Date of Birth")
    public PracticFormPage typeCalendar(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Заполнить поле Subjects")
    public PracticFormPage typeSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    @Step("Выбрать чекбоксы Hobbies")
    public PracticFormPage typeHobbies(String[] hobbies) {
        for (var hobby : hobbies) {
            hobbiesCheckBox.$(byText(hobby)).click();
        }
        return this;
    }

    @Step("Загрузить картинку")
    public PracticFormPage typePicture(String nameOfPicture) {
        uploadPicture.uploadFromClasspath("image/" + nameOfPicture);
        return this;
    }

    @Step("Заполнить поле Current Address")
    public PracticFormPage typeAddress(String address) {
        addressInput.setValue(address).scrollTo().click();
        return this;
    }

    @Step("Выбрать в выпадающем списке State")
    public PracticFormPage typeState(String state) {
        stateForm.setState(state);
        return this;
    }

    @Step("Выбрать в выпадающем списке City")
    public PracticFormPage typeCity(String city) {
        cityForm.setCity(city);
        return this;
    }

    @Step("Нажать кнопку Submit")
    public void typeSubmit() {
        submitButton.click();
    }

    @Step("Проверить заголовок в сабмит-форме")
    public void checkResultHeader(String modalTitle) {
        $("#example-modal-sizes-title-lg").shouldHave(text(modalTitle));
    }

    @Step("Проверить поле {key}")
    public PracticFormPage checkResultBody(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
