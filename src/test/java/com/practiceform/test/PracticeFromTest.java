package com.practiceform.test;

import com.practiceform.test.config.TestBase;
import com.practiceform.test.pages.PracticeFromPage;
import com.practiceform.test.pages.PracticeModalFromPage;
import com.practiceform.test.testdata.PracticeFormData;
import org.junit.jupiter.api.Test;

public class PracticeFromTest extends TestBase {

    @Test
    public void practiceFromTest() {
            new PracticeFromPage()
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

            new PracticeModalFromPage()
                    .verifyModalContent(PracticeFormData.modalFormTitle)
                    .verifymodalBody()
                    .verifyModalFormTableResults("Student Name",PracticeFormData.firstName + " " + PracticeFormData.lastName)
                    .verifyModalFormTableResults("Student Email", PracticeFormData.email)
                    .verifyModalFormTableResults("Gender", PracticeFormData.gender)
                    .verifyModalFormTableResults("Mobile", PracticeFormData.phoneNumber)
                    .verifyModalFormTableResults("Date of Birth",PracticeFormData.dateOfBirthDay + " "
                                                                     + PracticeFormData.dateOfBirthMonth + ","
                                                                     + PracticeFormData.dateOfBirthYear)
                    .verifyModalFormTableResults("Subjects", PracticeFormData.subject)
                    .verifyModalFormTableResults("Hobbies", PracticeFormData.hobbies)
                    .verifyModalFormTableResults("Picture", PracticeFormData.pictureName)
                    .verifyModalFormTableResults("Address", PracticeFormData.currentAddress)
                    .verifyModalFormTableResults("State and City",PracticeFormData.state + " " + PracticeFormData.city)
                    .verifyModalFooter();
    }
}