package id.fahrizal.test;

import org.junit.Test;

public class Test3 {

    @Test
    public void abc (String[] args) {
        // keep this function call here
        int[] s= new int[7];
        s[0] = 44;
        s[1] =30;
        s[2] =24;
        s[3] =32;
        s[4] =35;
        s[5] =30;
        s[6] =40;
        s[7] =38;
        s[8] =15;
        System.out.print(ArrayChallenge(s));
    }

    public static int ArrayChallenge(int[] arr) {
        // code goes here
        int maximum = 0;
        int[] dp = new int[arr.length+1];

        dp[0] = 0;
        maximum = 0;

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = arr[i-1];

            if( curr > dp[i-1]) {
                dp[i] = (curr - prev) + dp[i-1];
            }
            else {
                dp[i] = dp[i-1];
            }
        }

        return dp[arr.length];
    }
}
