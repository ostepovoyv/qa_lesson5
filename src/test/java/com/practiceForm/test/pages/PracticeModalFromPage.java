package com.practiceForm.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.practiceForm.test.testData.PracticeFormData;

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

    public PracticeModalFromPage verifyModalContent(String value){
        modalHeader.shouldBe(visible)
                .shouldHave(Condition.text(value));
        return this;
    }

    private void verifyLabelWithValues(String label, String value){
        modalTable.find(byText(label)).parent().shouldHave(text(value));
    }

    public PracticeModalFromPage verifyModalFormTableResults(){

        modalBody.shouldHave(
                text("Label"),
                text("Values"));

        verifyLabelWithValues("Student Name",PracticeFormData.FIRST_NAME + " " + PracticeFormData.LAST_NAME);
        verifyLabelWithValues("Student Email",PracticeFormData.EMAIL);
        verifyLabelWithValues("Gender",PracticeFormData.GENDER);
        verifyLabelWithValues("Mobile",PracticeFormData.PHONE_NUMBER);
        verifyLabelWithValues("Date of Birth",PracticeFormData.DATE_OF_BIRTH_DAY + " "
                                                        + PracticeFormData.DATE_OF_BIRTH_MONTH + ","
                                                        + PracticeFormData.DATE_OF_BIRTH_YEAR);
        verifyLabelWithValues("Subjects",PracticeFormData.SUBJECT);
        verifyLabelWithValues("Hobbies",PracticeFormData.HOBBIES);
        verifyLabelWithValues("Picture",PracticeFormData.PICTURE_NAME);
        verifyLabelWithValues("Address",PracticeFormData.CURRENT_ADDRESS);
        verifyLabelWithValues("State and City",PracticeFormData.STATE + " " + PracticeFormData.CITY);

        modalFooter.find("#closeLargeModal").shouldHave(text("Close")).click();
        return this;
    }
}
