package com.learning.extra;

import java.util.*;
public class Generate16Digit2 {
    private static int size = 4;

    public static void main(String []args){
        List<String> res = new ArrayList<>();
        helper(-1, ' ', "", res);
        System.out.println(res.size());
    }

    // odd - prime
    // even - even
    // prime digits : [2, 3, 5, 7]
    // even digits:    [0, 2, 4, 8]

    static void helper(int i, char c, String s, List<String> res) {
        if (c != ' ') {
            s += c;
        }
        if (s.length() == size) {
            res.add(s);
            return;
        }

        int j = i + 1;

        if (i % 2 == 0) {
            helper(j, '0', s, res);
            helper(j, '2', s, res);
            helper(j, '4', s, res);
            helper(j, '8', s, res);
        } else {
            helper(j, '2', s, res);
            helper(j, '3', s, res);
            helper(j, '5', s, res);
            helper(j, '7', s, res);
        }

    }
}
