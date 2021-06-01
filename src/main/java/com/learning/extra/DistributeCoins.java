package com.learning.extra;

public class DistributeCoins {
    public static void main(String[] args) {
        System.out.println(solve(3,2,2));
    }

    static int solve(int N, int M ,int C){
        //Your code goes here
        int result = 0;
        int resArr[][] = new int[M + 1][N + 1];
        resArr[0][0] = 0;
        for(int i=1; i <= N; i++)
        {
            resArr[0][i] = -1;
        }

        for(int i=1; i <= M; i++)
        {
            resArr[i][0] = 1;
        }


        for(int i=1; i <= M; i++)
        {
            for(int j=1; j <= N; j++)
            {
                if(i==1) {
                    if(j>C) {
                        resArr[i][j] = -1;
                        continue;
                    }
                    else {
                       resArr[i][j] = 1;
                    }
                }
                for(int k=j; k >= 0; k--)
                {
                    if(k > C)
                    {
                        continue;
                    }
                    int tmp = resArr[i - 1][j -k] % (1000000000 + 7);
                    if(tmp != -1)
                        resArr[i][j] += tmp % (1000000000 + 7);
                }
            }
        }
        return resArr[M][N];
    }
}
