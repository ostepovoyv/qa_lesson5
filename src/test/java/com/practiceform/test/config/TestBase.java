package com.practiceform.test.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.practiceform.test.testdata.PracticeFormData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeAll
    public static void setUpMain(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 100000;
//        Configuration.browser= "firefox";
        Configuration.baseUrl= PracticeFormData.baseUrl;
//        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    public void beforeEachTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    public static void afterAllTest(){
        Selenide.closeWebDriver();
    }
}
