package com.learning.extra;

public class GcdProblem {

    static long gcd(long a, long b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    static long lcm (long a, long b , long gcd) {
        return (a*b)/gcd;
    }

    static long getCommonDivisorInRange(long x, long y, long s, long t) {
        long gcd = gcd(x,y);
        long lcm = lcm(x, y, gcd);
        if(lcm<s) {
            while (lcm < s) {
                lcm = gcd * lcm;
            }
        }
        else if(lcm > t) {
            while(lcm > t) {
                lcm = lcm / gcd;
            }
        }
        return lcm;
    }

    //Main logic for each x,y,s,t,l,r combination
    static long solve(long x, long y, long s, long t, long l, long r) {
        long commonDivisor = getCommonDivisorInRange(x, y, s, t);
        while(r>=l) {
            System.out.println(commonDivisor + " : " + r);
            if(commonDivisor%r==0)
                return r;
            r--;
        }
        return -1;
    }

    public static void main(String[] args) {
       // System.out.println(solve(4,8,1,10,61,78));
       // System.out.println(solve(5,10,2,17,3,4));
        System.out.println(solve(42187,71240,3005401880L,3005401880L,99,99));
    }
}
