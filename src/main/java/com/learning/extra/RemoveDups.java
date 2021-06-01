package com.learning.extra;

public class RemoveDups {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        //root.next.next.next = new ListNode(3);
        //root.next.next.next.next = new ListNode(3);
        root = deleteDuplicates(root);
        while(root!=null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null) {
            while(prev!=null && curr!=null && prev.val == curr.val) {
                prev.next = curr.next;
                if(prev.next!=null) {
                    prev = curr.next;
                    curr = prev.next;
                } else {
                    curr = null;
                }
            }
            if(prev!=null && curr!=null && prev.val != curr.val) {
                prev = prev.next;
                curr = curr.next;
            }
        }

        while(prev!=null) {

        }

        return head;
    }

    static class ListNode {
        ListNode next;
        int val;
        ListNode(int x) { val = x; }
    }
}
