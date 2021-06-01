package com.learning.extra;

import java.util.Arrays;
import java.util.TreeMap;

public class ShoppingOptions_Better {

    public static void main(String[] args) {
        int[] priceOfJeans = new int[] {2, 3};
        int[] priceOfShoes = new int[]{4};
        int[] priceOfSkirts = new int[] {2, 3};
        int[] priceOfTops = new int[] {1, 2};
        int budgeted = 10;
        System.out.println(getNumberOfOptions(priceOfJeans,priceOfShoes,priceOfSkirts,priceOfTops, budgeted));
    }

    public static int getNumberOfOptions(int[] priceOfJeans,
                                  int[] priceOfShoes,
                                  int[] priceOfSkirts,
                                  int[] priceOfTops,
                                  int dollar){
        int rst = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int priceOfJean : priceOfJeans) {
            for (int priceOfShoe : priceOfShoes) {
                int sum = priceOfJean + priceOfShoe;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int priceOfSkirt : priceOfSkirts) {
            for (int priceOfTop : priceOfTops) {
                int sum = priceOfSkirt + priceOfTop;
                Integer curr = map.ceilingEntry(dollar - sum).getValue();
                rst += curr == null ? 0 : curr;
            }
        }
        return rst;
    }
}

