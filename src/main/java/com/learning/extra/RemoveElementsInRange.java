package com.learning.extra;

public class RemoveElementsInRange {
    public static void main(String[] args) {
        //		5
        //	3		7
        //2	   4   6   8

        Node head = new Node();
        head.val = 5;
        head.left = new Node();
        head.left.val = 3;
        head.right = new Node();
        head.right.val = 7;

        head.left.left = new Node();
        head.left.left.val = 2;
        head.left.right = new Node();
        head.left.right.val = 4;

        head.right.left = new Node();
        head.right.left.val = 6;
        head.right.right = new Node();
        head.right.right.val = 8;

        head = removeElementsInRange(5 , 7 , head);

        printInorder(head);
    }

    static void  printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.val + " ");

        /* now recur on right child */
        printInorder(node.right);
    }


    static class Node {
        int val;
        Node left;
        Node right;
    }

    static Node removeElementsInRange(int start, int end , Node head) {
        if(head==null)
            return null;
        if(head.left==null && head.right==null) {
            if(head.val>=start && head.val<=end)
                return null;
            return head;
        }

        Node left = removeElementsInRange(start , end , head.left);
        Node right = removeElementsInRange(start, end , head.right);
        if(head.val >= start && head.val <= end) {
            return merge(left , right);
        }

        head.left = left;
        head.right = right;
        return  head;
    }

    static Node merge(Node head1, Node head2) {
        if(head2.left==null) {
            head2.left = head1;
            return head2;
        }

        if(head1.right==null) {
            head1.right = head2;
            return head1;
        }
        Node x = head2;
        while(x.left!=null) {
            x=x.left;
        }
        x.left = head1;
        return head2;
    }
}
