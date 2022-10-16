package com.example.lab21.utils;

import java.util.regex.Pattern;

public class TxtCounter {
    public static int getSymbolsCount(String phrase){
        return phrase.length();
    }
    public static int getWordsCount(String words){
        String[] wordsArray = words.split("[ ,.]");
        return wordsArray.length;

    }
}