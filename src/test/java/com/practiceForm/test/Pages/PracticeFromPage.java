package com.practiceForm.test.Pages;

import com.codeborne.selenide.SelenideElement;
import com.practiceForm.test.Components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFromPage {

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

    public PracticeFromPage openPracticeFrom(String value){
        open("/automation-practice-form");
        formTitle.shouldHave(text(value));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public PracticeFromPage setFirstName(String value){
        this.firstNameInput.setValue(value);
        return this;
    }

    public PracticeFromPage setLastName(String value){
        this.lastNameInput.setValue(value);
        return this;
    }

    public PracticeFromPage setEmail(String value){
        this.emailInput.setValue(value);
        return this;
    }

    public PracticeFromPage setGender(String value){
        this.genderRadioButton.find(byText(value)).click();
        return this;
    }

    public PracticeFromPage setUserNumber(String value){
        this.userNumberInput.setValue(value);
        return this;
    }

    public PracticeFromPage setDateOfBirth(String dateOfBirthMonth, String dateOfBirthYear, String dateOfBirthDay){
        dateOfBirthInput.click();
        calendarComponent.setBirthDate(dateOfBirthMonth, dateOfBirthYear, dateOfBirthDay);
        return this;
    }

    public PracticeFromPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFromPage setHobbies(String value) {
        hobbiesWrapper.find(byText(value)).click();
        return this;
    }

    public PracticeFromPage pictureLoad(String path, String pictureName) {
        pictureLoader.uploadFile(new File(path + pictureName));
        return this;
    }

    public PracticeFromPage setCurrentAddress(String value) {
        currentAddressTextarea.setValue(value);
        return this;
    }

    public PracticeFromPage setStateAndCity(String state, String city) {
        stateSelect.scrollTo().click();
        stateCityWrapper.find(byText(state)).click();
        citySelect.click();
        cityWrapper.find(byText(city)).click();
        return this;
    }

    public PracticeFromPage submitButtonClick() {
        submitButton.click();
        return this;
    }

}
