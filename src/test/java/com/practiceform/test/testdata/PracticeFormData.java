package com.practiceform.test.testdata;

import com.github.javafaker.Faker;
import com.practiceform.test.utils.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class PracticeFormData {

    static Faker faker = new Faker();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy", Locale.ENGLISH);

    public static String baseUrl = "https://demoqa.com";
    public static String practiceFormTitleText = "Student Registration Form";
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = getRandomEmail(11);
    public static String gender = getRandomGender();
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static Date dateOfBirth = faker.date().birthday(18,105);
    public static String dateOfBirthYear = getYearFromDateOfBirth(dateOfBirth);
    public static String dateOfBirthMonth = getMonthFromDateOfBirth(dateOfBirth);
    public static String dateOfBirthDay = getDayFromDateOfBirth(dateOfBirth);
    public static String subject = "Computer Science";
    public static String hobbies = getRandomHobbies();
    public static String picturePath = "src/test/resources/";
    public static String pictureName = "picture.png";
    public static String currentAddress = faker.address().fullAddress();
    public static String state = getRandomState();
    public static String city = getRandomCity(state);
    public static String modalFormTitle = "Thanks for submitting the form";

    public static String getRandomEmail(int length) {
        return RandomUtils.getRandomString(length) + "@test.com";
    }

    public static String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        int index = RandomUtils.getRandomInt(0, gender.length - 1);
        return gender[index];
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int index = RandomUtils.getRandomInt(0, hobbies.length - 1);
        return hobbies[index];
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int index = RandomUtils.getRandomInt(0, states.length - 1);
        return states[index];
    }

    public static String getRandomCity(String state) {
        String[] cityForNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] cityForUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] cityForHaryana = {"Karnal", "Panipat"};
        String[] cityForRajasthan = {"Jaipur", "Jaiselmer"};
        Map<String, String[]> map = new HashMap<>();
        map.put("NCR", cityForNCR);
        map.put("Uttar Pradesh", cityForUttarPradesh);
        map.put("Haryana", cityForHaryana);
        map.put("Rajasthan", cityForRajasthan);
        String[] cities = map.get(state);
        int index = RandomUtils.getRandomInt(0, cities.length - 1);
        return cities[index];
    }

    public static String getDayFromDateOfBirth(Date date) {
        String[] dates = sdf.format(date).split(" ");
        return dates[0];
    }

    public static String getMonthFromDateOfBirth(Date date) {
        String[] dates = sdf.format(date).split(" ");
        return dates[1];
    }

    public static String getYearFromDateOfBirth(Date date) {
        String[] dates = sdf.format(date).split(" ");
        return dates[2];
    }

}
