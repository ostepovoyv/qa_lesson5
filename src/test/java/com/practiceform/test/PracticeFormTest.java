package com.practiceform.test;

import com.practiceform.test.config.TestBase;
import com.practiceform.test.pages.PracticeFormPage;
import com.practiceform.test.pages.PracticeModalFormPage;
import com.practiceform.test.testdata.PracticeFormData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Тест формы")
public class PracticeFormTest extends TestBase {

    @Test
    @DisplayName("Заполнение формы")
    public void practiceFromTest() {
        step("Открываем форму", () -> {
            new PracticeFormPage()
                    .openPracticeFrom(PracticeFormData.practiceFormTitleText)
                    .setFirstName(PracticeFormData.firstName)
                    .setLastName(PracticeFormData.lastName)
                    .setEmail(PracticeFormData.email)
                    .setGender(PracticeFormData.gender)
                    .setUserNumber(PracticeFormData.phoneNumber)
                    .setDateOfBirth(PracticeFormData.dateOfBirthMonth,
                            PracticeFormData.dateOfBirthYear,
                            PracticeFormData.dateOfBirthDay)
                    .setSubjects(PracticeFormData.subject)
                    .setHobbies(PracticeFormData.hobbies)
                    .uploadPicture(PracticeFormData.picturePath,
                            PracticeFormData.pictureName)
                    .setCurrentAddress(PracticeFormData.currentAddress)
                    .setStateAndCity(PracticeFormData.state,
                            PracticeFormData.city)
                    .clickSubmitButton();
        });

        step("Проверяем результат на заполненной форме", () -> {
            new PracticeModalFormPage()
                    .verifyModalContent(PracticeFormData.modalFormTitle)
                    .verifymodalBody()
                    .verifyModalFormTableResults("Student Name", PracticeFormData.firstName + " " + PracticeFormData.lastName)
                    .verifyModalFormTableResults("Student Email", PracticeFormData.email)
                    .verifyModalFormTableResults("Gender", PracticeFormData.gender)
                    .verifyModalFormTableResults("Mobile", PracticeFormData.phoneNumber)
                    .verifyModalFormTableResults("Date of Birth", PracticeFormData.dateOfBirthDay + " "
                            + PracticeFormData.dateOfBirthMonth + ","
                            + PracticeFormData.dateOfBirthYear)
                    .verifyModalFormTableResults("Subjects", PracticeFormData.subject)
                    .verifyModalFormTableResults("Hobbies", PracticeFormData.hobbies)
                    .verifyModalFormTableResults("Picture", PracticeFormData.pictureName)
                    .verifyModalFormTableResults("Address", PracticeFormData.currentAddress)
                    .verifyModalFormTableResults("State and City", PracticeFormData.state + " " + PracticeFormData.city)
                    .verifyModalFooter();

        });
    }
}