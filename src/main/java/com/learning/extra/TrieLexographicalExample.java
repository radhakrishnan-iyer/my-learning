package com.learning.extra;

import java.util.Stack;

public class TrieLexographicalExample {

    public static void main(String[] args) {
        System.out.println(findKthNumber(2,2));
    }

    static class Trie {
        Trie[] children;
        boolean isEnd;
        int num;
        Trie() {
            children = new Trie[10];
        }
    }

    static Trie root;
    static int count;

    public static int findKthNumber(int n, int k) {
        if(n==0)
            return 0;
        if(k>n)
            return 0;
        count = k;
        buildTrie(n);
        return dfs(root);
    }

    private static void buildTrie(int n) {
        root = new Trie();
        Trie temp = root;
        for(int i=1;i<=n;i++) {
            temp = root;
            String s = i+"";
            for(int j=0;j<s.length();j++) {
                int x = s.charAt(j)-'0';
                if(temp.children[x]==null)
                    temp.children[x] = new Trie();
                temp = temp.children[x];
            }
            temp.isEnd = true;
            temp.num = i;
        }
    }

    private static int dfs(Trie root) {
        if(count==0)
            return root.num;
        int tempAns = 0;
        Stack<Temp> stack = new Stack<>();
        Temp x = new Temp(root , 0);
        stack.push(x);
        while (!stack.isEmpty()) {
            Temp p = stack.pop();
            root = p.trie;
            for (int i = p.k+1; i < 10 && count != 0;i++ ) {
                if (root.children[i] != null) {
                    count--;
                    p = new Temp(root , i);
                    stack.push(p);
                    root = root.children[i];
                    if(root.isEnd && count==0)
                        return root.num;
                    i = -1;
                } else if (i > 0) {
                    break;
                }
            }
        }
        return root.isEnd ? root.num : -1;
    }

    static class  Temp {
        Trie trie;
        int k;
        Temp(Trie trie, int k) {
            this.trie = trie;
            this.k = k;
        }
    }
}
