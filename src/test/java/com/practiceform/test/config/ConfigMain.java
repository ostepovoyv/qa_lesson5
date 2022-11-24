package com.practiceform.test.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.practiceform.test.testdata.PracticeFormData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class ConfigMain {

    @BeforeAll
    public static void setUpMain(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 100000;
//        Configuration.browser= "firefox";
        Configuration.baseUrl= PracticeFormData.BASE_URL;
//        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    public static void afterAllTest(){
        Selenide.closeWebDriver();
    }
}
