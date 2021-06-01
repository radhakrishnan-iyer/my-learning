package com.learning.extra;

import java.util.Arrays;

public class ShoppingOptions {

    public static void main(String[] args) {
        int[] priceOfJeans = new int[] {2, 3};
        int[] priceOfShoes = new int[]{4};
        int[] priceOfSkirts = new int[] {2, 3};
        int[] priceOfTops = new int[] {1, 2};
        int budgeted = 10;
        System.out.println(getOptions(priceOfJeans,priceOfShoes,priceOfSkirts,priceOfTops, budgeted));
    }

    private static int getOptions(int[] a, int[] b, int[] c, int[] d, int dollars) {
        int longest = Math.max(a.length, Math.max(b.length, Math.max(c.length, d.length)));

        if (d.length == longest) {
            return helper(d, a, b, c, dollars);
        }

        if (c.length == longest) {
            return helper(c, a, b, d, dollars);
        }

        if (b.length == longest) {
            return helper(b, a, c, d, dollars);
        }

        return helper( a,b, c, d, dollars);
    }

    private static int helper(int[] longest, int[] a, int[] b, int[] c, int dollars) {
        Arrays.sort(longest);
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int[] abSum = new int[a.length * b.length];
        int index = 0;
        for (int ai : a) {
            if (ai >= dollars) {
                break;
            }

            for (int bi : b) {
                if (bi >= dollars) {
                    break;
                }

                if (ai + bi < dollars) {
                    abSum[index++] = ai + bi;
                } else {
                    break;
                }
            }
        }

        int abcIndex = 0;
        int[] abcSum = new int[index * c.length];
        for (int i = 0; i < index; i++) {
            if (abSum[i] == 0) {
                break;
            }

            for (int ci : c) {
                if (ci >= dollars) {
                    break;
                }

                if (abSum[i] + ci < dollars) {
                    abcSum[abcIndex++] = abSum[i] + ci;
                } else {
                    break;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < abcIndex; i++) {
            if (abcSum[i] == 0) {
                break;
            }

            for (int di : longest) {
                if (abcSum[i] + di <= dollars) {
                    result++;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}

