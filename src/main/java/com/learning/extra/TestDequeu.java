package com.learning.extra;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestDequeu {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        deque.addLast("x");
        deque.addFirst("p");
        System.out.println(deque);
    }
}
