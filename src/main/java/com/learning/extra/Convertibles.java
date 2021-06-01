package com.learning.extra;

import java.util.*;
public class Convertibles {
    static int []parent = new int[26];

    // Function for find
// from Disjoint set algorithm
    static int find(int x)
    {
        if (x != parent[x])
            return parent[x] = find(parent[x]);
        return x;
    }

    // Function for the union
// from Disjoint set algorithm
    static void join(int x, int y)
    {
        int px = find(x);
        int pz = find(y);
        if (px != pz)
        {
            parent[px] = pz;
        }
    }
    // Function to check if one String
// can be converted to another.
    static boolean convertible(String s1, String s2)
    {
        // All the characters are checked whether
        // it's either not replaced or replaced
        // by a similar character using a map.
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();

        for (int i = 0; i < s1.length(); i++)
        {
            if (!mp.containsKey(s1.charAt(i) - 'a'))
            {
                mp.put(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            }
            else
            {
                if (mp.get(s1.charAt(i) - 'a') != s2.charAt(i) - 'a')
                    return false;
            }
        }

        // To check if there are cycles.
        // If yes, then they are not convertible.
        // Else, they are convertible.
        for (Map.Entry<Integer, Integer> it : mp.entrySet())
        {
            if (it.getKey() == it.getValue())
                continue;
            else
            {
                if (find(it.getKey()) == find(it.getValue()))
                    return false;
                else
                    join(it.getKey(), it.getValue());
            }
        }
        return true;
    }

    // Function to initialize parent array
// for union and find algorithm.
    static void initialize()
    {
        for (int i = 0; i < 26; i++)
        {
            parent[i] = i;
        }
    }

    // Driver code
    public static void main(String[] args)
    {

        String s1, s2;
        s1 = "abbc";
        s2 = "bccd";
        initialize();
        if (convertible(s1, s2))
            System.out.print("Yes" + "\n");
        else
            System.out.print("No" + "\n");
    }
}
