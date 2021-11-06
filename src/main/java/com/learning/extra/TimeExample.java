package com.learning.extra;

import java.time.LocalDateTime;

public class TimeExample {
    public static void main(String[] args) {
        LocalDateTime dateTime  = LocalDateTime.of(2021, 8, 23, 22, 20);
        System.out.println(dateTime);
        dateTime = dateTime.plusMinutes(400);
        System.out.println(dateTime);
    }
}
