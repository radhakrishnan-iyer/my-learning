package com.learning.extra;

import java.util.HashSet;

public class TestSet {
    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        root.left = new Node();
        root.left.val = 2;

        root.right = new Node();
        root.right.val = 3;

        root.right.left = root.left;

        HashSet<Node> set = new HashSet<Node>();
        set.add(root);
        set.add(root.left);

        System.out.println(set.contains(root.right.left));
    }

    static class Node {
        int val;
        Node left;
        Node right;
    }
}
