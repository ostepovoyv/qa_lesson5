package com.practiceForm.test.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeModalFromPage {

    private SelenideElement
            modalHeader = $(".modal-content"),
            modalBody = $(".modal-body"),
            modalFooter = $(".modal-footer"),
            modalTable = $(".table-responsive");

    public PracticeModalFromPage modalContentVerify(String value){
        modalHeader.shouldBe(visible)
                .shouldHave(Condition.text(value));
        return this;
    }

    private void verifyLabelWithValues(String label, String value){
        modalTable.find(byText(label)).parent().shouldHave(text(value));
    }

    public PracticeModalFromPage modalFormTableTextVerifyResults(String firstName,
                                                                 String lastName,
                                                                 String email,
                                                                 String gender,
                                                                 String phoneNumber,
                                                                 String dateOfBirthDay,
                                                                 String dateOfBirthMonth,
                                                                 String dateOfBirthYear,
                                                                 String subject,
                                                                 String hobbies,
                                                                 String pictureName,
                                                                 String currentAdress,
                                                                 String state,
                                                                 String city){
        modalBody.shouldHave(
                text("Label"),
                text("Values"));

        verifyLabelWithValues("Student Name",firstName + " " + lastName);
        verifyLabelWithValues("Student Email",email);
        verifyLabelWithValues("Gender",gender);
        verifyLabelWithValues("Mobile",phoneNumber);
        verifyLabelWithValues("Date of Birth",dateOfBirthDay + " " + dateOfBirthMonth + "," + dateOfBirthYear);
        verifyLabelWithValues("Subjects",subject);
        verifyLabelWithValues("Hobbies",hobbies);
        verifyLabelWithValues("Picture",pictureName);
        verifyLabelWithValues("Address",currentAdress);
        verifyLabelWithValues("State and City",state + " " + city);

        modalFooter.find("#closeLargeModal").shouldHave(text("Close")).click();
        return this;
    }
}
