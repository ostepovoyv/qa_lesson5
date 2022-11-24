package com.practiceform.test.utils;
import java.util.Random;

public class RandomUtils {

    public static String getRandomString(int length) {
        String randomCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        while (result.length() < length) {
            int index = (int) (random.nextFloat() * randomCharacters.length());
            result.append(randomCharacters.charAt(index));
        }
        return result.toString();
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
