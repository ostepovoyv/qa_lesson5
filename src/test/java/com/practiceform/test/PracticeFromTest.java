package com.practiceform.test;

import com.practiceform.test.config.ConfigMain;
import com.practiceform.test.pages.PracticeFromPage;
import com.practiceform.test.pages.PracticeModalFromPage;
import com.practiceform.test.testdata.PracticeFormData;
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
                    .uploadPicture(PracticeFormData.PICTURE_PATH,
                                 PracticeFormData.PICTURE_NAME)
                    .setCurrentAddress(PracticeFormData.CURRENT_ADDRESS)
                    .setStateAndCity(PracticeFormData.STATE,
                                     PracticeFormData.CITY)
                    .clickSubmitButton();

            new PracticeModalFromPage()
                    .verifyModalContent(PracticeFormData.MODAL_FORM_TITLE)
                    .verifyModalFormTableResults();
    }
}
