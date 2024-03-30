package ru.gb;

import com.google.common.base.Joiner;

/**
 * example maven project generated from idea
 */
public class Main {
    public static void main(String[] args) {
        String[] words = {"Hello", "World"};
        String message = Joiner.on(", ").join(words);
        System.out.println(message);
    }
}