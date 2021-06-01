package com.learning.extra;

public class StringTest {
    public static void main(String[] args) {
        String first = "let2 own kit dig";
        String second = "let3 art zero";
        System.out.println(first.substring(first.indexOf(" ")+1));
        System.out.println(second.substring(second.indexOf(" ")));
    }
}
