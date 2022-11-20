package com.practiceForm.test.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement datepickerMonth = $(".react-datepicker__month-select"),
            datepickerYear = $(".react-datepicker__year-select");
//            datepickerDay = $(".react-datepicker__day--0" + dateOfBirthDay + "");

    public void setBirthDate(String dateOfBirthMonth, String dateOfBirthYear, String dateOfBirthDay) {
        datepickerMonth.selectOption(dateOfBirthMonth);
        datepickerYear.selectOption(dateOfBirthYear);
        $(".react-datepicker__day--0" + dateOfBirthDay +
                ":not(.react-datepicker__day--outside-month)").click();
    }

}
