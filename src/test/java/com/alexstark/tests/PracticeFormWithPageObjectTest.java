package com.alexstark.tests;

import com.alexstark.pages.PracticFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectTest extends TestBase {

    PracticFormPage practicFormPage = new PracticFormPage();

    private String
            firstName = "Alexander",
            lastName = "Derevyanko",
            email = "alexstark@mail.ru",
            gender = "Male",
            mobile = "9995551122",
            day = "20",
            month = "June",
            year = "1992",
            subjects = "Computer science",
            hobbies[]  = {"Sports","Reading"},
            address = "S.Petersburg,Nevskiy st. house 40",
            state = "Rajasthan",
            city = "Jaipur",
            nameOfPicture = "test.jpg",
            exampleModalTitle = "Thanks for submitting the form";


    @Test
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
        practicFormPage.checkResultBody("Student Name", firstName + " " + lastName)
                   .checkResultBody("Student Email", email)
                   .checkResultBody("Mobile", mobile)
                   .checkResultBody("Date of Birth", day + " " + month + "," + year)
                   .checkResultBody("Subjects", subjects)
                   .checkResultBody("Hobbies",hobbies[0] + ", " + hobbies[1])
                   .checkResultBody("Picture", nameOfPicture)
                   .checkResultBody("Address", address)
                   .checkResultBody("State and City", state + " " + city);
    }
}