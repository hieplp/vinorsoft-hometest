package com.vinorsoft.nhanvien.common.util;


import com.vinorsoft.nhanvien.common.enums.IdLength;

import java.util.concurrent.ThreadLocalRandom;

public class GeneratorUtil {
    private static final String CHAR_LIST = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_LIST_NUMBER = "0123456789";
    private static final String CHAR_LIST_UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static String randomString(int length) {
        StringBuilder userId = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = ThreadLocalRandom.current().nextInt(CHAR_LIST_UPPER_ALPHABET.length());
            userId.append(CHAR_LIST_UPPER_ALPHABET.charAt(index));
        }
        return userId.toString();
    }

    public static String generateId(IdLength idLength) {
        return randomString(idLength.getLength());
    }

}
