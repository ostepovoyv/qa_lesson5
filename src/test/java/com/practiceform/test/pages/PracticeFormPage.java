package com.practiceform.test.pages;

import com.codeborne.selenide.SelenideElement;
import com.practiceform.test.components.CalendarComponent;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            userNumberInput =  $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureLoader = $("#uploadPicture"),
            currentAddressTextarea =  $("#currentAddress"),
            stateSelect = $("#state"),
            stateCityWrapper= $("#stateCity-wrapper"),
            citySelect =  $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    @Step("Открываем форму")
    public PracticeFormPage openPracticeFrom(String value){
        open("/automation-practice-form");
        formTitle.shouldHave(text(value));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Заполняем имя {value}")
    public PracticeFormPage setFirstName(String value){
        this.firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем фамилию {value}")
    public PracticeFormPage setLastName(String value){
        this.lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем email {value}")
    public PracticeFormPage setEmail(String value){
        this.emailInput.setValue(value);
        return this;
    }

    @Step("Заполняем пол {value}")
    public PracticeFormPage setGender(String value){
        this.genderRadioButton.find(byText(value)).click();
        return this;
    }

    @Step("Заполняем номер телефона {value}")
    public PracticeFormPage setUserNumber(String value){
        this.userNumberInput.setValue(value);
        return this;
    }

    @Step("Заполняем ДР {dateOfBirthDay}.{dateOfBirthMonth}.{dateOfBirthYear}")
    public PracticeFormPage setDateOfBirth(String dateOfBirthMonth, String dateOfBirthYear, String dateOfBirthDay){
        dateOfBirthInput.click();
        calendarComponent.setBirthDate(dateOfBirthMonth, dateOfBirthYear, dateOfBirthDay);
        return this;
    }

    @Step("Заполняем предметы {value}")
    public PracticeFormPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Заполняем хобби {value}")
    public PracticeFormPage setHobbies(String value) {
        hobbiesWrapper.find(byText(value)).click();
        return this;
    }

    @Step("Загружаем изображение")
    public PracticeFormPage uploadPicture(String path, String pictureName) {
        pictureLoader.uploadFile(new File(path + pictureName));
        return this;
    }

    @Step("Заполняем адрес {value}")
    public PracticeFormPage setCurrentAddress(String value) {
        currentAddressTextarea.setValue(value);
        return this;
    }

    @Step("Заполняем штат {state} и город {city}")
    public PracticeFormPage setStateAndCity(String state, String city) {
        stateSelect.scrollTo().click();
        stateCityWrapper.find(byText(state)).click();
        citySelect.click();
        cityWrapper.find(byText(city)).click();
        return this;
    }

    @Step("нажимаем кнопку Submit")
    public PracticeFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

}
