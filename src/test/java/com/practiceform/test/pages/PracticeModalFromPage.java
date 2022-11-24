package com.practiceform.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.practiceform.test.testdata.PracticeFormData;

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

    public PracticeModalFromPage verifymodalBody(){
        modalBody.shouldHave(
                text("Label"),
                text("Values"));
        return this;
    }

    public PracticeModalFromPage verifyModalFormTableResults(String label, String values){
        verifyLabelWithValues(label,values);
        return this;
    }

    public PracticeModalFromPage verifyModalFooter(){
        modalFooter.find("#closeLargeModal").shouldHave(text("Close")).click();
        return this;
    }
}
