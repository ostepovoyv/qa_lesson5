package com.practiceForm.test;

import com.practiceForm.test.Config.ConfigMain;
import com.practiceForm.test.Pages.PracticeFromPage;
import com.practiceForm.test.Pages.PracticeModalFromPage;
import com.practiceForm.test.TestData.PracticeFormData;
import org.junit.jupiter.api.Test;

public class PracticeFromTest extends ConfigMain {

    @Test
    public void practiceFromTest() {
            new PracticeFromPage()
                    .openPracticeFrom(PracticeFormData.PRACTICE_FORM_TITLE_TEXT)
                    .setFirstName(PracticeFormData.FIRST_NAME)
                    .setLastName(PracticeFormData.LAST_NAME)
                    .setEmail(PracticeFormData.EMAIL)
                    .setGender(PracticeFormData.GENDER)
                    .setUserNumber(PracticeFormData.PHONE_NUMBER)
                    .setDateOfBirth(PracticeFormData.DATE_OF_BIRTH_MONTH,
                                    PracticeFormData.DATE_OF_BIRTH_YEAR,
                                    PracticeFormData.DATE_OF_BIRTH_DAY)
                    .setSubjects(PracticeFormData.SUBJECT)
                    .setHobbies(PracticeFormData.HOBBIES)
                    .pictureLoad(PracticeFormData.PICTURE_PATH,
                                 PracticeFormData.PICTURE_NAME)
                    .setCurrentAddress(PracticeFormData.CURRENT_ADDRESS)
                    .setStateAndCity(PracticeFormData.STATE,
                                     PracticeFormData.CITY)
                    .submitButtonClick();

            new PracticeModalFromPage()
                    .modalContentVerify(PracticeFormData.MODAL_FORM_TITLE)
                    .modalBodyTextVerifyResults(
                            PracticeFormData.FIRST_NAME,
                            PracticeFormData.LAST_NAME,
                            PracticeFormData.EMAIL,
                            PracticeFormData.GENDER,
                            PracticeFormData.PHONE_NUMBER,
                            PracticeFormData.DATE_OF_BIRTH_DAY,
                            PracticeFormData.DATE_OF_BIRTH_MONTH,
                            PracticeFormData.DATE_OF_BIRTH_YEAR,
                            PracticeFormData.SUBJECT,
                            PracticeFormData.HOBBIES,
                            PracticeFormData.PICTURE_NAME,
                            PracticeFormData.CURRENT_ADDRESS,
                            PracticeFormData.STATE,
                            PracticeFormData.CITY);
    }
}
