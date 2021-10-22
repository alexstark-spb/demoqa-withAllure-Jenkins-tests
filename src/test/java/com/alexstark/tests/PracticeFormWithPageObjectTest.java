package com.alexstark.tests;

import com.alexstark.pages.PracticFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PracticeFormWithPageObjectTest extends TestBase {

    private PracticFormPage practicFormPage = new PracticFormPage();
    private Faker faker = new Faker();

    private String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.phoneNumber().subscriberNumber(10),
            day = "15",
            month = "May",
            year = "1995",
            subjects = "Computer science",
            hobbies[] = {"Sports", "Reading"},
            address = faker.address().streetAddress(),
            state = "Rajasthan",
            city = "Jaipur",
            nameOfPicture = "test.jpg",
            exampleModalTitle = "Thanks for submitting the form";

    @Test
    @Tag("RegistrationForm")
    @Feature("Forms")
    @Story("Заполнение форм")
    @Owner("Alex Derevyanko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение Student Registration Form")
    void fillFormTest() {
        practicFormPage.openPage();
        practicFormPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeGender(gender)
                .typeMobile(mobile)
                .typeCalendar(day, month, year)
                .typeSubjects(subjects)
                .typeHobbies(hobbies)
                .typePicture(nameOfPicture)
                .typeAddress(address)
                .typeState(state)
                .typeCity(city)
                .typeSubmit();

        practicFormPage.checkResultHeader(exampleModalTitle);
        step("Проверить основные поля в сабмит-форме", () -> {
            practicFormPage.checkResultBody("Student Name", firstName + " " + lastName)
                    .checkResultBody("Student Email", email)
                    .checkResultBody("Mobile", mobile)
                    .checkResultBody("Date of Birth", day + " " + month + "," + year)
                    .checkResultBody("Subjects", subjects)
                    .checkResultBody("Hobbies", hobbies[0] + ", " + hobbies[1])
                    .checkResultBody("Picture", nameOfPicture)
                    .checkResultBody("Address", address)
                    .checkResultBody("State and City", state + " " + city);
        });
    }
}