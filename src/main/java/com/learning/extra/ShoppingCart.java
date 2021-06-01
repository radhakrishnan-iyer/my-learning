package com.learning.extra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {

    public static void main(String[] args) {
        List<List<String>> codeList = new ArrayList<>();
        List<String> t = new ArrayList<>();
        t.add("apple");
        t.add("apple");
        codeList.add(new ArrayList<>(t));
        t.clear();
        t.add("banana");
        t.add("anything");
        t.add("banana");
        codeList.add(new ArrayList<>(t));
        t.clear();

        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("orange");
        shoppingList.add("apple");
        shoppingList.add("apple");
        shoppingList.add("banana");
        shoppingList.add("orange");
        shoppingList.add("banana");
        System.out.println(process(codeList , shoppingList));

        codeList.clear();
        shoppingList.clear();
        t = new ArrayList<>();
        t.add("apple");
        t.add("appricot");
        codeList.add(new ArrayList<>(t));
        t.clear();
        t.add("banana");
        t.add("anything");
        t.add("guava");
        codeList.add(new ArrayList<>(t));
        t.clear();
        t.add("papaya");
        t.add("anything");
        codeList.add(new ArrayList<>(t));
        t.clear();

        shoppingList = new ArrayList<>();
        shoppingList.add("banana");
        shoppingList.add("orange");
        shoppingList.add("guava");
        shoppingList.add("apple");
        shoppingList.add("appricot");
        shoppingList.add("papaya");
        shoppingList.add("kiwi");

        System.out.println(process(codeList , shoppingList));
    }
    private static boolean process(List<List<String>> codeList, List<String> shoppingList) {
        List<String> tmp = codeList.stream().flatMap(l -> l.stream()).collect(Collectors.toList());

        if(shoppingList.size() < tmp.size())
            return false;

        int m = tmp.size();
        int n = shoppingList.size();

        int i = 0;
        int j =0;
        while(j<n) {
            if(tmp.get(i).equals("anything")) {
                i++;
                j++;
            } else if(tmp.get(i).equals(shoppingList.get(j))) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if(i==m && j==n)
            return true;
        return false;
    }
}
