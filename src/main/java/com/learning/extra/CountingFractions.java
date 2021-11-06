package com.learning.extra;

public class CountingFractions {

    public static void main(String[] args) {
        System.out.println(euler(8));
    }

    static int euler(int x){
        int ans = x;

        for(int i=2;i*i<=x;i++){
            if(x%i == 0){
                while(x%i == 0) x/=i;
                ans = ans - ans/i;
            }
        }
        if(x > 1){
            ans = ans - ans/x;
        }
        return ans;

    }
}
